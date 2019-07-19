package com.pfproject.api.security.service;

import com.pfproject.api.model.User;
import com.pfproject.api.model.ResponseWithToken;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class JsonWebTokenService implements TokenService {

    private static int tokenExpirationTime = 30;

    @Value("${security.token.secret.key}")
    private String tokenKey;

    private final UserDetailsService userDetailsService;

    @Autowired
    public JsonWebTokenService(final UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public ResponseWithToken getToken(final String username, final String password) throws Exception {
        if (username == null || password == null) {
            return null;
        }
        try {
            final User user = (User) userDetailsService.loadUserByUsername(username);
            Map<String, Object> tokenData = new HashMap<>();
            if (password.equals(user.getPassword())) {
                tokenData.put("clientType", "user");
                tokenData.put("userID", user.getId());
                tokenData.put("username", user.getUsername());
                tokenData.put("token_create_date", LocalDateTime.now());
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.MINUTE, tokenExpirationTime);
                tokenData.put("token_expiration_date", calendar.getTime());
                JwtBuilder jwtBuilder = Jwts.builder();
                jwtBuilder.setExpiration(calendar.getTime());
                jwtBuilder.setClaims(tokenData);

                String token = jwtBuilder.signWith(SignatureAlgorithm.HS512, tokenKey).compact();
                ResponseWithToken response = new ResponseWithToken();
                response.setToken(token);
                response.setAuthority(user.getAuthority());
                response.setUsername(user.getUsername());
                response.setId(user.getId());
                response.setFirstLogin(user.isFirstLogin());
                response.setEnabled(user.isEnabled());
                return response;

            } else {
                throw new UsernameNotFoundException("Nom d'utilisateur ou mot de passe incorrect");
            }

        } catch (UsernameNotFoundException ex) {
            throw new UsernameNotFoundException("Nom d'utilisateur ou mot de passe incorrect");
        }

    }

    public static void setTokenExpirationTime(final int tokenExpirationTime) {
        JsonWebTokenService.tokenExpirationTime = tokenExpirationTime;
    }
}
