package com.pfproject.api.model.project;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pfproject.api.model.project.Step;
import com.pfproject.api.model.project.Materiel;
import com.pfproject.api.model.project.Personnel;

import java.util.List;
import java.util.Map;

@Document(collection = "Project")
public class Project implements Serializable {
    private static final long serialVersionUID = 61921774549107678L;

    public Project() {
        super();
    }

    private ObjectId id;
    private String numAo;
    private String dateDebut;
    private String dateFin;
    private String chefDuProjet;
    private List<Step> etapes;
    private List<Materiel> materiels;
    private List<Personnel> personnels;
    private List<ChargeFixe> chargesFixes;
    private Map<String, String> charges;
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ChargeFixe> getChargesFixes() {
        return this.chargesFixes;
    }

    public void setChargesFixes(List<ChargeFixe> chargesFixes) {
        this.chargesFixes = chargesFixes;
    }

    public Map<String, String> getCharges() {
        return this.charges;
    }

    public void setCharges(Map<String, String> charges) {
        this.charges = charges;
    }

    private String createdAt;

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return this.id.toString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

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

    public void setEtapes(List<Step> etapes2) {
        this.etapes = etapes2;
    }

    public List<Materiel> getMateriels() {
        return this.materiels;
    }

    public void setMateriels(List<Materiel> materiels2) {
        this.materiels = materiels2;
    }

    public List<Personnel> getPersonnels() {
        return this.personnels;
    }

    public void setPersonnels(List<Personnel> personnels) {
        this.personnels = personnels;
    }

}