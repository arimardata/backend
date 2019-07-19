package com.pfproject.api.repository;

import com.pfproject.api.model.AppelOffre;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AppelOffreRepository extends MongoRepository<AppelOffre, String> {

}
