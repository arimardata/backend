package com.pfproject.api.converter.dto;

import org.springframework.core.convert.converter.Converter;

import com.pfproject.api.dto.stock.ConsomableDTO;
import com.pfproject.api.model.stock.Consomable;

public class ConsomableDTOConverter implements Converter<ConsomableDTO, Consomable> {
    @Override
    public Consomable convert(final ConsomableDTO dto) {
        final Consomable consomable = new Consomable();

        consomable.setId_mat(dto.getId_mat());
        consomable.setPrix_unite(dto.getPrix_unite());
        consomable.setQuantite(dto.getQuantite());

        return consomable;
    }
}