package com.pfproject.api.service;

import com.pfproject.api.model.stock.Consomable;

import java.util.List;

public interface ConsomableService {
    Consomable create(Consomable object);

    Consomable find(String id);

    List<Consomable> findAll();

    Consomable update(String id, Consomable object);

    String delete(String id);

    Long count();
}
