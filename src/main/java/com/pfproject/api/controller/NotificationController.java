package com.pfproject.api.controller;

import com.pfproject.api.converter.ConverterFacade;
import com.pfproject.api.dto.ChequeDTO;
import com.pfproject.api.dto.MessageDTO;
import com.pfproject.api.dto.NotificationDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/findnotseen", method = RequestMethod.GET)
	public ResponseEntity<?> findNotSeen() {
		System.out.println("tryFIND=====>");
		List<Notification> liste = service.findAll();
		int a = liste.size();
		for (int i = 0; i < a; i++) {
			if (liste.get(i).getNotificationSeen().equalsIgnoreCase("yes")) {
				liste.remove(i);
			}
		}
		System.out.println("tryFIND=====>"+liste.get(0).getId());
		return new ResponseEntity<>(liste, HttpStatus.OK);
		
	}

	@RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find_one(@PathVariable String id) {
		Notification saved = service.find(id);

		return new ResponseEntity<>(saved, HttpStatus.OK);
	}
	@RequestMapping(value = "/findfive", method = RequestMethod.GET)
	public ResponseEntity<?> findfive() {
		List<Notification> liste = service.findFirst5no();

		return new ResponseEntity<>(liste, HttpStatus.OK);
	}
	@RequestMapping(value = "/handleseen/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> Modifier(@PathVariable String id) {
		//Cheque saved = service.find(id);
		Notification saved = service.find(id);
		saved.setNotificationSeen("yes");
		service.update(id, saved);
		final MessageDTO response = new MessageDTO();
		response.setMessage("blabal");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@RequestMapping(value = "/handleall", method = RequestMethod.GET)
	public ResponseEntity<?> Modifiertt() {
		//Cheque saved = service.find(id);
		List<Notification> saved = service.findAll();
		for(int i=0;i<saved.size();i++) {
			saved.get(i).setNotificationSeen("yes");
			service.update(saved.get(i).getId(),saved.get(i));
		}

		final MessageDTO response = new MessageDTO();
		response.setMessage("blabal");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
