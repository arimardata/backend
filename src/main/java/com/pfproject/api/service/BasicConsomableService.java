package com.pfproject.api.service;

import com.pfproject.api.model.stock.Consomable;
import com.pfproject.api.repository.ConsomableRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

@Service
public class BasicConsomableService implements ConsomableService {

    private final ConsomableRepository repository;
    static Logger log = Logger.getLogger(BasicChequeService.class.getName());

    @Autowired
    public BasicConsomableService(final ConsomableRepository repository) {
        this.repository = repository;
    }

    @Override
    public Consomable find(final String id) {
        return repository.findOne(id);
    }

    @Override
    public List<Consomable> findAll() {
        return repository.findAll();
    }

    @Override
    public Consomable update(final String id, final Consomable consomable) {

        final Consomable saved = repository.findOne(id);
        ObjectId objectId = new ObjectId(id);
        consomable.setId(objectId);

        if (saved != null) {
            consomable.setCreatedAt(saved.getCreatedAt());
            consomable.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        } else {
            consomable.setCreatedAt(String.valueOf(LocalDateTime.now()));
        }
        repository.save(consomable);
        return consomable;
    }
    /*
     * @Override public Cheque Modifier(final String id, final Cheque Cheque) {
     * Cheque.setId(id);
     * 
     * return null; }
     */

    @Override
    public String delete(final String id) {
        repository.delete(id);
        final Consomable saved = repository.findOne(id);
        return id;
    }

    @Override
    public Consomable create(final Consomable consomable) {
        consomable.setCreatedAt(String.valueOf(LocalDateTime.now()));
        return repository.save(consomable);
    }

}
