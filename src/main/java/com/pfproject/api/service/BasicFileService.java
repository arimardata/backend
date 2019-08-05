package com.pfproject.api.service;

import com.mongodb.client.gridfs.GridFSBucket;
import com.pfproject.api.model.File;
import com.pfproject.api.repository.FileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;

@Service
public class BasicFileService implements FileService {

    private final FileRepository repository;
    static Logger log = Logger.getLogger(BasicChequeService.class.getName());

    @Autowired
    public BasicFileService(final FileRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<File> findAll() {
        return repository.findAll();
    }

    @Override
    public File findByFilename(String filename) {
        return repository.findByFilename(filename);
    }

}
