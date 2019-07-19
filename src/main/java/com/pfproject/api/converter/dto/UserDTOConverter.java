package com.pfproject.api.converter.dto;

import com.pfproject.api.dto.UserDTO;
import com.pfproject.api.model.User;
import org.springframework.core.convert.converter.Converter;

public class UserDTOConverter implements Converter<UserDTO, User> {

    @Override
    public User convert(final UserDTO dto) {
        final User user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setAccountNonExpired(false);
        user.setCredentialsNonExpired(false);
        user.setEnabled(true);

        // incase of multiple roles we use this
        // List<Authority> authorities = new ArrayList<>();
        // authorities.add(dto.getAuthority());
        // user.setAuthorities(authorities);

        user.setAuthority(dto.getAuthority());
        return user;
    }
}
