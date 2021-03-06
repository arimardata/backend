package com.pfproject.api.controller.Personnel;

import com.pfproject.api.converter.ConverterFacade;
import com.pfproject.api.dto.MessageDTO;
import com.pfproject.api.dto.personnel.SaisonierDTO;
import com.pfproject.api.model.personnel.Saisonier;
import com.pfproject.api.service.Personnel.SaisonierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.apache.log4j.Logger;

import java.util.List;

@RestController
@RequestMapping(value = "/api/personnel/saisonier")
public class SaisonierController {

    private final SaisonierService service;
    static Logger log = Logger.getLogger(SaisonierController.class.getName());

    private final ConverterFacade converterFacade;

    @Autowired
    public SaisonierController(final SaisonierService service, final ConverterFacade converterFacade) {
        this.service = service;
        this.converterFacade = converterFacade;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody final SaisonierDTO dto) {
        Saisonier saisonier = service.create(converterFacade.convertSaisonier(dto));

        return new ResponseEntity<>(saisonier, HttpStatus.OK);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public ResponseEntity<?> find() {
        List<Saisonier> liste = service.findByArchivedNotEqual(true);

        return new ResponseEntity<>(liste, HttpStatus.OK);
    }

    @RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find_one(@PathVariable String id) {
        Saisonier saved = service.find(id);

        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> Modifier(@PathVariable String id, @RequestBody final SaisonierDTO dto) {

        Saisonier saisonier = service.update(id, converterFacade.convertSaisonier(dto));

        return new ResponseEntity<>(saisonier, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        MessageDTO response = new MessageDTO();
        response.setMessage("materiel supprimé");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
