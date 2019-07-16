package com.pfproject.api.repository;

import com.pfproject.api.model.AppelOffre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AppelOffreRepository extends MongoRepository<AppelOffre, String> {

    // AppelOffre findById(final String id);

}
