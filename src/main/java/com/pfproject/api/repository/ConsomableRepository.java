package com.pfproject.api.repository;

import com.pfproject.api.model.stock.Consomable;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ConsomableRepository extends MongoRepository<Consomable, String> {

}
