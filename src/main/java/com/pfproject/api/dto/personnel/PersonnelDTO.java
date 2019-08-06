package com.pfproject.api.dto.personnel;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class PersonnelDTO implements Serializable {
	private static final long serialVersionUID = 61901974548107674L;
	//private ObjectId id;
	private String CIN;
	private String Nom;
	private String Prenom;
	private String DateDeNaissance;
	private String Tel;
	private String Email;
	private String Diplome;
	private String Qualite;

	/*public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getDateDeNaissance() {
		return DateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		DateDeNaissance = dateDeNaissance;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDiplome() {
		return Diplome;
	}

	public void setDiplome(String diplome) {
		Diplome = diplome;
	}

	public String getQualite() {
		return Qualite;
	}

	public void setQualite(String qualite) {
		Qualite = qualite;
	}

	

	
}
