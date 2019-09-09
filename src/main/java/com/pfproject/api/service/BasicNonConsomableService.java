package com.pfproject.api.service;

import com.pfproject.api.model.stock.Non_consomable;
import com.pfproject.api.repository.NonConsomableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

@Service
public class BasicNonConsomableService implements NonConsomableService {

    private final NonConsomableRepository repository;
    static Logger log = Logger.getLogger(BasicChequeService.class.getName());

    @Autowired
    public BasicNonConsomableService(final NonConsomableRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public Non_consomable find(final String id) {
        return repository.findOne(id);
    }

    @Override
    public List<Non_consomable> findAll() {
        return repository.findAll();
    }

    @Override
    public Non_consomable update(final String id, final Non_consomable nonconsomable) {

        final Non_consomable saved = repository.findOne(id);
        ObjectId objectId = new ObjectId(id);
        nonconsomable.setId(objectId);

        if (saved != null) {
            nonconsomable.setCreatedAt(saved.getCreatedAt());
            nonconsomable.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        } else {
            nonconsomable.setCreatedAt(String.valueOf(LocalDateTime.now()));
        }
        repository.save(nonconsomable);
        return nonconsomable;
    }

    @Override
    public String delete(final String id) {
        repository.delete(id);
        return id;
    }

    @Override
    public Non_consomable create(final Non_consomable nonconsomable) {
        nonconsomable.setCreatedAt(String.valueOf(LocalDateTime.now()));
        return repository.save(nonconsomable);
    }

}
