package com.pfproject.api.converter.dto;

import org.springframework.core.convert.converter.Converter;

import com.pfproject.api.dto.personnel.SaisonierDTO;
import com.pfproject.api.model.personnel.Saisonier;

public class SaisonierDTOConverter implements Converter<SaisonierDTO, Saisonier> {
    @Override
    public Saisonier convert(final SaisonierDTO dto) {
        final Saisonier saisonier = new Saisonier();
        saisonier.setCin(dto.getCIN());
        saisonier.setDate_naissance(dto.getDateDeNaissance());
        saisonier.setDiplome(dto.getDiplome());
        saisonier.setEmail(dto.getEmail());
        saisonier.setNom(dto.getNom());
        saisonier.setPrenom(dto.getPrenom());
        saisonier.setQualite(dto.getQualite());
        saisonier.setTel(dto.getTel());
        saisonier.setCout_par_jour(dto.getCoutParJour());

        return saisonier;
    }
}