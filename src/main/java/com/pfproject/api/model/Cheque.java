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
	private String Compte;
	private String Email;
	private String Telephone;
	private String Sent;
	
	
	
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
	public String getCompte() {
		return Compte;
	}
	public void setCompte(String compte) {
		Compte = compte;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getSent() {
		return Sent;
	}
	public void setSent(String sent) {
		Sent = sent;
	}
	
	
}
