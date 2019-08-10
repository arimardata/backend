package com.pfproject.api.converter;

import com.pfproject.api.converter.factory.ConverterFactory;
import com.pfproject.api.dto.AoDTO;
import com.pfproject.api.dto.ChequeDTO;
import com.pfproject.api.dto.UserDTO;
import com.pfproject.api.model.AppelOffre;
import com.pfproject.api.dto.stock.ConsomableDTO;
import com.pfproject.api.dto.stock.NonConsomableDTO;
import com.pfproject.api.model.stock.Consomable;
import com.pfproject.api.model.stock.Non_consomable;
import com.pfproject.api.model.Cheque;
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

    public Cheque convertCheque(final ChequeDTO dto) {
        return (Cheque) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public AppelOffre convertAo(final AoDTO dto) {
        return (AppelOffre) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public Consomable convertConsomable(final ConsomableDTO dto) {
        return (Consomable) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public Non_consomable convertNonConsomable(final NonConsomableDTO dto) {
        return (Non_consomable) converterFactory.getConverter(dto.getClass()).convert(dto);
    }
}
