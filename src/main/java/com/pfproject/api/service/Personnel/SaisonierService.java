package com.pfproject.api.service.Personnel;

import com.pfproject.api.model.personnel.Saisonier;

import java.util.List;

public interface SaisonierService {
    Saisonier create(Saisonier object);

    List<Saisonier> findByArchived();

    Saisonier find(String id);

    List<Saisonier> findAll();

    List<Saisonier> findByArchivedNotEqual(final Boolean archived);

    Saisonier update(String id, Saisonier object);

    String delete(String id);

    Long count();
}
