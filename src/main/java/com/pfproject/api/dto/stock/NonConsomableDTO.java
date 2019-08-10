
package com.pfproject.api.dto.stock;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class NonConsomableDTO extends MaterielDTO implements Serializable {
	private static final long serialVersionUID = 62901974548107674L;

	private String cout_par_heure;
	private String prix_achat;
	private String date_achat;

	public String getCout_par_heure() {
		return this.cout_par_heure;
	}

	public void setCout_par_heure(String cout_par_heure) {
		this.cout_par_heure = cout_par_heure;
	}

	public String getPrix_achat() {
		return this.prix_achat;
	}

	public void setPrix_achat(String prix_achat) {
		this.prix_achat = prix_achat;
	}

	public String getDate_achat() {
		return this.date_achat;
	}

	public void setDate_achat(String date_achat) {
		this.date_achat = date_achat;
	}

}
