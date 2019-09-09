package com.pfproject.api.dto.personnel;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class SaisonierDTO extends PersonnelDTO implements Serializable {
	private static final long serialVersionUID = 61901974548107674L;

	private String coutParJour;
	private String dateDebut;
	private String dateFin;

	public String getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}


	public String getCoutParJour() {
		return this.coutParJour;
	}

	public void setCoutParJour(String coutParJour) {
		this.coutParJour = coutParJour;
	}

}
