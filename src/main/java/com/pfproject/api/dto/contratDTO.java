package com.pfproject.api.dto;

import java.io.Serializable;

public class contratDTO implements Serializable {
	private static final long serialVersionUID = 66903274547107414L;
	// private ObjectId id;
	private String DateDebut;
	private String DateFin;

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

}
