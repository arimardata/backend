package com.pfproject.api.service.Personnel;

import com.pfproject.api.model.personnel.Saisonier;

import java.util.List;

public interface SaisonierService {
    Saisonier create(Saisonier object);

    Saisonier find(String id);

    List<Saisonier> findAll();

    Saisonier update(String id, Saisonier object);

    String delete(String id);
}