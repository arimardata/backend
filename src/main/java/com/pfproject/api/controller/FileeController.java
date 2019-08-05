// package com.pfproject.api.controller;

// import com.pfproject.api.dto.MessageDTO;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;

// import com.pfproject.api.service.FileService;
// import com.pfproject.api.model.File;
// import org.apache.log4j.Logger;

// import java.util.List;

// @RestController
// @RequestMapping(value = "/api/files")
// public class FileController {

// private final FileService service;
// static Logger log = Logger.getLogger(AppeloffreController.class.getName());

// @Autowired
// public FileController(final FileService service) {
// this.service = service;
// }

// @RequestMapping(value = "/find", method = RequestMethod.GET)
// public ResponseEntity<?> find() {
// List<File> liste = service.findAll();

// return new ResponseEntity<>(liste, HttpStatus.OK);
// }

// @RequestMapping(value = "/findone/{filename}", method = RequestMethod.GET)
// public ResponseEntity<?> find_one(@PathVariable String filename) {
// File saved = service.findByFilename(filename);

// return new ResponseEntity<>(saved, HttpStatus.OK);
// }

// }
