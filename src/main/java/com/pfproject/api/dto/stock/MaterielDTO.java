package com.pfproject.api.dto.stock;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class MaterielDTO implements Serializable {
	private static final long serialVersionUID = 61901974548107674L;

	private String quantite;
	private String id_mat;

	public String getQuantite() {
		return this.quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public String getId_mat() {
		return this.id_mat;
	}

	public void setId_mat(String id_mat) {
		this.id_mat = id_mat;
	}

}
