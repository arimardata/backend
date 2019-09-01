package com.pfproject.api.repository.Personnel;

import java.util.List;

import com.pfproject.api.model.personnel.Permanent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PermanentRepository extends MongoRepository<Permanent, String> {
    @Query("{archived : {$ne : ?0}}")
    List<Permanent> findByArchivedNotEqual(Boolean archived);
}
