
package com.pfproject.api.controller;

import com.mongodb.DBObject;
import com.pfproject.api.converter.ConverterFacade;
import com.pfproject.api.dto.ChequeDTO;
//import com.pfproject.api.converter.ConverterFacade;
import com.pfproject.api.dto.MessageDTO;
import com.pfproject.api.dto.UserDTO;
import com.pfproject.api.model.Cheque;
import com.pfproject.api.model.Response;
import com.pfproject.api.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.pfproject.api.service.ChequeService;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.List;

@RestController
@RequestMapping(value = "/api/Cheques")
public class ChequeController {
	

	private final ChequeService service;

	static Logger log = Logger.getLogger(ChequeController.class.getName());
    private final ConverterFacade converterFacade;
	// private final ConverterFacade converterFacade;

	@Autowired
	public ChequeController(final ChequeService service , final ConverterFacade converterFacade ) {
		this.service = service;
		this.converterFacade = converterFacade;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public ResponseEntity<?> find() {
		List<Cheque> liste = service.findAll();

		return new ResponseEntity<>(liste, HttpStatus.OK);
	}

	@RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find_one(@PathVariable String id) {
		Cheque saved = service.find(id);

		return new ResponseEntity<>(saved, HttpStatus.OK);
	}

	@RequestMapping(value = "/modifier/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> Modifier(@PathVariable String id,@RequestBody final ChequeDTO dto) {
		//Cheque saved = service.find(id);
		service.update(id, converterFacade.convertCheque(dto));

		//saved.setEtat(new_etat);

		//service.update(id, saved);
		final MessageDTO response = new MessageDTO();
		response.setMessage("blabal");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody final ChequeDTO dto) {
        Cheque cheque = service.create(converterFacade.convertCheque(dto));
        return new ResponseEntity<>(cheque, HttpStatus.OK);
    }
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable String id) {
		String response=service.delete(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}	
	//public ResponseEntity<?> Add_Cheque(String Emetteur,String Recepteur, String Banque)

}