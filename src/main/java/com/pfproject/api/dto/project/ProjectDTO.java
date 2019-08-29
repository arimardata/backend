package com.pfproject.api.dto.project;

import java.io.Serializable;

import com.pfproject.api.dto.project.StepDTO;
import com.pfproject.api.dto.project.MaterielDTO;
import com.pfproject.api.dto.project.PersonnelDTO;

import java.util.List;

public class ProjectDTO implements Serializable {
    private static final long serialVersionUID = 61921774549107678L;

    public ProjectDTO() {
        super();
    }

    private String numAo;
    private String dateDebut;
    private String dateFin;
    private String chefDuProjet;
    private List<StepDTO> etapes;
    private List<MaterielDTO> materiels;
    private List<PersonnelDTO> personnels;

    public String getNumAo() {
        return this.numAo;
    }

    public void setNumAo(String numAo) {
        this.numAo = numAo;
    }

    public String getDateDebut() {
        return this.dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return this.dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getChefDuProjet() {
        return this.chefDuProjet;
    }

    public void setChefDuProjet(String chefDuProjet) {
        this.chefDuProjet = chefDuProjet;
    }

    public List<StepDTO> getEtapes() {
        return this.etapes;
    }

    public void setEtapes(List<StepDTO> etapes) {
        this.etapes = etapes;
    }

    public List<MaterielDTO> getMateriels() {
        return this.materiels;
    }

    public void setMateriels(List<MaterielDTO> materiels) {
        this.materiels = materiels;
    }

    public List<PersonnelDTO> getPersonnels() {
        return this.personnels;
    }

    public void setPersonnels(List<PersonnelDTO> personnels) {
        this.personnels = personnels;
    }

}