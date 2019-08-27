package com.pfproject.api.converter.factory;

import com.pfproject.api.converter.dto.*;
import com.pfproject.api.dto.*;
import com.pfproject.api.dto.personnel.*;
import com.pfproject.api.dto.stock.*;
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
        converters.put(AoDTO.class, new AoDTOConverter());
        converters.put(ConsomableDTO.class, new ConsomableDTOConverter());
        converters.put(NonConsomableDTO.class, new NonConsomableDTOConverter());
        converters.put(AdministratifDTO.class, new AdministratifDTOConverter());
        converters.put(PermanentDTO.class, new PermanentDTOConverter());
        converters.put(SaisonierDTO.class, new SaisonierDTOConverter());
    }

    public Converter getConverter(final Object type) {
        return converters.get(type);
    }
}
