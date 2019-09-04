package com.pfproject.api.model.project;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class Materiel implements Serializable {
    private static final long serialVersionUID = 61901774539107678L;

    public Materiel() {
        super();
    }

    private String materielId;
    private String materiel;
    private String quantite;
    private String type;
    private String etape;

    public String getEtape() {
        return this.etape;
    }

    public void setEtape(String etape) {
        this.etape = etape;
    }

    public String getMaterielId() {
        return this.materielId;
    }

    public void setMaterielId(String materielId) {
        this.materielId = materielId;
    }

    public String getMateriel() {
        return this.materiel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public String getQuantite() {
        return this.quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}