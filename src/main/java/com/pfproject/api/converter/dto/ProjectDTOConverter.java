package com.pfproject.api.converter.dto;

import org.springframework.core.convert.converter.Converter;

import com.pfproject.api.dto.project.ProjectDTO;
import com.pfproject.api.model.project.Project;

public class ProjectDTOConverter implements Converter<ProjectDTO, Project> {

    public ProjectDTOConverter() {
        super();
    }

    @Override
    public Project convert(final ProjectDTO dto) {
        final Project project = new Project();
        

        return project;
    }
}