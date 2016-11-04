package edu.esprit.CrowdSourcingIdeas.services;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.esprit.CrowdSourcingIdeas.persistence.Notification;
import edu.esprit.CrowdSourcingIdeas.persistence.Customer;

/**
 * Session Bean implementation class ClientServiceEJBRemote
 */
@Stateless
@LocalBean
public class NotificationServiceEJB implements NotificationServiceEJBRemote {
	@PersistenceContext(unitName = "CrowdSourcingIdeas-ejb")
	EntityManager em;


	@Override
	public Collection<Notification> findAllNotificationsById(int idUser) {

	    return em.createQuery("from Notification n WHERE n.customer.idUser ="+idUser, Notification.class).getResultList();
	}
	
	@Override
	public void addUserToNotification(int idUser, int idNotification) {
		Notification c = em.find(Notification.class, idNotification);
		Customer customer = em.find(Customer.class, idUser);
		c.setCustomer(customer);
		
	}

}
