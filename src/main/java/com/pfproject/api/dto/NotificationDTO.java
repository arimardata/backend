package com.pfproject.api.dto;

import java.io.Serializable;

import org.bson.types.ObjectId;

public class NotificationDTO implements Serializable {
	private static final long serialVersionUID = 61904874549257678L;
	private ObjectId id;

	private String NotificationType;
	private String NotificationDetail;
	private String NotificationSeen;


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ObjectId getId() {
		return id;
	}

	public String getNotificationType() {
		return NotificationType;
	}

	public void setNotificationType(String notificationType) {
		this.NotificationType = notificationType;
	}

	public String getNotificationDetail() {
		return NotificationDetail;
	}

	public void setNotificationDetail(String notificationDetail) {
		this.NotificationDetail = notificationDetail;
	}

	public String getNotificationSeen() {
		return NotificationSeen;
	}

	public void setNotificationSeen(String notificationSeen) {
		this.NotificationSeen = notificationSeen;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}





}