package com.pfproject.api.dto;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class AoDTO implements Serializable {
	private static final long serialVersionUID = 61901774549107678L;
	// private ObjectId id;
	private ObjectId id;

	private String chef_ouvrage;
	private String Num_AO;
	private String Num_Ordre;

	private String Caution;
	private String Mise_en_ligne;
	private String Type;
	private String Ville;
	private String Estimation;
	private String Date_Limite;
	private String Autres_details;
	private String etat;
	private String pdfs;
	private String files;

	private String cautionFinal;
	private String moinsDisant;
	private String montant;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getChef_ouvrage() {
		return chef_ouvrage;
	}

	public void setChef_ouvrage(String chef_ouvrage) {
		this.chef_ouvrage = chef_ouvrage;
	}

	public String getNum_AO() {
		return Num_AO;
	}

	public void setNum_AO(String num_AO) {
		Num_AO = num_AO;
	}

	public String getNum_Ordre() {
		return Num_Ordre;
	}

	public void setNum_Ordre(String num_Ordre) {
		Num_Ordre = num_Ordre;
	}

	public String getCaution() {
		return Caution;
	}

	public void setCaution(String caution) {
		Caution = caution;
	}

	public String getMise_en_ligne() {
		return Mise_en_ligne;
	}

	public void setMise_en_ligne(String mise_en_ligne) {
		Mise_en_ligne = mise_en_ligne;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getEstimation() {
		return Estimation;
	}

	public void setEstimation(String estimation) {
		Estimation = estimation;
	}

	public String getDate_Limite() {
		return Date_Limite;
	}

	public void setDate_Limite(String date_Limite) {
		Date_Limite = date_Limite;
	}

	public String getAutres_details() {
		return Autres_details;
	}

	public void setAutres_details(String autres_details) {
		Autres_details = autres_details;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getPdfs() {
		return pdfs;
	}

	public void setPdfs(String pdfs) {
		this.pdfs = pdfs;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getCautionFinal() {
		return cautionFinal;
	}

	public void setCautionFinal(String cautionFinal) {
		this.cautionFinal = cautionFinal;
	}

	public String getMoinsDisant() {
		return moinsDisant;
	}

	public void setMoinsDisant(String moinsDisant) {
		this.moinsDisant = moinsDisant;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

}