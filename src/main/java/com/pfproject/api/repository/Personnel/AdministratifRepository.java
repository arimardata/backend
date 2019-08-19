package com.pfproject.api.repository.Personnel;

import com.pfproject.api.model.personnel.Administratif;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AdministratifRepository extends MongoRepository<Administratif, String> {

}
