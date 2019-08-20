package com.pfproject.api.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Notification")
public class Notification extends BaseEntity {
	private static final long serialVersionUID = 7937325925563724764L;
	
	//private ObjectId id;
	private String NotificationType;
	private String NotificationDetail;
	private String NotificationSeen;
	public String getNotificationType() {
		return NotificationType;
	}
	public void setNotificationType(String notificationType) {
		NotificationType = notificationType;
	}
	public String getNotificationDetail() {
		return NotificationDetail;
	}
	public void setNotificationDetail(String notificationDetail) {
		NotificationDetail = notificationDetail;
	}
	public String getNotificationSeen() {
		return NotificationSeen;
	}
	public void setNotificationSeen(String notificationSeen) {
		NotificationSeen = notificationSeen;
	}

	
	
	
	
	
}

