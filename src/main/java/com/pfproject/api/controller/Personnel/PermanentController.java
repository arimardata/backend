package com.pfproject.api.controller.Personnel;

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

import com.pfproject.api.service.Personnel.PermanentService;
import com.pfproject.api.model.personnel.Permanent;
import com.pfproject.api.dto.MessageDTO;
import com.pfproject.api.dto.personnel.PermanentDTO;

import org.apache.log4j.Logger;

import java.util.List;

@RestController
@RequestMapping(value = "/api/personnel/permanent")
public class PermanentController {

	private final PermanentService service;
	static Logger log = Logger.getLogger(PermanentController.class.getName());

	private final ConverterFacade converterFacade;

	@Autowired
	public PermanentController(final PermanentService service, final ConverterFacade converterFacade) {
		this.service = service;
		this.converterFacade = converterFacade;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody final PermanentDTO dto) {
		Permanent permanent = service.create(converterFacade.convertPermanent(dto));

		return new ResponseEntity<>(permanent, HttpStatus.OK);
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseEntity<?> find() {
		List<Permanent> liste = service.findAll();

		return new ResponseEntity<>(liste, HttpStatus.OK);
	}

	@RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find_one(@PathVariable String id) {
		Permanent saved = service.find(id);

		return new ResponseEntity<>(saved, HttpStatus.OK);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> Modifier(@PathVariable String id, @RequestBody final PermanentDTO dto) {

		Permanent permanent = service.update(id, converterFacade.convertPermanent(dto));

		return new ResponseEntity<>(permanent, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable String id) {
		service.delete(id);
		MessageDTO response = new MessageDTO();
		response.setMessage("materiel supprimé");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
