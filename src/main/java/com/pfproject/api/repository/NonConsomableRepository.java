package com.pfproject.api.repository;

import com.pfproject.api.model.stock.Non_consomable;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface NonConsomableRepository extends MongoRepository<Non_consomable, String> {

}
