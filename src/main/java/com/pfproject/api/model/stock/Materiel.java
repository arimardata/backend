package com.pfproject.api.model.stock;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Materiel")
public class Materiel implements Serializable {

    private static final long serialVersionUID = 7954425825563724764L;

    private ObjectId id;
    private String id_mat;
    private String quantite;

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getId_mat() {
        return this.id_mat;
    }

    public void setId_mat(String id_mat) {
        this.id_mat = id_mat;
    }

    public String getQuantite() {
        return this.quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public Materiel() {

    }

}
