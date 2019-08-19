package com.pfproject.api.repository.Personnel;

import com.pfproject.api.model.personnel.Permanent;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PermanentRepository extends MongoRepository<Permanent, String> {

}
