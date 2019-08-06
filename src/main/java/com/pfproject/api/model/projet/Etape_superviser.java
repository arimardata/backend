package com.pfproject.api.model.projet;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Etape_superviser")
public class Etape_superviser implements Serializable {

    private static final long serialVersionUID = 7954425825563724764L;

    private String id_etape;
    private String id_projet;
    private String cin;

    private ObjectId id;

    public String getId_etape() {
        return this.id_etape;
    }

    public void setId_etape(String id_etape) {
        this.id_etape = id_etape;
    }

    public String getId_projet() {
        return this.id_projet;
    }

    public void setId_projet(String id_projet) {
        this.id_projet = id_projet;
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Etape_superviser() {

    }

}
