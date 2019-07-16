package com.pfproject.api.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable {

    private static final long serialVersionUID = -4159366509929151486L;

    private String message;

    public MessageDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

}
