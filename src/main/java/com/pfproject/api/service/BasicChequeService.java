package com.pfproject.api.service;


import com.pfproject.api.model.Cheque;
import com.pfproject.api.repository.ChequeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;

@Service
public class BasicChequeService implements ChequeService {

	private final ChequeRepository repository;
	static Logger log = Logger.getLogger(BasicChequeService.class.getName());

	@Autowired
	public BasicChequeService(final ChequeRepository repository) {
		this.repository = repository;
	}

	@Override
	public Cheque find(final String id) {
		return repository.findOne(id);
	}

	@Override
	public List<Cheque> findAll() {
		return repository.findAll();
	}

	@Override
	public Cheque update(final String id, final Cheque Cheque) {
		Cheque.setId(id);

		final Cheque saved = repository.findOne(id);

		if (saved != null) {
			Cheque.setCreatedAt(saved.getCreatedAt());
			Cheque.setUpdatedAt(String.valueOf(LocalDateTime.now()));
		} else {
			Cheque.setCreatedAt(String.valueOf(LocalDateTime.now()));
		}
		repository.save(Cheque);
		return Cheque;
	}

	@Override
	public String delete(final String id) {
		repository.delete(id);
		return id;
	}
	/*
	 * @Override public void Change_Etat(final String id,final String New_Etat) {
	 * 
	 * final AppelOffre saved=repository.findOne(id);
	 * 
	 * saved.setEtat(New_Etat);
	 * 
	 * repository.save();
	 * 
	 * }
	 */
}
