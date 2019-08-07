package com.pfproject.api.model.stock;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Affectation_consomable")
public class Affectation_consomable implements Serializable {

    private static final long serialVersionUID = 1954425825563724764L;

    private ObjectId id;
    private String id_projet;
    private String id_consomable;
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

    public String getId_consomable() {
        return this.id_consomable;
    }

    public void setId_consomable(String id_consomable) {
        this.id_consomable = id_consomable;
    }

    public String getQuantite() {
        return this.quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public Affectation_consomable() {

    }

}
