package com.pfproject.api.service.Personnel;

import com.pfproject.api.model.personnel.Saisonier;
import com.pfproject.api.repository.Personnel.SaisonierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

@Service
public class BasicSaisonierService implements SaisonierService {

    private final SaisonierRepository repository;
    static Logger log = Logger.getLogger(BasicAdministratifService.class.getName());

    @Autowired
    public BasicSaisonierService(final SaisonierRepository repository) {
        this.repository = repository;
    }

    @Override
    public Saisonier find(final String id) {
        return repository.findOne(id);
    }

    @Override
    public List<Saisonier> findAll() {
        return repository.findAll();
    }

    @Override
    public Saisonier update(final String id, final Saisonier saisonier) {

        final Saisonier saved = repository.findOne(id);
        ObjectId objectId = new ObjectId(id);
        saisonier.setId(objectId);

        if (saved != null) {
            saisonier.setCreatedAt(saved.getCreatedAt());
            saisonier.setCreatedAt(String.valueOf(LocalDateTime.now()));

        } else {
            saisonier.setCreatedAt(String.valueOf(LocalDateTime.now()));
        }
        repository.save(saisonier);
        return saisonier;
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
    public Saisonier create(final Saisonier saisonier) {
        saisonier.setCreatedAt(String.valueOf(LocalDateTime.now()));
        return repository.save(saisonier);
    }

}
