package com.pfproject.api.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AppelOffre")
public class AppelOffre extends BaseEntity {

	private static final long serialVersionUID = 7954325925563724764L;
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
	private String PDFs;
	private String Files;

	private String cautionFinal;
	private String moinsDisant;
	private String montant;

	public AppelOffre() {

	}

	public String getNum_Ordre() {
		return this.Num_Ordre;
	}

	public void setNum_Ordre(String Num_Ordre) {
		this.Num_Ordre = Num_Ordre;
	}

	public String getDate_Limite() {
		return this.Date_Limite;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getId() {
		return this.id.toString();
	}

	public void setDate_Limite(String Date_Limite) {
		this.Date_Limite = Date_Limite;
	}

	public String getAutres_details() {
		return this.Autres_details;
	}

	public void setAutres_details(String Autres_details) {
		this.Autres_details = Autres_details;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getPdfs() {
		return this.PDFs;
	}

	public void setPdfs(String pdfs) {
		this.PDFs = pdfs;
	}

	public String getFiles() {
		return this.Files;
	}

	public void setFiles(String files) {
		this.Files = files;
	}

	public String getChef_ouvrage() {
		return this.chef_ouvrage;
	}

	public void setChef_ouvrage(String Chef_ouvrage) {
		this.chef_ouvrage = Chef_ouvrage;
	}

	public String getNum_AO() {
		return this.Num_AO;
	}

	public void setNum_AO(String Num_AO) {
		this.Num_AO = Num_AO;
	}

	public String getCaution() {
		return this.Caution;
	}

	public void setCaution(String Caution) {
		this.Caution = Caution;
	}

	public String getMise_en_ligne() {
		return this.Mise_en_ligne;
	}

	public void setMise_en_ligne(String Mise_en_ligne) {
		this.Mise_en_ligne = Mise_en_ligne;
	}

	public String getType() {
		return this.Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}

	public String getVille() {
		return this.Ville;
	}

	public void setVille(String Ville) {
		this.Ville = Ville;
	}

	public String getEstimation() {
		return this.Estimation;
	}

	public void setEstimation(String Estimation) {
		this.Estimation = Estimation;
	}

	public String getCautionFinal() {
		return cautionFinal;
	}

	public void setCautionFinal(String cautionFinal) {
		this.cautionFinal = cautionFinal;
	}

	public String getMoinsDisant() {
		return this.moinsDisant;
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
