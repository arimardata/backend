package com.pfproject.api.model.projet;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Projet")
public class Projet implements Serializable {

    private static final long serialVersionUID = 7954425825563724764L;

    private String date_debut;
    private String date_fin;
    private String cout_total;

    private ObjectId id;

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

    public String getCout_total() {
        return this.cout_total;
    }

    public void setCout_total(String cout_total) {
        this.cout_total = cout_total;
    }

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Projet() {

    }

}
