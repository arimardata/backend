package com.pfproject.api.service;
import java.util.List;

import com.pfproject.api.model.Cheque;

public interface ChequeService {
	Cheque find(String id);

	List<Cheque> findAll();

	Cheque update(String id, Cheque object);

	String delete(String id);

	/* void Change_Etat(String id, String etat); */
}
