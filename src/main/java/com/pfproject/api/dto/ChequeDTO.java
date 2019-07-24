package com.pfproject.api.dto;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class ChequeDTO implements Serializable {
	private static final long serialVersionUID = 61901774547107674L;
	//private ObjectId id;
	private String Banque;
	private String Somme;
	private String Etat;
	private String Emetteur;
	private String Recepteur;
	private String Alerte;
	private String Date;
	/*public ObjectId getId() {
		return id;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
