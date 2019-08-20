package com.pfproject.api.model.personnel;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Saisonier")
public class Saisonier extends Personnel implements Serializable {

    private static final long serialVersionUID = 7994425925563724764L;

    private String cout_par_jour;

    private ObjectId id;

    private String createdAt;
    private String updatedAt;

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

    public String getCout_par_jour() {
        return this.cout_par_jour;
    }

    public void setCout_par_jour(String cout_par_jour) {
        this.cout_par_jour = cout_par_jour;
    }

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Saisonier() {

    }

}
