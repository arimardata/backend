package com.pfproject.api.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Notification")
public class Notification extends BaseEntity {
	private static final long serialVersionUID = 7937325925563724764L;
	
	//private ObjectId id;
	private String notificationType;
	private String notificationDetail;
	private String notificationSeen;
	public String getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}
	public String getNotificationDetail() {
		return notificationDetail;
	}
	public void setNotificationDetail(String notificationDetail) {
		this.notificationDetail = notificationDetail;
	}
	public String getNotificationSeen() {
		return notificationSeen;
	}
	public void setNotificationSeen(String notificationSeen) {
		this.notificationSeen = notificationSeen;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
	
	
	
}

