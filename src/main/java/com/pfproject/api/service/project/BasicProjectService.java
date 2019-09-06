package com.pfproject.api.service.project;

import com.pfproject.api.model.project.Project;
import com.pfproject.api.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import org.bson.types.ObjectId;

import org.apache.log4j.Logger;

@Service
public class BasicProjectService implements ProjectService {

    private final ProjectRepository repository;
    static Logger log = Logger.getLogger(BasicProjectService.class.getName());

    @Autowired
    public BasicProjectService(final ProjectRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Project create(Project project) {
        project.setCreatedAt(String.valueOf(LocalDateTime.now()));
        project.setType(("Projet"));
        return repository.save(project);
    }

    @Override
    public Project find(final String id) {
        return repository.findOne(id);
    }

    @Override
    public List<Project> findAll() {
        return repository.findAll();
    }

    @Override
    public Project findByNumAO(String numAo) {
        return repository.findByNumAO(numAo);
    }

    @Override
    public Project update(String id, Project project) {
        ObjectId objectId = new ObjectId(id);
        project.setId(objectId);

        repository.save(project);

        return project;
    }

}
