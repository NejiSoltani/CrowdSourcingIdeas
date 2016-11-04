package edu.esprit.CrowdSourcingIdeas.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.CrowdSourcingIdeas.persistence.Contact;
import edu.esprit.CrowdSourcingIdeas.persistence.Customer;

/**
 * Session Bean implementation class ClientServiceEJBRemote
 */
@Stateless
@LocalBean
public class ContactServiceEJB implements ContactServiceEJBRemote {
	@PersistenceContext(unitName = "CrowdSourcingIdeas-ejb")
	EntityManager em;

	public ContactServiceEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addFeedBack(Contact f) {
		f.setType("FeedBack");
		em.persist(f);

	}

	@Override
	public void addContact(Contact f) {
		f.setType("Contact");
		em.persist(f);
		
	}

	@Override
	public void addUserToContact(int idUser, int idContact) {
		Contact c = em.find(Contact.class, idContact);
		Customer customer = em.find(Customer.class, idUser);
		c.setCustomer(customer);
		
	}


}
