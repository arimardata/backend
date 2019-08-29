package com.pfproject.api.converter;

import com.pfproject.api.converter.factory.ConverterFactory;
import com.pfproject.api.dto.*;
import com.pfproject.api.dto.stock.*;
import com.pfproject.api.dto.personnel.*;
import com.pfproject.api.dto.project.*;
import com.pfproject.api.model.*;
import com.pfproject.api.model.stock.*;
import com.pfproject.api.model.personnel.*;
import com.pfproject.api.model.project.*;
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

    public Notification convertNotification(final NotificationDTO dto) {
        return (Notification) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public Consomable convertConsomable(final ConsomableDTO dto) {
        return (Consomable) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public Non_consomable convertNonConsomable(final NonConsomableDTO dto) {
        return (Non_consomable) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public Administratif convertAdministratif(final AdministratifDTO dto) {
        return (Administratif) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public Permanent convertPermanent(final PermanentDTO dto) {
        return (Permanent) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public Saisonier convertSaisonier(final SaisonierDTO dto) {
        return (Saisonier) converterFactory.getConverter(dto.getClass()).convert(dto);
    }

    public Project convertProject(final ProjectDTO dto) {
        return (Project) converterFactory.getConverter(dto.getClass()).convert(dto);
    }
}
