package com.pfproject.api.model.personnel;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Contrat")
public class Contrat implements Serializable {

    private static final long serialVersionUID = 7954425925563624764L;

    private String date_debut;
    private String date_fin;
    private String cin;
    private String id_projet;

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

    private ObjectId id;

    public String getId() {
        return this.id.toString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Contrat() {

    }

}
