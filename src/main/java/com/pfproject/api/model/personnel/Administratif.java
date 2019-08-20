package com.pfproject.api.model.personnel;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Administratif")
public class Administratif extends Personnel implements Serializable {

    private static final long serialVersionUID = 7954425925463724764L;

    private String salaire;
    private String cnss;
    private String date_embauche;
    private String createdAt;
    private String updatedAt;

    private ObjectId id;

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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

    public Administratif() {

    }

}
