package com.pfproject.api.model.stock;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Affectation_non_consomable")
public class Affectation_non_consomable implements Serializable {

    private static final long serialVersionUID = 2954425825563724764L;

    private ObjectId id;
    private String id_projet;
    private String id_non_consomable;
    private String nbr_heures;
    private String quantite;

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getId_projet() {
        return this.id_projet;
    }

    public void setId_projet(String id_projet) {
        this.id_projet = id_projet;
    }

    public String getId_non_consomable() {
        return this.id_non_consomable;
    }

    public void setId_non_consomable(String id_non_consomable) {
        this.id_non_consomable = id_non_consomable;
    }

    public String getNbr_heures() {
        return this.nbr_heures;
    }

    public void setNbr_heures(String nbr_heures) {
        this.nbr_heures = nbr_heures;
    }

    public String getQuantite() {
        return this.quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public Affectation_non_consomable() {

    }

}
