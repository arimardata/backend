package com.pfproject.api.model.projet;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Affectation_admin")
public class Affectation_admin implements Serializable {

    private static final long serialVersionUID = 7954425825563764764L;
    private ObjectId id;
    private String cin;
    private String id_projet;
    private String date_debut;
    private String date_fin;

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getId_projet() {
        return this.id_projet;
    }

    public void setId_projet(String id_projet) {
        this.id_projet = id_projet;
    }

    public String getDate_debut() {
        return this.date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return this.date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public Affectation_admin() {

    }

}
