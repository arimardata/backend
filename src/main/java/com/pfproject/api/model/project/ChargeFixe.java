package com.pfproject.api.model.project;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class ChargeFixe implements Serializable {
    private static final long serialVersionUID = 61901774449107678L;

    public ChargeFixe() {
        super();
    }

    private String num;
    private String note;
    private String montant;

    public String getNum() {
        return this.num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMontant() {
        return this.montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

}