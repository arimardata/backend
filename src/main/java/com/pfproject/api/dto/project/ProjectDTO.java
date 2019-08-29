package com.pfproject.api.dto.project;

import java.io.Serializable;

import org.bson.types.ObjectId;

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
    private List<Step> etapes;
    private List<Materiel> materiels;
    private List<Personnel> personnels;

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

    public List<Step> getEtapes() {
        return this.etapes;
    }

    public void setEtapes(List<Step> etapes) {
        this.etapes = etapes;
    }

    public List<Materiel> getMateriels() {
        return this.materiels;
    }

    public void setMateriels(List<Materiel> materiels) {
        this.materiels = materiels;
    }

    public List<Personnel> getPersonnels() {
        return this.personnels;
    }

    public void setPersonnels(List<Personnel> personnels) {
        this.personnels = personnels;
    }

}