package com.pfproject.api.repository.Personnel;

import java.util.List;

import com.pfproject.api.model.personnel.Administratif;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratifRepository extends MongoRepository<Administratif, String> {
    @Query("{archived : {$ne : ?0}}")
    List<Administratif> findByArchivedNotEqual(Boolean archived);
}
