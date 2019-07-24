package com.pfproject.api.converter.factory;

import com.pfproject.api.converter.dto.ChequeDTOConverter;
import com.pfproject.api.converter.dto.UserDTOConverter;
import com.pfproject.api.dto.ChequeDTO;
import com.pfproject.api.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class ConverterFactory {

    private Map<Object, Converter<?, ?>> converters;

    public ConverterFactory() {

    }

    @PostConstruct
    public void init() {
        converters = new HashMap<>();
        converters.put(UserDTO.class, new UserDTOConverter());
        converters.put(ChequeDTO.class, new ChequeDTOConverter());
    }

    public Converter getConverter(final Object type) {
        return converters.get(type);
    }
}
