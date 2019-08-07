package com.pfproject.api.model.stock;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Responsable_magazin")
public class Responsable_magazin implements Serializable {

    private static final long serialVersionUID = 1054425825563724764L;

    private ObjectId id;
    private String id_magazin;
    private String cin;

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getId_magazin() {
        return this.id_magazin;
    }

    public void setId_magazin(String id_magazin) {
        this.id_magazin = id_magazin;
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public Responsable_magazin() {

    }

}
