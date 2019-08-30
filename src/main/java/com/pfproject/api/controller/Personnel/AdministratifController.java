package com.pfproject.api.controller.Personnel;

import com.pfproject.api.converter.ConverterFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pfproject.api.service.Personnel.*;
import com.pfproject.api.dto.MessageDTO;
import com.pfproject.api.dto.personnel.AdministratifDTO;
import com.pfproject.api.model.personnel.Administratif;
import com.pfproject.api.model.personnel.Permanent;
import com.pfproject.api.model.personnel.Saisonier;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/personnel/administratif")
public class AdministratifController {

    private final AdministratifService service;
    // private final PermanentService permanentservice;
    // private final SaisonierService saisonierservice;

    private final ConverterFacade converterFacade;

    @Autowired
    public AdministratifController(final AdministratifService service, final ConverterFacade converterFacade) {
        this.service = service;
        this.converterFacade = converterFacade;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody final AdministratifDTO dto) {
        Administratif administratif = service.create(converterFacade.convertAdministratif(dto));

        return new ResponseEntity<>(administratif, HttpStatus.OK);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<?> find() {
        List<Administratif> liste = service.findAll();

        return new ResponseEntity<>(liste, HttpStatus.OK);
    }

    // @RequestMapping(value = "/findNomPrenom", method = RequestMethod.GET)
    // public ResponseEntity<?> findNomPrenom() {
    // ArrayList<Administratif> administratifs = service.findAll();
    // ArrayList<Saisonier> saisoniers = saisonierservice.findAll();
    // ArrayList<Permanent> permanents = permanentservice.findAll();

    // ArrayList<HashMap<String, String>> response = new ArrayList<HashMap<String,
    // String>>();

    // for (Aministratif administratif : administratifs) {
    // HashMap<String, String> values = new HashMap<String, String>();
    // values.put("id", administratif.getId());
    // values.put("nom", administratif.getNom() + " " + administratif.getPrenom());
    // response.add(values);
    // }

    // for (Saisonier saisonier : saisoniers) {
    // HashMap<String, String> values = new HashMap<String, String>();
    // values.put("id", saisonier.getId());
    // values.put("nom", saisonier.getNom() + " " + saisonier.getPrenom());
    // response.add(values);
    // }

    // for (Permanents permanent : permanents) {
    // HashMap<String, String> values = new HashMap<String, String>();
    // values.put("id", permanent.getId());
    // values.put("nom", permanent.getNom() + " " + permanent.getPrenom());
    // response.add(values);
    // }

    // return new ResponseEntity<>(response, HttpStatus.OK);
    // }

    @RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find_one(@PathVariable String id) {
        Administratif saved = service.find(id);

        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> Modifier(@PathVariable String id, @RequestBody final AdministratifDTO dto) {

        Administratif administratif = service.update(id, converterFacade.convertAdministratif(dto));

        return new ResponseEntity<>(administratif, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        MessageDTO response = new MessageDTO();
        response.setMessage("materiel supprimé");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
