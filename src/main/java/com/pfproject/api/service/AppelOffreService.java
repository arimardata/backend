package com.pfproject.api.service;

import com.pfproject.api.model.AppelOffre;

import java.util.List;

public interface AppelOffreService {
	
	AppelOffre create(AppelOffre AppelOffre);

	AppelOffre find(String id);

	List<AppelOffre> findAll();

	AppelOffre update(String id, AppelOffre object);

	String delete(String id);

	/* void Change_Etat(String id, String etat); */
}
