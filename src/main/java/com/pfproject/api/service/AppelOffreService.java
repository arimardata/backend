package com.pfproject.api.service;

import com.pfproject.api.model.AppelOffre;

import java.util.List;

public interface AppelOffreService {

	AppelOffre find(String id);

	List<AppelOffre> findAll();

	AppelOffre update(String id, AppelOffre object);

	String delete(String id);

	List<String> findByEtat(String etat);

	/* void Change_Etat(String id, String etat); */
}
