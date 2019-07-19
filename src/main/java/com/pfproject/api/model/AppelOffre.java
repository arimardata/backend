package com.pfproject.api.model;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AppelOffre")
public class AppelOffre extends BaseEntity {

	private static final long serialVersionUID = 7954325925563724764L;

	private String id;

	private String chef_ouvrage;
	private String Num_AO;
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

	public String getDate_Limite() {
		return this.Date_Limite;
	}

	public void setId(String id) {
		this.id = id;
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
		return this.pdfs;
	}

	public void setPdfs(String pdfs) {
		this.pdfs = pdfs;
	}

	public String getFiles() {
		return this.files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getId() {
		return this.id;
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

}
