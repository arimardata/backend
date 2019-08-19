package com.pfproject.api.service.Personnel;

import com.pfproject.api.model.personnel.Permanent;

import java.util.List;

public interface PermanentService {
    Permanent create(Permanent object);

    Permanent find(String id);

    List<Permanent> findAll();

    Permanent update(String id, Permanent object);

    String delete(String id);
}
