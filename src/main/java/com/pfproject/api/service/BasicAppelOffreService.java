package com.pfproject.api.service;

import com.pfproject.api.model.AppelOffre;
import com.pfproject.api.repository.AppelOffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

	@Override
	public List<String> findByEtat(String etat) {
		return repository.findByEtat(etat);
	}
}
