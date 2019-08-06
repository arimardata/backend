package com.pfproject.api.converter.dto;

import org.springframework.core.convert.converter.Converter;

import com.pfproject.api.dto.ChequeDTO;

import com.pfproject.api.model.Cheque;


public class ChequeDTOConverter implements Converter<ChequeDTO, Cheque> {
	@Override
    public Cheque convert(final ChequeDTO dto) {
        final Cheque cheque = new Cheque();
        cheque.setAlerte(dto.getAlerte());
        cheque.setBanque(dto.getBanque());
        
        cheque.setEmail(dto.getEmail());
        cheque.setCompte(dto.getCompte());
        cheque.setTelephone(dto.getTelephone());
        cheque.setDate(dto.getDate());
        cheque.setEmetteur(dto.getEmetteur());
        cheque.setEtat(dto.getEtat());
        //cheque.setId(dto.get);
        cheque.setRecepteur(dto.getRecepteur());
        cheque.setSomme(dto.getSomme());
        cheque.setSent(dto.getSent());
        
     

        // incase of multiple roles we use this
        // List<Authority> authorities = new ArrayList<>();
        // authorities.add(dto.getAuthority());
        // user.setAuthorities(authorities);

        
        return cheque;
    }
}
