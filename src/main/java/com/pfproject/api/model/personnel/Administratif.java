package com.pfproject.api.model.personnel;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Administratif")
public class Administratif extends Personnel implements Serializable {

    private static final long serialVersionUID = 7954425925463724764L;

    private String salaire;
    private String cnss;
    private String dateEmbauche;
    private String createdAt;
    private String updatedAt;

    private ObjectId id;

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

    public String getDateEmbauche() {
        return this.dateEmbauche;
    }

    public void setDateEmbauche(String dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

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

    public String getId() {
        return this.id.toString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Administratif() {

    }

}
