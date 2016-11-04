package edu.esprit.CrowdSourcingIdeas.services;

import javax.ejb.Remote;

import edu.esprit.CrowdSourcingIdeas.persistence.Contact;


@Remote
public interface ContactServiceEJBRemote {

	void addFeedBack(Contact f);
	
	void addContact(Contact f);
	
	void addUserToContact(int idUser,int idContact);

}
