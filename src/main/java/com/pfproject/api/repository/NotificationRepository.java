
package com.pfproject.api.repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfproject.api.model.AppelOffre;
import com.pfproject.api.model.Notification;
import com.pfproject.api.model.User;



@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
	
	
		
	    @Query("{NotificationSeen: 'no'}")
		List<Notification> findFirst5();
	    
	    @Query("{ NotificationSeen : 'no' }")
	    Page<Notification> findOneActiveOldest(Pageable pageable);

}
/*
@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
	@Quyery("{}")
	List<Notification> findNotSeen()
}

*/