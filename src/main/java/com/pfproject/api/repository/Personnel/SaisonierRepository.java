package com.pfproject.api.repository.Personnel;

import java.util.List;

import com.pfproject.api.model.personnel.Saisonier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SaisonierRepository extends MongoRepository<Saisonier, String> {
    @Query("{archived : {$ne : ?0}}")
    List<Saisonier> findByArchivedNotEqual(Boolean archived);
}
