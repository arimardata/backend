package com.pfproject.api.dto.personnel;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class SaisonierDTO extends PersonnelDTO implements Serializable {
	private static final long serialVersionUID = 61901974548107674L;

	private String coutParJour;

	public String getCoutParJour() {
		return this.coutParJour;
	}

	public void setCoutParJour(String coutParJour) {
		this.coutParJour = coutParJour;
	}

}
