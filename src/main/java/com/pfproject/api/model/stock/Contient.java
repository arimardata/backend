package com.pfproject.api.model.stock;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Contient")
public class Contient implements Serializable {

    private static final long serialVersionUID = 4954425825563724764L;

    private ObjectId id;

    private String id_magazin;
    private List<String> ids_mat;

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

    public List<String> getMateriels() {
        return this.ids_mat;
    }

    public void setMateriels(List<String> ids_mat) {
        this.ids_mat = ids_mat;
    }

    public Contient() {

    }

}
