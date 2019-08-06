package com.pfproject.api.dto.personnel;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class PermanentDTO extends PersonnelDTO implements Serializable {
	private static final long serialVersionUID = 61901974548107674L;
	//private ObjectId id;
	private String Salaire;
	private String CNSS;
	private String  DateEmbauche;
	/*public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSalaire() {
		return Salaire;
	}

	public void setSalaire(String salaire) {
		Salaire = salaire;
	}

	public String getCNSS() {
		return CNSS;
	}

	public void setCNSS(String cNSS) {
		CNSS = cNSS;
	}

	public String getDateEmbauche() {
		return DateEmbauche;
	}

	public void setDateEmbauche(String dateEmbauche) {
		DateEmbauche = dateEmbauche;
	}

	



	

	
}
