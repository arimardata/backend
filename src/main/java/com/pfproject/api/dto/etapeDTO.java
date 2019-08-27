package com.pfproject.api.dto;

import java.io.Serializable;

public class etapeDTO implements Serializable {
	private static final long serialVersionUID = 64901774547107674L;
	// private ObjectId id;
	private String Designation;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		this.Designation = designation;
	}

}
