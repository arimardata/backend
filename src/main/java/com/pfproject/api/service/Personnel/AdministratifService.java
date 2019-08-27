package com.pfproject.api.service.Personnel;

import com.pfproject.api.model.personnel.Administratif;

import java.util.List;

public interface AdministratifService {
    Administratif create(Administratif object);

    Administratif find(String id);

    List<Administratif> findAll();

    Administratif update(String id, Administratif object);

    String delete(String id);
}
