package com.pfproject.api.dto.stock;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class MaterielDTO implements Serializable {
	private static final long serialVersionUID = 61901974548107674L;
	//private ObjectId id;
	private String Quantite;

	/*public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getQuantite() {
		return Quantite;
	}

	public void setQuantite(String quantite) {
		Quantite = quantite;
	}

	
}
