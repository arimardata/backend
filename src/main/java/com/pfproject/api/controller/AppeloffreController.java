package com.pfproject.api.controller;

import com.pfproject.api.converter.ConverterFacade;
import com.pfproject.api.dto.MessageDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pfproject.api.service.AppelOffreService;

import com.pfproject.api.model.AppelOffre;
import com.pfproject.api.model.Response;

import java.util.List;

@RestController
@RequestMapping(value = "/api/projects")
public class AppeloffreController {

	private final AppelOffreService service;

	private final ConverterFacade converterFacade;

	@Autowired
	public AppeloffreController(final AppelOffreService service, final ConverterFacade converterFacade) {
		this.service = service;
		this.converterFacade = converterFacade;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseEntity<?> find() {
		List<AppelOffre> liste = service.findAll();

		return new ResponseEntity<>(liste, HttpStatus.OK);
	}
	@RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find_one(@PathVariable String id) {
		AppelOffre saved = service.find(id);

		return new ResponseEntity<>(saved, HttpStatus.OK);
	}

	@RequestMapping(value = "/changeetat/{id}/{new_etat}", method = RequestMethod.GET)
	public ResponseEntity<?> Change_etat(@PathVariable String id ,@PathVariable String new_etat) {
		//Response response = new Response();
		AppelOffre saved=service.find(id);
		saved.setEtat(new_etat);
		/*service.Change_Etat(id, new_etat);*/
		service.update(id, saved);
		final MessageDTO response = new MessageDTO();
        response.setMessage("Mot de passe est changé avec succes");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// search route fonctional
	// @RequestMapping(value = "/find/{username}", method = RequestMethod.GET)
	// public ResponseEntity<?> findByUsername(@PathVariable final String username)
	// {
	// return new ResponseEntity<>(service.findByUsername(username), HttpStatus.OK);
	// }

	/*
	 * @RequestMapping(value = "/update/{id}", method = RequestMethod.POST) public
	 * ResponseEntity<?> update(@PathVariable final String id, @RequestBody final
	 * UserDTO dto) { User user = service.find(id);
	 * user.setUsername(dto.getUsername()); user.setFirstLogin(true);
	 * user.setPassword(dto.getPassword()); user.setAuthority(dto.getAuthority());
	 * service.update(id, user);
	 * 
	 * final MessageDTO response = new MessageDTO();
	 * response.setMessage("Mot de passe est changé avec succes");
	 * 
	 * return new ResponseEntity<>(response, HttpStatus.OK); }
	 * 
	 * @RequestMapping(value = "/passwordReset/{id}", method = RequestMethod.POST)
	 * public ResponseEntity<?> passwordReset(@PathVariable final String
	 * id, @RequestBody final UserDTO dto) { User user = service.find(id);
	 * 
	 * user.setFirstLogin(false); user.setPassword(dto.getPassword());
	 * service.update(id, user);
	 * 
	 * final MessageDTO response = new MessageDTO();
	 * response.setMessage("Mot de passe est changé avec succes"); return new
	 * ResponseEntity<>(response, HttpStatus.OK); }
	 * 
	 * @RequestMapping(value = "/disable/{id}", method = RequestMethod.DELETE)
	 * public ResponseEntity<?> delete(@PathVariable final String id) { //
	 * service.delete(id); final MessageDTO response = new MessageDTO();
	 * 
	 * User user = service.find(id); boolean isEnabled = user.isEnabled(); if
	 * (isEnabled) { response.setMessage("l'utilisateur a été bloqué");
	 * user.setEnabled(false); } else {
	 * response.setMessage("l'utilisateur a été débloqué"); user.setEnabled(true); }
	 * service.update(id, user);
	 * 
	 * return new ResponseEntity<>(response, HttpStatus.OK); }
	 */
}
