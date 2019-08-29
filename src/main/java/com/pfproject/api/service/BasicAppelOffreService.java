package com.pfproject.api.service;

import com.pfproject.api.model.AppelOffre;
import com.pfproject.api.repository.AppelOffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;

@Service
public class BasicAppelOffreService implements AppelOffreService {

	private final AppelOffreRepository repository;
	static Logger log = Logger.getLogger(BasicAppelOffreService.class.getName());

	@Autowired
	public BasicAppelOffreService(final AppelOffreRepository repository) {
		this.repository = repository;
	}

	@Override
	public AppelOffre create(AppelOffre AppelOffre) {
		AppelOffre.setCreatedAt(String.valueOf(LocalDateTime.now()));
		AppelOffre.setEtat("Favoris");
		return repository.save(AppelOffre);
	}

	@Override
	public AppelOffre find(final String id) {
		return repository.findOne(id);
	}

	@Override
	public List<AppelOffre> findAll() {
		return repository.findAll();
	}

	@Override
	public AppelOffre update(final String id, final AppelOffre project) {
		project.setId(id);

		final AppelOffre saved = repository.findOne(id);

		if (saved != null) {
			project.setCreatedAt(saved.getCreatedAt());
			project.setUpdatedAt(String.valueOf(LocalDateTime.now()));
		} else {
			project.setCreatedAt(String.valueOf(LocalDateTime.now()));
		}
		repository.save(project);
		return project;
	}

	@Override
	public String delete(final String id) {
		repository.delete(id);
		return id;
	}

	@Override
	public List<String> findByEtat(String etat) {
		List<AppelOffre> aos = repository.findByEtat(etat);
		List<String> numAos = new ArrayList<String>();
		for (AppelOffre ao : aos) {
			numAos.add(ao.getNum_AO());
		}
		return numAos;
	}

}
