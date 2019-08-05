package com.pfproject.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pfproject.api.model.File;

@Repository
public interface FileRepository extends MongoRepository<File, String> {
    File findByFilename(final String filename);
}
