
package com.pfproject.api.converter.dto;

import org.springframework.core.convert.converter.Converter;

import com.pfproject.api.dto.NotificationDTO;

import com.pfproject.api.model.Notification;

public class NotificationDTOConverter implements Converter<NotificationDTO, Notification> {
	@Override
	public Notification convert(final NotificationDTO dto) {
		final Notification Notification = new Notification();

		// cheque.setId(dto.get);

		Notification.setNotificationDetail(dto.getNotificationDetail());
		Notification.setNotificationType(dto.getNotificationType());
		Notification.setNotificationSeen(dto.getNotificationSeen());

		// incase of multiple roles we use this
		// List<Authority> authorities = new ArrayList<>();
		// authorities.add(dto.getAuthority());
		// user.setAuthorities(authorities);

		return Notification;
	}
}
