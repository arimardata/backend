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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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

    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody final ProjectDTO dto) {
        Project project = service.create(converterFacade.convertProject(dto));

        List<Personnel> personnels = project.getPersonnels();
        List<Materiel> materiels = project.getMateriels();

        String dateDebut = project.getDateDebut();
        String dateFin = project.getDateFin();
        for (Personnel personnel : personnels) {
            handlePersonnel(personnel, dateDebut, dateFin);
        }

        for (Materiel materiel : materiels) {
            handleMateriels(materiel);
        }

        // change etat d'appel d'offre
        AppelOffre ao = serviceAppelOffre.findByNum_AO(project.getNumAo());
        ao.setEtat("Projets");
        serviceAppelOffre.update(ao.getId(), ao);

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
            serviceSaisonier.update(personnel.getPersonnelId(), saisonier);
            break;
        default:
            return;
        }
    }

    public void handleMateriels(final Materiel materiel) {
        String type = materiel.getType();
        String id = materiel.getMaterielId();
        int oldQuantite, usedQuantite, newQuantite;
        switch (type) {
        case "Consomable":
            Consomable consomable = serviceConsomable.find(id);
            oldQuantite = Integer.parseInt(consomable.getQuantite());
            usedQuantite = Integer.parseInt(materiel.getQuantite());
            newQuantite = oldQuantite - usedQuantite;
            consomable.setQuantite(Integer.toString(newQuantite));
            serviceConsomable.update(id, consomable);
            break;
        case "Non consomable":
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

}
