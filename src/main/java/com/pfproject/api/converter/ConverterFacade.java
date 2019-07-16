package com.pfproject.api.converter;

import com.pfproject.api.converter.factory.ConverterFactory;
import com.pfproject.api.dto.UserDTO;
import com.pfproject.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ConverterFacade {

    @Autowired
    private ConverterFactory converterFactory;

    public User convert(final UserDTO dto) {

        return (User) converterFactory.getConverter(dto.getClass()).convert(dto);
    }
}
