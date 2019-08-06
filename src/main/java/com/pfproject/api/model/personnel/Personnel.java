package com.pfproject.api.model.personnel;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Personnel")
public class Personnel implements Serializable {

    private static final long serialVersionUID = 7954425925563724764L;

    private String cin;
    private String nom;
    private String prenom;
    private String date_naissance;
    private String tel;
    private String email;
    private String diplome;
    private String qualite;
    private ObjectId id;

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Personnel() {

    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_naissance() {
        return this.date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiplome() {
        return this.diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getQualite() {
        return this.qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

}
