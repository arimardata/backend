package com.pfproject.api.controller;

import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/files")
public class FileController {

  private final GridFsTemplate gridFsTemplate;
  static Logger log = Logger.getLogger(FileController.class.getName());

  @Autowired
  public FileController(GridFsTemplate gridFsTemplate) {
    this.gridFsTemplate = gridFsTemplate;
  }

  @RequestMapping(method = RequestMethod.GET)
  public @ResponseBody List<String> list() {
    return getFiles().stream().map(GridFSDBFile::getFilename).collect(Collectors.toList());
  }

  @RequestMapping(path = "/{name:.+}", method = RequestMethod.GET)
  public HttpEntity<byte[]> get(@PathVariable("name") String name) {
    try {
      Optional<GridFSDBFile> optionalCreated = maybeLoadFile(name);
      if (optionalCreated.isPresent()) {
        GridFSDBFile created = optionalCreated.get();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        created.writeTo(os);
        HttpHeaders headers = new HttpHeaders();

        headers.add(HttpHeaders.CONTENT_TYPE, created.getContentType());
        return new HttpEntity<>(os.toByteArray(), headers);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (IOException e) {
      return new ResponseEntity<>(HttpStatus.IM_USED);
    }
  }

  private List<GridFSDBFile> getFiles() {
    return gridFsTemplate.find(null);
  }

  private Optional<GridFSDBFile> maybeLoadFile(String name) {
    GridFSDBFile file = gridFsTemplate.findOne(getFilenameQuery(name));
    return Optional.ofNullable(file);
  }

  private static Query getFilenameQuery(String name) {
    return Query.query(GridFsCriteria.whereFilename().is(name));
  }
}