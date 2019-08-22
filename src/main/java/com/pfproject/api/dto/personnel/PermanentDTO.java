package com.pfproject.api.dto.personnel;

import java.io.Serializable;

public class PermanentDTO extends PersonnelDTO implements Serializable {
	private static final long serialVersionUID = 61901974548107674L;
	private String salaire;
	private String cnss;
	private String dateEmbauche;

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

}
