package com.pfproject.api.model;

public class Response {
    private String id;
    private Authority role;
    private String pseudo_nom;
    private boolean activé;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isEnabled() {
        return this.activé;
    }

    public void setEnabled(boolean activé) {
        this.activé = activé;
    }

    public Authority getAuthority() {
        return this.role;
    }

    public void setAuthority(Authority role) {
        this.role = role;
    }

    public String getUsername() {
        return this.pseudo_nom;
    }

    public void setUsername(String pseudo_nom) {
        this.pseudo_nom = pseudo_nom;
    }

}
