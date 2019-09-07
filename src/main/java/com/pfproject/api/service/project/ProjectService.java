package com.pfproject.api.service.project;

import com.pfproject.api.model.project.Project;

import java.util.List;

public interface ProjectService {

    Project create(Project AppelOffre);

    Project find(String id);

    List<Project> findAll();

    List<Project> findByType(String type);

    Project findByNumAO(String numAo);

    Project update(String id, Project project);

}
