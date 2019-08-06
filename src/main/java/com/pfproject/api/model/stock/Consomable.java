package com.pfproject.api.model.stock;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Consomable")
public class Consomable extends Materiel implements Serializable {

    private static final long serialVersionUID = 7954425825563724764L;

    private ObjectId id;
    private String prix_unite;

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getPrix_unite() {
        return this.prix_unite;
    }

    public void setPrix_unite(String prix_unite) {
        this.prix_unite = prix_unite;
    }

    public Consomable() {

    }

}
