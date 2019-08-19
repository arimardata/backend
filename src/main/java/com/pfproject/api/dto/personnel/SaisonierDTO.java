package com.pfproject.api.dto.personnel;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class SaisonierDTO extends PersonnelDTO implements Serializable {
	private static final long serialVersionUID = 61901974548107674L;
	private ObjectId id;
	private String CoutParJour;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCoutParJour() {
		return CoutParJour;
	}

	public void setCoutParJour(String coutParJour) {
		CoutParJour = coutParJour;
	}

}
