package com.pfproject.api.converter.dto;

import org.springframework.core.convert.converter.Converter;

import com.pfproject.api.dto.stock.NonConsomableDTO;
import com.pfproject.api.model.stock.Non_consomable;

public class NonConsomableDTOConverter implements Converter<NonConsomableDTO, Non_consomable> {
    @Override
    public Non_consomable convert(final NonConsomableDTO dto) {
        final Non_consomable non_consomable = new Non_consomable();
        non_consomable.setCout_par_heure(dto.getCout_par_heure());
        non_consomable.setDate_achat(dto.getDate_achat());
        non_consomable.setId_mat(dto.getId_mat());
        non_consomable.setQuantite(dto.getQuantite());
        non_consomable.setPrix_achat(dto.getPrix_achat());
        return non_consomable;
    }
}