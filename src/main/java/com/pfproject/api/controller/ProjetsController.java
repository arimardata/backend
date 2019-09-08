package com.pfproject.api.controller;

import com.pfproject.api.converter.ConverterFacade;
import com.pfproject.api.dto.project.ProjectDTO;
import com.pfproject.api.model.AppelOffre;
import com.pfproject.api.model.personnel.Administratif;
import com.pfproject.api.model.personnel.Permanent;
import com.pfproject.api.model.personnel.Saisonier;
import com.pfproject.api.model.project.Materiel;
import com.pfproject.api.model.project.Personnel;
import com.pfproject.api.model.project.Project;
import com.pfproject.api.model.project.Step;
import com.pfproject.api.model.stock.Consomable;
import com.pfproject.api.model.stock.Non_consomable;
import com.pfproject.api.service.project.ProjectService;
import com.pfproject.api.service.Personnel.AdministratifService;
import com.pfproject.api.service.Personnel.PermanentService;
import com.pfproject.api.service.Personnel.SaisonierService;
import com.pfproject.api.service.ConsomableService;
import com.pfproject.api.service.NonConsomableService;
import com.pfproject.api.service.AppelOffreService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/projets")
public class ProjetsController {

    private final ProjectService service;
    private final AdministratifService serviceAdministratif;
    private final AppelOffreService serviceAppelOffre;
    private final PermanentService servicePermanent;
    private final SaisonierService serviceSaisonier;
    private final ConsomableService serviceConsomable;
    private final NonConsomableService serviceNonConsomable;
    private final ConverterFacade converterFacade;

    static Logger log = Logger.getLogger(AppeloffreController.class.getName());

    @Autowired
    public ProjetsController(final ProjectService service, final AdministratifService serviceAdministratif,
            PermanentService servicePermanent, final SaisonierService serviceSaisonier,
            final ConsomableService serviceConsomable, NonConsomableService serviceNonConsomable,
            final AppelOffreService serviceAppelOffre, final ConverterFacade converterFacade) {
        super();
        this.service = service;
        this.serviceAdministratif = serviceAdministratif;
        this.servicePermanent = servicePermanent;
        this.serviceSaisonier = serviceSaisonier;
        this.serviceConsomable = serviceConsomable;
        this.serviceNonConsomable = serviceNonConsomable;
        this.serviceAppelOffre = serviceAppelOffre;
        this.converterFacade = converterFacade;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<?> find() {
        List<Project> liste = service.findAll();

        return new ResponseEntity<>(liste, HttpStatus.OK);
    }

    @RequestMapping(value = "/findOne/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable String id) {
        Project projet = service.find(id);

        return new ResponseEntity<>(projet, HttpStatus.OK);
    }

    @RequestMapping(value = "/findByType/{type}", method = RequestMethod.GET)
    public ResponseEntity<?> findByType(@PathVariable String type) {
        List<Project> liste = service.findByType(type);

        return new ResponseEntity<>(liste, HttpStatus.OK);
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody final ProjectDTO dto) {
        dto.setType("Projet");
        Project project = service.create(converterFacade.convertProject(dto));

        List<Personnel> personnels = project.getPersonnels();
        List<Materiel> materiels = project.getMateriels();

        String dateDebut = project.getDateDebut();
        String dateFin = project.getDateFin();
        for (Personnel personnel : personnels) {
            handlePersonnel(personnel, dateDebut, dateFin);
        }

        for (Materiel materiel : materiels) {
            handleMateriels(materiel, false);
        }

        // change etat d'appel d'offre
        AppelOffre ao = serviceAppelOffre.findByNum_AO(project.getNumAo());
        ao.setEtat("Projets");
        serviceAppelOffre.update(ao.getId(), ao);

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @RequestMapping(value = "/completeStep/{id}/{numEtape}/{restore}", method = RequestMethod.GET)
    public ResponseEntity<?> completeStep(@PathVariable String id, @PathVariable String numEtape,
            @PathVariable String restore) {
        Project project = service.find(id);
        List<Personnel> personnels = project.getPersonnels();
        List<Materiel> materiels = project.getMateriels();
        List<Step> steps = project.getEtapes();
        String dateDebut = project.getDateDebut();
        String dateFin = project.getDateFin();
        for (Personnel personnel : personnels) {

            if (Integer.parseInt(personnel.getEtape()) == Integer.parseInt(numEtape)) {
                if (restore.equals("restore")) {
                    handleRestorePersonnel(personnel, dateDebut, dateFin);
                } else {
                    handlePersonnel(personnel, dateDebut, dateFin);
                }

            }
        }
        for (Materiel materiel : materiels) {

            if (Integer.parseInt(materiel.getEtape()) == Integer.parseInt(numEtape))
                if (restore.equals("restore")) {
                    handleResotreMateriels(materiel, true);
                } else {
                    handleMateriels(materiel, true);
                }

        }
        for (Step step : steps) {

            if (step.getEtape().equals(numEtape))
                step.setDone(!step.getDone());
        }

        Project updated = service.update(id, project);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody final ProjectDTO dto) {

        Project projectBefore = service.find(id);

        List<Personnel> personnels = projectBefore.getPersonnels();
        List<Materiel> materiels = projectBefore.getMateriels();

        String dateDebut = projectBefore.getDateDebut();
        String dateFin = projectBefore.getDateFin();
        for (Personnel personnel : personnels) {
            handleRestorePersonnel(personnel, dateDebut, dateFin);
        }

        for (Materiel materiel : materiels) {
            handleResotreMateriels(materiel, false);
        }
        dto.setType("Projet");
        Project project = service.update(id, converterFacade.convertProject(dto));

        personnels = project.getPersonnels();
        materiels = project.getMateriels();
        for (Personnel personnel : personnels) {
            handlePersonnel(personnel, dateDebut, dateFin);
        }

        for (Materiel materiel : materiels) {
            handleMateriels(materiel, false);
        }

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    public void handlePersonnel(final Personnel personnel, final String dateDebut, final String dateFin) {
        String type = personnel.getType();
        switch (type) {
        case "Administratif":
            // Administratif administratif =
            // serviceAdministratif.find(personnel.getPersonnelId());
            // administratif.setDisponible(false);
            // serviceAdministratif.update(personnel.getPersonnelId(), administratif);
            break;
        case "Permanent":
            Permanent permanent = servicePermanent.find(personnel.getPersonnelId());
            permanent.setDisponible(false);
            servicePermanent.update(personnel.getPersonnelId(), permanent);
            break;
        case "Saisonier":
            Saisonier saisonier = serviceSaisonier.find(personnel.getPersonnelId());
            saisonier.setDisponible(false);
            saisonier.setDateDebut(dateDebut);
            saisonier.setDateFin(dateFin);

            Saisonier saved = serviceSaisonier.update(personnel.getPersonnelId(), saisonier);
            break;
        default:
            return;
        }
    }

    public void handleRestorePersonnel(final Personnel personnel, final String dateDebut, final String dateFin) {
        String type = personnel.getType();
        switch (type) {
        case "Administratif":
            // Administratif administratif =
            // serviceAdministratif.find(personnel.getPersonnelId());
            // administratif.setDisponible(false);
            // serviceAdministratif.update(personnel.getPersonnelId(), administratif);
            break;
        case "Permanent":
            Permanent permanent = servicePermanent.find(personnel.getPersonnelId());
            permanent.setDisponible(true);
            servicePermanent.update(personnel.getPersonnelId(), permanent);
            break;
        case "Saisonier":
            Saisonier saisonier = serviceSaisonier.find(personnel.getPersonnelId());
            saisonier.setDisponible(true);
            saisonier.setDateDebut(dateDebut);
            saisonier.setDateFin(dateFin);
            serviceSaisonier.update(personnel.getPersonnelId(), saisonier);
            break;
        default:
            return;
        }
    }

    public void handleMateriels(final Materiel materiel, final Boolean nonConsomableOnly) {
        String type = materiel.getType();
        String id = materiel.getMaterielId();
        int oldQuantite, usedQuantite, newQuantite;
        switch (type) {
        case "Consommable":
            if (!nonConsomableOnly) {
                Consomable consomable = serviceConsomable.find(id);
                oldQuantite = Integer.parseInt(consomable.getQuantite());
                usedQuantite = Integer.parseInt(materiel.getQuantite());
                newQuantite = oldQuantite - usedQuantite;
                consomable.setQuantite(Integer.toString(newQuantite));
                serviceConsomable.update(id, consomable);
            }
            break;
        case "Non consommable":
            Non_consomable nonConsomable = serviceNonConsomable.find(id);
            oldQuantite = Integer.parseInt(nonConsomable.getQuantite());
            usedQuantite = Integer.parseInt(materiel.getQuantite());
            newQuantite = oldQuantite - usedQuantite;
            nonConsomable.setQuantite(Integer.toString(newQuantite));
            serviceNonConsomable.update(id, nonConsomable);
            break;

        default:
            return;
        }
    }

    public void handleResotreMateriels(final Materiel materiel, final Boolean nonConsomableOnly) {
        String type = materiel.getType();
        String id = materiel.getMaterielId();
        int oldQuantite, usedQuantite, newQuantite;
        switch (type) {
        case "Consommable":
            if (!nonConsomableOnly) {
                Consomable consomable = serviceConsomable.find(id);
                oldQuantite = Integer.parseInt(consomable.getQuantite());
                usedQuantite = Integer.parseInt(materiel.getQuantite());
                newQuantite = oldQuantite + usedQuantite;
                consomable.setQuantite(Integer.toString(newQuantite));
                serviceConsomable.update(id, consomable);
            }

            break;
        case "Non consommable":
            Non_consomable nonConsomable = serviceNonConsomable.find(id);
            oldQuantite = Integer.parseInt(nonConsomable.getQuantite());
            usedQuantite = Integer.parseInt(materiel.getQuantite());
            newQuantite = oldQuantite + usedQuantite;
            nonConsomable.setQuantite(Integer.toString(newQuantite));
            serviceNonConsomable.update(id, nonConsomable);
            break;

        default:
            return;
        }
    }

}
