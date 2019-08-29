package com.pfproject.api.model.project;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class Step implements Serializable {
    private static final long serialVersionUID = 61901774449107678L;

    public Step() {
        super();
    }

    private String etape;
    private String designation;
    private String duree;
    private String responsable;

    public String getEtape() {
        return this.etape;
    }

    public void setEtape(String etape) {
        this.etape = etape;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDuree() {
        return this.duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getResponsable() {
        return this.responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

}