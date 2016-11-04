package edu.esprit.CrowdSourcingIdeas.services;

import java.util.Collection;

import javax.ejb.Remote;

import edu.esprit.CrowdSourcingIdeas.persistence.Notification;


@Remote
public interface NotificationServiceEJBRemote {

	Collection<Notification> findAllNotificationsById(int idUser);
	void addUserToNotification(int idUser, int idNotification);

}
