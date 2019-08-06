
package com.pfproject.api.dto.stock;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class NonConsomableDTO extends MaterielDTO implements Serializable  {
	private static final long serialVersionUID = 62901974548107674L;
	//private ObjectId id;

	/*public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}*/
	private String CoutParHeure;
	private String PrixAchat;
	private String DateAchat;

	public static long getSerialversionuid() {
		return serialVersionUID;
		
	}

	public String getCoutParHeure() {
		return CoutParHeure;
	}

	public void setCoutParHeure(String coutParHeure) {
		CoutParHeure = coutParHeure;
	}

	public String getPrixAchat() {
		return PrixAchat;
	}

	public void setPrixAchat(String prixAchat) {
		PrixAchat = prixAchat;
	}

	public String getDateAchat() {
		return DateAchat;
	}

	public void setDateAchat(String dateAchat) {
		DateAchat = dateAchat;
	}





	
}
