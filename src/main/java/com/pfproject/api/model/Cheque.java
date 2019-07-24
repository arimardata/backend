package com.pfproject.api.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cheque")
public class Cheque extends BaseEntity {
	private static final long serialVersionUID = 7954325925563724764L;
	
	//private ObjectId id;
	private String Banque;
	private String Somme;
	private String Etat;
	private String Emetteur;
	private String Recepteur;
	private String Alerte;
	private String Date;
	
	
	
	/*public String getId() {
		return id.toString();
	}
	public void setId(ObjectId id) {
		this.id = id;
	}*/
	public String getBanque() {
		return Banque;
	}
	public void setBanque(String banque) {
		Banque = banque;
	}
	public String getSomme() {
		return Somme;
	}
	public void setSomme(String somme) {
		Somme = somme;
	}
	public String getEtat() {
		return Etat;
	}
	public void setEtat(String etat) {
		Etat = etat;
	}
	public String getEmetteur() {
		return Emetteur;
	}
	public void setEmetteur(String emetteur) {
		Emetteur = emetteur;
	}
	public String getRecepteur() {
		return Recepteur;
	}
	public void setRecepteur(String recepteur) {
		Recepteur = recepteur;
	}
	public String getAlerte() {
		return Alerte;
	}
	public void setAlerte(String alerte) {
		Alerte = alerte;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	
}
