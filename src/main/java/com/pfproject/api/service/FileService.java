package com.pfproject.api.service;

import java.util.List;

import com.pfproject.api.model.File;

public interface FileService {

    List<File> findAll();

    File findByFilename(String filename);

}
