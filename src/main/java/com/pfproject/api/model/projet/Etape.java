package com.pfproject.api.model.projet;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Etape")
public class Etape implements Serializable {

    private static final long serialVersionUID = 7954425825563724764L;

    private String id_etape;
    private String designation;
    private String id_projet;

    private ObjectId id;

    public String getId_etape() {
        return this.id_etape;
    }

    public void setId_etape(String id_etape) {
        this.id_etape = id_etape;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getId_projet() {
        return this.id_projet;
    }

    public void setId_projet(String id_projet) {
        this.id_projet = id_projet;
    }

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Etape() {

    }

}
