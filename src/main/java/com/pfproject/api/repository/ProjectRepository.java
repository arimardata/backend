
package com.pfproject.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pfproject.api.model.project.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {

}
