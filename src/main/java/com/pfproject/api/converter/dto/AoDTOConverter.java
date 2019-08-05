package com.pfproject.api.converter.dto;

import org.springframework.core.convert.converter.Converter;

import com.pfproject.api.dto.AoDTO;
import com.pfproject.api.model.AppelOffre;

public class AoDTOConverter implements Converter<AoDTO, AppelOffre> {
	@Override
	public AppelOffre convert(final AoDTO dto) {
		final AppelOffre appel = new AppelOffre();

		appel.setAutres_details(dto.getAutres_details());
		appel.setCaution(dto.getCaution());
		appel.setCautionFinal(dto.getCautionFinal());
		appel.setChef_ouvrage(dto.getChef_ouvrage());
		appel.setDate_Limite(dto.getDate_Limite());
		appel.setEstimation(dto.getEstimation());
		appel.setEtat(dto.getEtat());
		appel.setFiles(dto.getFiles());
		appel.setId(dto.getId());
		appel.setMise_en_ligne(dto.getMise_en_ligne());
		appel.setMoinsDisant(dto.getMoinsDisant());
		appel.setNum_AO(dto.getNum_AO());
		appel.setNum_Ordre(dto.getNum_Ordre());
		appel.setPdfs(dto.getPdfs());
		appel.setType(dto.getType());
		appel.setVille(dto.getVille());

		return appel;
	}
}