
package com.pfproject.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfproject.api.model.project.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
    @Query("{ 'numAo' : ?0 }")
    Project findByNumAO(final String numAo);
}
