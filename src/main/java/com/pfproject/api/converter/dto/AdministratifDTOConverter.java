package com.pfproject.api.converter.dto;

import org.springframework.core.convert.converter.Converter;

import com.pfproject.api.dto.personnel.AdministratifDTO;
import com.pfproject.api.model.personnel.Administratif;

public class AdministratifDTOConverter implements Converter<AdministratifDTO, Administratif> {
    @Override
    public Administratif convert(final AdministratifDTO dto) {
        final Administratif administratif = new Administratif();
        administratif.setCin(dto.getCin());
        administratif.setCnss(dto.getCnss());
        administratif.setDateEmbauche(dto.getDateEmbauche());
        administratif.setDateDeNaissance(dto.getDateDeNaissance());
        administratif.setDiplome(dto.getDiplome());
        administratif.setEmail(dto.getEmail());
        administratif.setNom(dto.getNom());
        administratif.setPrenom(dto.getPrenom());
        administratif.setQualite(dto.getQualite());
        administratif.setSalaire(dto.getSalaire());
        administratif.setTel(dto.getTel());
        administratif.setDisponible(dto.getDisponible());

        return administratif;
    }
}