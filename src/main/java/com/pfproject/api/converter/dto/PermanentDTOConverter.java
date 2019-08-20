package com.pfproject.api.converter.dto;

import org.springframework.core.convert.converter.Converter;

import com.pfproject.api.dto.personnel.PermanentDTO;
import com.pfproject.api.model.personnel.Permanent;

public class PermanentDTOConverter implements Converter<PermanentDTO, Permanent> {
    @Override
    public Permanent convert(final PermanentDTO dto) {
        final Permanent permanent = new Permanent();
        permanent.setCin(dto.getCIN());
        permanent.setCnss(dto.getCNSS());
        permanent.setDate_embauche(dto.getDateEmbauche());
        permanent.setDate_naissance(dto.getDateDeNaissance());
        permanent.setDiplome(dto.getDiplome());
        permanent.setEmail(dto.getEmail());
        permanent.setNom(dto.getNom());
        permanent.setPrenom(dto.getPrenom());
        permanent.setQualite(dto.getQualite());
        permanent.setSalaire(dto.getSalaire());
        permanent.setTel(dto.getTel());

        return permanent;
    }
}