package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.CrowdSourcingIdeas.persistence.Customer;
import edu.esprit.CrowdSourcingIdeas.persistence.Photo;

/**
 * Session Bean implementation class PhotoServiceEjb
 */
@Stateless
@LocalBean
public class PhotoServiceEjb implements PhotoServiceEjbRemote {
	@PersistenceContext(unitName="CrowdSourcingIdeas-ejb")
	EntityManager em ;

    /**
     * Default constructor. 
     */
    public PhotoServiceEjb() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean addPhoto(Photo p) {
		em.persist(p);
		return true;
		
	}

	@Override
	public boolean removePhoto(int idPhoto) {
		em.remove(FindPhotoById(idPhoto));
		return true;
		
	}

	@Override
	public boolean UpdatePhoto(Photo p) {
		em.merge(p);
		return true;
		
	}

	@Override
	public List<Photo> ListPhoto() {
		return em.createQuery("SELECT p FROM Photo p",Photo.class).getResultList();
		
	}

	@Override
	public List<Photo> ListPhotouser(int customer_idUser) {
		// TODO Auto-generated method stub
		 return em.createQuery("SELECT p FROM `Photo` p where p.customer_idUser=?" ,Photo.class).getResultList();
	}

	@Override
	public Photo FindPhotoById(int idPhoto) {
		return em.find(Photo.class, idPhoto);
	}

}
