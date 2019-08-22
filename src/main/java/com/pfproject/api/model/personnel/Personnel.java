package com.pfproject.api.model.personnel;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Personnel")
public class Personnel implements Serializable {

    private static final long serialVersionUID = 7954425225563724764L;

    private String cin;
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private String tel;
    private String email;
    private String diplome;
    private String qualite;

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

    public String getDateDeNaissance() {
        return this.dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
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

    public Personnel() {

    }

}
