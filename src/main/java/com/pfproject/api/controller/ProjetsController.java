package com.pfproject.api.controller;

import com.pfproject.api.converter.ConverterFacade;
import com.pfproject.api.dto.project.ProjectDTO;
import com.pfproject.api.model.project.Project;
import com.pfproject.api.service.project.ProjectService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/projets")
public class ProjetsController {

    private final ProjectService service;
    private final ConverterFacade converterFacade;

    @Autowired
    public ProjetsController(final ProjectService service, final ConverterFacade converterFacade) {
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
        Project project = service.create(converterFacade.convertProject(dto));
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

}
