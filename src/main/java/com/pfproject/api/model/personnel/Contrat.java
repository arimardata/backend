package com.pfproject.api.model.personnel;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Contrat")
public class Contrat implements Serializable {

    private static final long serialVersionUID = 7954425925563724764L;

    private String date_debut;
    private String date_fin;
    private String cin;
    private String id_projet;

    private ObjectId id;

    public Contrat() {

    }

}
