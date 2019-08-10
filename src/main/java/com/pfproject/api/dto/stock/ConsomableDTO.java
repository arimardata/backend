
package com.pfproject.api.dto.stock;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class ConsomableDTO extends MaterielDTO implements Serializable {
	private static final long serialVersionUID = 62301974548107674L;

	private String prix_unite;

	public String getPrix_unite() {
		return this.prix_unite;
	}

	public void setPrix_unite(String prix_unite) {
		this.prix_unite = prix_unite;
	}

}
