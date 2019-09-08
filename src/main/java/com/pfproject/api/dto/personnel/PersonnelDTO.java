package com.pfproject.api.dto.personnel;

import java.io.Serializable;

public class PersonnelDTO implements Serializable {
	private static final long serialVersionUID = 61901974548107674L;

	private String cin;
	private String nom;
	private String prenom;
	private String dateDeNaissance;
	private String tel;
	private String email;
	private String diplome;
	private String qualite;
	private Boolean disponible;

	public Boolean getDisponible() {
		return this.disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
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

}
