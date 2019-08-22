package com.pfproject.api.controller;

import com.pfproject.api.converter.ConverterFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.pfproject.api.service.NotificationService;
import com.pfproject.api.model.Notification;
import org.apache.log4j.Logger;


import java.util.List;


@RestController
@RequestMapping(value = "/api/notifications")
public class NotificationController {

	private final NotificationService service;
	static Logger log = Logger.getLogger(NotificationController.class.getName());

	private final ConverterFacade converterFacade;
	// private final ConverterFacade converterFacade;

	@Autowired
	public NotificationController(final NotificationService service, final ConverterFacade converterFacade) {
		this.service = service;
		this.converterFacade = converterFacade;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseEntity<?> find() {
		List<Notification> liste = service.findAll();

		return new ResponseEntity<>(liste, HttpStatus.OK);
	}

	@RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find_one(@PathVariable String id) {
		Notification saved = service.find(id);

		return new ResponseEntity<>(saved, HttpStatus.OK);
	}

}
