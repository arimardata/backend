package com.pfproject.api.service;

import com.pfproject.api.model.AppelOffre;

import java.util.List;

public interface AppelOffreService {

	AppelOffre create(AppelOffre AppelOffre);

	AppelOffre find(String id);

	List<AppelOffre> findAll();

	AppelOffre update(String id, AppelOffre object);

	String delete(String id);

	List<String> findByEtat(String etat);

	AppelOffre findByNum_AO(String num_AO);

	Long countByEtat(String etat);

	Long count();

}
