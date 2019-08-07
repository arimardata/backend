package com.pfproject.api.model.projet;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Etape_compose")
public class Etape_compose implements Serializable {

    private static final long serialVersionUID = 7954425825562724764L;

    private String id_etape;
    private String id_projet;
    private String duree;

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

    public String getDuree() {
        return this.duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Etape_compose() {

    }

}
