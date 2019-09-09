
package com.pfproject.api.service;


import com.pfproject.api.model.Cheque;
import com.pfproject.api.model.Notification;
import com.pfproject.api.model.User;
import com.pfproject.api.repository.ChequeRepository;
import com.pfproject.api.repository.NotificationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;



import org.apache.log4j.Logger;

@Service
public class BasicNotificationService implements NotificationService {

	private final NotificationRepository repository;
	static Logger log = Logger.getLogger(BasicNotificationService.class.getName());
	//private final MongoTemplate mongoTemplate=new MongoTemplate());
	
	@Autowired
	public BasicNotificationService(final NotificationRepository repository) {
		this.repository = repository;
		
	}

	@Override
	public Notification find(final String id) {
		return repository.findOne(id);
	}

	@Override
	public List<Notification> findAll() {
		return repository.findAll();
	}

	@Override
	public Notification update(final String id, final Notification Notification) {
		Notification.setId(id);

		final Notification saved = repository.findOne(id);

		if (saved != null) {
			Notification.setCreatedAt(saved.getCreatedAt());
			Notification.setUpdatedAt(String.valueOf(LocalDateTime.now()));
		} else {
			Notification.setCreatedAt(String.valueOf(LocalDateTime.now()));
		}
		repository.save(Notification);
		return Notification;
	}
	
	/*
	@Override
	public Cheque Modifier(final String id, final Cheque Cheque) {
		Cheque.setId(id);
		
		return null;
	}*/

	@Override
	public String delete(final String id) {
		repository.delete(id);
		final Notification saved = repository.findOne(id);
		return id;
	}
	@Override
    public Notification create(final Notification Notification) {
		Notification.setCreatedAt(String.valueOf(LocalDateTime.now()));
        return repository.save(Notification);
    }

	@Override
	public List<Notification> findFirst5no() {
	PageRequest request = new PageRequest(0, 5);
	List<Notification> not = repository.findOneActiveOldest(request).getContent();
	return not;
	
	}
	/*
	@Override
    public List<Notification> findFirst5() {
        Query query = new Query(Criteria.where("seen").is("no")).limit(5);
        
        repository.find(query,Notification.class);
        		return mongoTemplate.find(query, Notification.class);
    }
	*/
	/*
	 * @Override public void Change_Etat(final String id,final String New_Etat) {
	 * 
	 * final AppelOffre saved=repository.findOne(id);
	 * 
	 * saved.setEtat(New_Etat);
	 * 
	 * repository.save();
	 * 
	 * }
	 */

	
}
