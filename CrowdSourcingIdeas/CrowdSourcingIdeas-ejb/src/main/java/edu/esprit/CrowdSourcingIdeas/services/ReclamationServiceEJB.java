package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.CrowdSourcingIdeas.persistence.Reclamation;

/**
 * Session Bean implementation class ReclamationServiceEJB
 */
@Stateless
@LocalBean
public class ReclamationServiceEJB implements ReclamationServiceEJBRemote {
	
	@PersistenceContext(unitName="CrowdSourcingIdeas-ejb") // njibouha mel persistence.xml ()peristence unit 
	EntityManager em ;

    /**
     * Default constructor. 
     */
    public ReclamationServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean SendReclamation(Reclamation rec) {
		
		em.persist(rec);
		return true;
		
	}

	@Override
	public boolean UpdateReclamation(Reclamation rec)
	
	{
		em.merge(rec);	
		return true;
	}

	@Override
	public boolean DeleteReclamation(int idReclamation) {

		em.remove(GetReclamationById(idReclamation));	
		return true;	
	}
	
		
		
		
	
	@Override
	public List<Reclamation> GetAllReclamation() {
		System.out.println("List des reclamation!");
		return em.createQuery("SELECT r FROM Reclamation r",Reclamation.class).getResultList();
	}
	
	@Override
	public Reclamation GetReclamationById(int idReclamation) {
		System.out.println("List Reclamation par user ID "+idReclamation);
		return em.find(Reclamation.class, idReclamation);
	}

	

}


