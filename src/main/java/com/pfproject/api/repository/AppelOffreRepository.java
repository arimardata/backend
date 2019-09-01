package com.pfproject.api.repository;

import java.util.List;

import com.pfproject.api.model.AppelOffre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppelOffreRepository extends MongoRepository<AppelOffre, String> {
    List<AppelOffre> findByEtat(final String etat);

    @Query("{ 'num_AO' : ?0 }")
    AppelOffre findByNumAO(final String num_AO);

    @Query(value = "{'etat': {$regex: '^?0$', $options: 'i'}}", count = true)
    public Long countByEtat(String etat);
}
