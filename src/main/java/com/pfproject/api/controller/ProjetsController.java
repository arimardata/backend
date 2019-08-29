package com.pfproject.api.controller;

import com.pfproject.api.converter.ConverterFacade;
import com.pfproject.api.dto.project.ProjectDTO;
// import com.pfproject.api.converter.ConverterFacade;
import com.pfproject.api.dto.MessageDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pfproject.api.service.AppelOffreService;
import com.pfproject.api.model.AppelOffre;
import com.pfproject.api.model.Cheque;

import org.apache.log4j.Logger;

import java.io.IOException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/projets")
public class ProjetsController {

    private final AppelOffreService service;
    private final ConverterFacade converterFacade;


    @Autowired
    public ProjetsController(final AppelOffreService service, final ConverterFacade converterFacade) {
        super();
        this.service = service;
        this.converterFacade = converterFacade;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<?> find() {
        // List<AppelOffre> liste = service.findAll();

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody final ProjectDTO dto) {
        // AppelOffre AppelOffre = service.create(converterFacade.convertAo(dto));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
