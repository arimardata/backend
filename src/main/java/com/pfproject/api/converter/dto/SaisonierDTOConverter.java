package com.pfproject.api.converter.dto;

import org.springframework.core.convert.converter.Converter;

import com.pfproject.api.dto.personnel.SaisonierDTO;
import com.pfproject.api.model.personnel.Saisonier;

public class SaisonierDTOConverter implements Converter<SaisonierDTO, Saisonier> {
    @Override
    public Saisonier convert(final SaisonierDTO dto) {
        final Saisonier saisonier = new Saisonier();
        saisonier.setCin(dto.getCin());
        saisonier.setDateDeNaissance(dto.getDateDeNaissance());
        saisonier.setDiplome(dto.getDiplome());
        saisonier.setEmail(dto.getEmail());
        saisonier.setNom(dto.getNom());
        saisonier.setPrenom(dto.getPrenom());
        saisonier.setQualite(dto.getQualite());
        saisonier.setTel(dto.getTel());
        saisonier.setCoutParJour(dto.getCoutParJour());
        saisonier.setDateDebut(dto.getDateDebut());
        saisonier.setDateFin(dto.getDateFin());

        return saisonier;
    }
}