package com.pfproject.api.model.stock;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Materiel")
public class Materiel implements Serializable {

    private static final long serialVersionUID = 6954425825563724764L;

    private String id_mat;
    private String quantite;

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
