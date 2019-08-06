package com.pfproject.api.model.personnel;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Permanent")
public class Permanent extends Personnel implements Serializable {

    private static final long serialVersionUID = 7954425925563724764L;

    private String salaire;
    private String cnss;
    private String date_embauche;

    private ObjectId id;

    public Permanent() {

    }

    public String getSalaire() {
        return this.salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
    }

    public String getCnss() {
        return this.cnss;
    }

    public void setCnss(String cnss) {
        this.cnss = cnss;
    }

    public String getDate_embauche() {
        return this.date_embauche;
    }

    public void setDate_embauche(String date_embauche) {
        this.date_embauche = date_embauche;
    }

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

}
