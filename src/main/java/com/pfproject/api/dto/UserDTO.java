package com.pfproject.api.dto;

import java.io.Serializable;
import com.pfproject.api.model.Authority;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 91901774547107674L;

    private String username;
    private String password;
    private Authority authority;
    private boolean firstLogin;

    public UserDTO() {
    }

    public boolean isFirstLogin() {
        return this.firstLogin;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setFirstLogin(final boolean firstLogin) {
        this.firstLogin = firstLogin;
    }
}
