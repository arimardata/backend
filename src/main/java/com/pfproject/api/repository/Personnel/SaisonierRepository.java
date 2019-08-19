package com.pfproject.api.repository.Personnel;

import com.pfproject.api.model.personnel.Saisonier;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface SaisonierRepository extends MongoRepository<Saisonier, String> {

}
