package com.pfproject.api.security.service;

import com.pfproject.api.model.ResponseWithToken;

public interface TokenService {

    ResponseWithToken getToken(String username, String password) throws Exception;
}
