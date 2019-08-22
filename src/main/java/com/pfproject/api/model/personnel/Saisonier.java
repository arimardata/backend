package com.pfproject.api.model.personnel;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Saisonier")
public class Saisonier extends Personnel implements Serializable {

    private static final long serialVersionUID = 7994425925563724764L;

    private String coutParJour;

    private ObjectId id;

    private String createdAt;
    private String updatedAt;

    public String getCoutParJour() {
        return this.coutParJour;
    }

    public void setCoutParJour(String coutParJour) {
        this.coutParJour = coutParJour;
    }

    public String getId() {
        return this.id.toString();
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public Saisonier() {

    }

}
