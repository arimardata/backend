package com.pfproject.api.service.Personnel;

import com.pfproject.api.model.personnel.Administratif;
import com.pfproject.api.repository.Personnel.AdministratifRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

@Service
public class BasicAdministratifService implements AdministratifService {

    private final AdministratifRepository repository;
    static Logger log = Logger.getLogger(BasicAdministratifService.class.getName());

    @Autowired
    public BasicAdministratifService(final AdministratifRepository repository) {
        this.repository = repository;
    }

    @Override
    public Administratif find(final String id) {
        return repository.findOne(id);
    }

    @Override
    public List<Administratif> findAll() {
        return repository.findAll();
    }

    @Override
    public Administratif update(final String id, final Administratif administratif) {

        final Administratif saved = repository.findOne(id);
        ObjectId objectId = new ObjectId(id);
        administratif.setId(objectId);

        if (saved != null) {
            administratif.setCreatedAt(saved.getCreatedAt());
            administratif.setUpdatedAt(String.valueOf(LocalDateTime.now()));

        } else {
            administratif.setCreatedAt(String.valueOf(LocalDateTime.now()));
        }
        repository.save(administratif);
        return administratif;
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
        return id;
    }

    @Override
    public Administratif create(final Administratif administratif) {
        administratif.setCreatedAt(String.valueOf(LocalDateTime.now()));
        return repository.save(administratif);
    }

}
