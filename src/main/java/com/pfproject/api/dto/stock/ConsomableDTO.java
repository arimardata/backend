
package com.pfproject.api.dto.stock;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class ConsomableDTO extends MaterielDTO implements Serializable  {
	private static final long serialVersionUID = 62301974548107674L;
	//private ObjectId id;

	/*public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}*/
	private String PrixUnite;

	public static long getSerialversionuid() {
		return serialVersionUID;
		
	}

	public String getPrixUnite() {
		return PrixUnite;
	}

	public void setPrixUnite(String prixUnite) {
		PrixUnite = prixUnite;
	}

	






	
}
