package com.pfproject.api.controller;

import com.pfproject.api.converter.ConverterFacade;
import com.pfproject.api.dto.stock.ConsomableDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pfproject.api.service.ConsomableService;
import com.pfproject.api.model.stock.Consomable;
import com.pfproject.api.dto.MessageDTO;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/stock/consomable")
public class ConsomableController {

	private final ConsomableService service;
	static Logger log = Logger.getLogger(AppeloffreController.class.getName());

	private final ConverterFacade converterFacade;

	@Autowired
	public ConsomableController(final ConsomableService service, final ConverterFacade converterFacade) {
		this.service = service;
		this.converterFacade = converterFacade;
	}
	/*
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody final ConsomableDTO dto) {
		Consomable consomable = service.create(converterFacade.convertConsomable(dto));

		return new ResponseEntity<>(consomable, HttpStatus.OK);
	}*/

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseEntity<?> find() {
		List<Consomable> liste = service.findAll();

		return new ResponseEntity<>(liste, HttpStatus.OK);
	}

	@RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find_one(@PathVariable String id) {
		Consomable saved = service.find(id);

		return new ResponseEntity<>(saved, HttpStatus.OK);
	}
	/*
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> Modifier(@PathVariable String id, @RequestBody final ConsomableDTO dto) {

		Consomable consomable = service.update(id, converterFacade.convertConsomable(dto));

		return new ResponseEntity<>(consomable, HttpStatus.OK);
	}
*/
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable String id) {
		service.delete(id);
		MessageDTO response = new MessageDTO();
		response.setMessage("materiel supprimé");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
