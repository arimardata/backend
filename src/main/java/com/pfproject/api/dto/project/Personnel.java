package com.pfproject.api.dto.project;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class Personnel implements Serializable {
    private static final long serialVersionUID = 61901773539107678L;

    public Personnel() {
        super();
    }

    private String personnelId;
    private String cin;
    private String diplome;
    private String qualite;
    private String type;

    public String getPersonnelId() {
        return this.personnelId;
    }

    public void setPersonnelId(String personnelId) {
        this.personnelId = personnelId;
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getDiplome() {
        return this.diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getQualite() {
        return this.qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

}