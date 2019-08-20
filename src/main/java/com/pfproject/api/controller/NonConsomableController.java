package com.pfproject.api.controller;

import com.pfproject.api.converter.ConverterFacade;
import com.pfproject.api.dto.MessageDTO;
import com.pfproject.api.dto.stock.NonConsomableDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pfproject.api.service.NonConsomableService;
import com.pfproject.api.model.stock.Non_consomable;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/stock/nonconsomable")
public class NonConsomableController {

    private final NonConsomableService service;
    static Logger log = Logger.getLogger(AppeloffreController.class.getName());

    private final ConverterFacade converterFacade;

    @Autowired
    public NonConsomableController(final NonConsomableService service, final ConverterFacade converterFacade) {
        this.service = service;
        this.converterFacade = converterFacade;
    }
/*
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody final NonConsomableDTO dto) {
        Non_consomable non_consomable = service.create(converterFacade.convertNonConsomable(dto));

        return new ResponseEntity<>(non_consomable, HttpStatus.OK);
    }*/

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<?> find() {
        List<Non_consomable> liste = service.findAll();

        return new ResponseEntity<>(liste, HttpStatus.OK);
    }

    @RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find_one(@PathVariable String id) {
        Non_consomable saved = service.find(id);

        return new ResponseEntity<>(saved, HttpStatus.OK);
    }
/*
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> Modifier(@PathVariable String id, @RequestBody final NonConsomableDTO dto) {

        Non_consomable non_consomable = service.update(id, converterFacade.convertNonConsomable(dto));

        return new ResponseEntity<>(non_consomable, HttpStatus.OK);
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
