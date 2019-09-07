package com.pfproject.api.service.Personnel;

import com.pfproject.api.model.personnel.Administratif;

import java.util.List;

public interface AdministratifService {
    Administratif create(Administratif object);

    Administratif find(String id);

    List<Administratif> findByArchived();

    List<Administratif> findAll();

    List<Administratif> findByArchivedNotEqual(final Boolean archived);

    Administratif update(String id, Administratif object);

    String delete(String id);

    Long count();
}
