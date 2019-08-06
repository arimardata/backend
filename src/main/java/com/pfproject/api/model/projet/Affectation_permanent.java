package com.pfproject.api.model.projet;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Affectation_permanent")
public class Affectation_permanent implements Serializable {

    private static final long serialVersionUID = 7954425825563724764L;

    private String cin;
    private String id_projet;
    private String nbr_jours;

    private ObjectId id;

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

    public String getNbr_jours() {
        return this.nbr_jours;
    }

    public void setNbr_jours(String nbr_jours) {
        this.nbr_jours = nbr_jours;
    }

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Affectation_permanent() {

    }

}
