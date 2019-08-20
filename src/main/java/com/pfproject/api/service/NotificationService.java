package com.pfproject.api.service;
import java.util.List;


import com.pfproject.api.model.Notification;

public interface NotificationService {
	Notification find(String id);

	List<Notification> findAll();

	Notification update(String id, Notification object);

	String delete(String id);

	Notification create(Notification Notification);
	
	/*Cheque Modifier(String id, Cheque object);*/

	/* void Change_Etat(String id, String etat); */
}
