package com.pfproject.api.dto;

import java.io.Serializable;

public class projetDTO implements Serializable {
	private static final long serialVersionUID = 66901774547107674L;
	// private ObjectId id;
	private String DateDebut;
	private String DateFin;
	private String CoutTotal;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(String dateDebut) {
		DateDebut = dateDebut;
	}

	public String getDateFin() {
		return DateFin;
	}

	public void setDateFin(String dateFin) {
		DateFin = dateFin;
	}

	public String getCoutTotal() {
		return CoutTotal;
	}

	public void setCoutTotal(String coutTotal) {
		CoutTotal = coutTotal;
	}

}
