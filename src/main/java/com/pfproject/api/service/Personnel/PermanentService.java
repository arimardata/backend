package com.pfproject.api.service.Personnel;

import com.pfproject.api.model.personnel.Permanent;

import java.util.List;

public interface PermanentService {
    Permanent create(Permanent object);

    List<Permanent> findByArchived();

    Permanent find(String id);

    List<Permanent> findAll();

    List<Permanent> findByArchivedNotEqual(final Boolean archived);

    Permanent update(String id, Permanent object);

    String delete(String id);

    Long count();
}
