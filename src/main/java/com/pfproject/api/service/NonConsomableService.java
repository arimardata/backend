package com.pfproject.api.service;

import com.pfproject.api.model.stock.Non_consomable;

import java.util.List;

public interface NonConsomableService {
    Non_consomable create(Non_consomable object);

    Non_consomable find(String id);

    List<Non_consomable> findAll();

    Non_consomable update(String id, Non_consomable object);

    String delete(String id);

    Long count();
}
