package com.pfproject.api.converter.dto;

import org.springframework.core.convert.converter.Converter;

import com.pfproject.api.dto.project.ProjectDTO;
import com.pfproject.api.dto.project.StepDTO;
import com.pfproject.api.dto.project.ChargeFixeDTO;
import com.pfproject.api.dto.project.MaterielDTO;
import com.pfproject.api.dto.project.PersonnelDTO;
import com.pfproject.api.model.project.Step;
import com.pfproject.api.model.project.ChargeFixe;
import com.pfproject.api.model.project.Materiel;
import com.pfproject.api.model.project.Personnel;
import com.pfproject.api.model.project.Project;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class ProjectDTOConverter implements Converter<ProjectDTO, Project> {

    public ProjectDTOConverter() {
        super();
    }

    @Override
    public Project convert(final ProjectDTO dto) {
        Project project = new Project();
        project.setNumAo(dto.getNumAo());
        project.setDateDebut(dto.getDateDebut());
        project.setDateFin(dto.getDateFin());
        project.setChefDuProjet(dto.getChefDuProjet());

        List<StepDTO> etapesDto = dto.getEtapes();
        List<Step> etapes = new ArrayList<Step>();
        for (StepDTO etape : etapesDto) {
            Step newEtape = new Step();
            newEtape.setEtape(etape.getEtape());
            newEtape.setDesignation(etape.getDesignation());
            newEtape.setDuree(etape.getDuree());
            newEtape.setResponsable(etape.getResponsable());
            newEtape.setCoutConsomable(etape.getCoutConsomable());
            newEtape.setCoutNonConsomable(etape.getCoutNonConsomable());
            newEtape.setCoutPermanent(etape.getCoutPermanent());
            newEtape.setCoutSaisonier(etape.getCoutSaisonier());
            etapes.add(newEtape);
        }

        List<MaterielDTO> materielsDto = dto.getMateriels();
        List<Materiel> materiels = new ArrayList<Materiel>();
        for (MaterielDTO materiel : materielsDto) {
            Materiel newMateriel = new Materiel();
            newMateriel.setMaterielId(materiel.getMaterielId());
            newMateriel.setMateriel(materiel.getMateriel());
            newMateriel.setQuantite(materiel.getQuantite());
            newMateriel.setType(materiel.getType());
            materiels.add(newMateriel);
        }

        List<PersonnelDTO> personnelsDto = dto.getPersonnels();
        List<Personnel> personnels = new ArrayList<Personnel>();
        for (PersonnelDTO personnel : personnelsDto) {
            Personnel newPersonnel = new Personnel();
            newPersonnel.setPersonnelId(personnel.getPersonnelId());
            newPersonnel.setCin(personnel.getCin());
            newPersonnel.setDiplome(personnel.getDiplome());
            newPersonnel.setQualite(personnel.getQualite());
            newPersonnel.setType(personnel.getType());
            personnels.add(newPersonnel);
        }

        List<ChargeFixeDTO> chargeFixesDto = dto.getChargesFixes();
        List<ChargeFixe> chargesFixes = new ArrayList<ChargeFixe>();
        for (ChargeFixeDTO chargeFixe : chargeFixesDto) {
            ChargeFixe newChargeFixe = new ChargeFixe();
            newChargeFixe.setNum(chargeFixe.getNum());
            newChargeFixe.setMontant(chargeFixe.getMontant());
            newChargeFixe.setNote(chargeFixe.getNote());
            chargesFixes.add(newChargeFixe);
        }

        Map<String, String> chargeDto = dto.getCharges();
        Map<String, String> charges = new HashMap<String, String>();
        charges.put("chargepermanent", chargeDto.get("chargepermanent"));
        charges.put("chargesaisonier", chargeDto.get("chargesaisonier"));
        charges.put("chargeconsomable", chargeDto.get("chargeconsomable"));
        charges.put("chargenonconsomable", chargeDto.get("chargenonconsomable"));
        charges.put("chargefixe", chargeDto.get("chargefixe"));

        project.setEtapes(etapes);
        project.setMateriels(materiels);
        project.setPersonnels(personnels);
        project.setChargesFixes(chargesFixes);
        project.setCharges(charges);

        return project;
    }
}