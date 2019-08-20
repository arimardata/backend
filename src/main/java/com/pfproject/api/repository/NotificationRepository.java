
package com.pfproject.api.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pfproject.api.model.Notification;


@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {

}

