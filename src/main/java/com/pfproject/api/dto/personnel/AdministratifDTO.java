package com.pfproject.api.dto.personnel;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class AdministratifDTO extends PersonnelDTO implements Serializable {
	private static final long serialVersionUID = 61901974548157674L;

	private String salaire;
	private String cnss;
	private String dateEmbauche;
	private String createdAt;
	private String updatedAt;

	public String getSalaire() {
		return this.salaire;
	}

	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}

	public String getCnss() {
		return this.cnss;
	}

	public void setCnss(String cnss) {
		this.cnss = cnss;
	}

	public String getDateEmbauche() {
		return this.dateEmbauche;
	}

	public void setDateEmbauche(String dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
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

}
