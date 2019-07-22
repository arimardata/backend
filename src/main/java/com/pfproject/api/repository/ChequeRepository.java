package com.pfproject.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pfproject.api.model.Cheque;

@Repository
public interface ChequeRepository extends MongoRepository<Cheque, String> {

}

