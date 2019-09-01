package com.pfproject.api.service.Personnel;

import com.pfproject.api.model.personnel.Permanent;
import com.pfproject.api.repository.Personnel.PermanentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;

@Service
public class BasicPermanentService implements PermanentService {

    private final PermanentRepository repository;
    static Logger log = Logger.getLogger(BasicAdministratifService.class.getName());

    @Autowired
    public BasicPermanentService(final PermanentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public Permanent find(final String id) {
        return repository.findOne(id);
    }

    @Override
    public List<Permanent> findAll() {
        return repository.findAll();
    }

    @Override
    public Permanent update(final String id, final Permanent permanent) {

        final Permanent saved = repository.findOne(id);
        ObjectId objectId = new ObjectId(id);
        permanent.setId(objectId);

        if (saved != null) {
            permanent.setCreatedAt(saved.getCreatedAt());
            permanent.setCreatedAt(String.valueOf(LocalDateTime.now()));

        } else {
            permanent.setCreatedAt(String.valueOf(LocalDateTime.now()));
        }
        repository.save(permanent);
        return permanent;
    }
    /*
     * @Override public Cheque Modifier(final String id, final Cheque Cheque) {
     * Cheque.setId(id);
     * 
     * return null; }
     */

    @Override
    public String delete(final String id) {
        Permanent saved = repository.findOne(id);
        saved.setArchived(true);
        repository.save(saved);
        return id;
    }

    @Override
    public List<Permanent> findByArchived() {
        return repository.findByArchivedNotEqual(true);
    }

    @Override
    public Permanent create(final Permanent permanent) {
        permanent.setCreatedAt(String.valueOf(LocalDateTime.now()));
        permanent.setDisponible(true);
        permanent.setArchived(false);
        return repository.save(permanent);
    }

}
