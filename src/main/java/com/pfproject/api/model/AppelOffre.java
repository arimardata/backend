package com.pfproject.api.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AppelOffre")
public class AppelOffre extends BaseEntity {

	private static final long serialVersionUID = 7954325925563724764L;
	// private ObjectId id;

	private String chef_ouvrage;
	private String num_AO;
	private String num_Ordre;

	private String caution;
	private String mise_en_ligne;
	private String type;
	private String ville;
	private String estimation;
	private String date_limite;
	private String autres_details;
	private String etat;
	private String pdfs;
	private String files;

	private String cautionFinal;
	private String bankCautionFinal;
	private String periodeCautionFinal;
	private String dateCautionFinal;

	private String cautionProvisoire;
	private String bankCautionProvisoire;
	private String periodeCautionProvisoire;
	private String dateCautionProvisoire;

	private String moinsDisant;
	private String montant;

	public AppelOffre() {

	}

	public String getBankCautionFinal() {
		return this.bankCautionFinal;
	}

	public void setBankCautionFinal(String bankCautionFinal) {
		this.bankCautionFinal = bankCautionFinal;
	}

	public String getPeriodeCautionFinal() {
		return this.periodeCautionFinal;
	}

	public void setPeriodeCautionFinal(String periodeCautionFinal) {
		this.periodeCautionFinal = periodeCautionFinal;
	}

	public String getDateCautionFinal() {
		return this.dateCautionFinal;
	}

	public void setDateCautionFinal(String dateCautionFinal) {
		this.dateCautionFinal = dateCautionFinal;
	}

	public String getCautionProvisoire() {
		return this.cautionProvisoire;
	}

	public void setCautionProvisoire(String cautionProvisoire) {
		this.cautionProvisoire = cautionProvisoire;
	}

	public String getBankCautionProvisoire() {
		return this.bankCautionProvisoire;
	}

	public void setBankCautionProvisoire(String bankCautionProvisoire) {
		this.bankCautionProvisoire = bankCautionProvisoire;
	}

	public String getPeriodeCautionProvisoire() {
		return this.periodeCautionProvisoire;
	}

	public void setPeriodeCautionProvisoire(String periodeCautionProvisoire) {
		this.periodeCautionProvisoire = periodeCautionProvisoire;
	}

	public String getDateCautionProvisoire() {
		return this.dateCautionProvisoire;
	}

	public void setDateCautionProvisoire(String dateCautionProvisoire) {
		this.dateCautionProvisoire = dateCautionProvisoire;
	}

	public String getChef_ouvrage() {
		return chef_ouvrage;
	}

	public void setChef_ouvrage(String chef_ouvrage) {
		this.chef_ouvrage = chef_ouvrage;
	}

	public String getNum_AO() {
		return num_AO;
	}

	public void setNum_AO(String num_AO) {
		this.num_AO = num_AO;
	}

	public String getNum_Ordre() {
		return num_Ordre;
	}

	public void setNum_Ordre(String num_Ordre) {
		this.num_Ordre = num_Ordre;
	}

	public String getCaution() {
		return caution;
	}

	public void setCaution(String caution) {
		this.caution = caution;
	}

	public String getMise_en_ligne() {
		return mise_en_ligne;
	}

	public void setMise_en_ligne(String mise_en_ligne) {
		this.mise_en_ligne = mise_en_ligne;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getEstimation() {
		return estimation;
	}

	public void setEstimation(String estimation) {
		this.estimation = estimation;
	}

	public String getAutres_details() {
		return autres_details;
	}

	public void setAutres_details(String autres_details) {
		this.autres_details = autres_details;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDate_limite() {
		return date_limite;
	}

	public void setDate_limite(String date_limite) {
		this.date_limite = date_limite;
	}

}
