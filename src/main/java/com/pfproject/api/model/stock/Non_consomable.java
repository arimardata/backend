package com.pfproject.api.model.stock;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Non_consomable")
public class Non_consomable extends Materiel implements Serializable {

    private static final long serialVersionUID = 7954425825563724764L;

    private ObjectId id;
    private String cout_par_heure;
    private String prix_achat;
    private String date_achat;

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCout_par_heure() {
        return this.cout_par_heure;
    }

    public void setCout_par_heure(String cout_par_heure) {
        this.cout_par_heure = cout_par_heure;
    }

    public String getPrix_achat() {
        return this.prix_achat;
    }

    public void setPrix_achat(String prix_achat) {
        this.prix_achat = prix_achat;
    }

    public String getDate_achat() {
        return this.date_achat;
    }

    public void setDate_achat(String date_achat) {
        this.date_achat = date_achat;
    }

    public Non_consomable() {

    }

}
