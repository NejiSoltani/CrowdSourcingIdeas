package edu.esprit.CrowdSourcingIdeas.services;




import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import edu.esprit.CrowdSourcingIdeas.persistence.Customer;
import edu.esprit.CrowdSourcingIdeas.persistence.Idea;
import edu.esprit.CrowdSourcingIdeas.persistence.Like2;

import edu.esprit.CrowdSourcingIdeas.persistence.Reclamation;

/**
 * Session Bean implementation class IdeaServiceEJB
 */
@Stateless
@LocalBean
public class IdeaServiceEJB implements IdeaServiceEJBRemote {

	@PersistenceContext(name="CrowdSourcingIdeas-ejb") 
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public IdeaServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addIdea(Idea a) {
		em.persist(a);
		
	}

	@Override
	public List<Idea> findAll() {
		// TODO Auto-generated method stub
		
		return	em.createQuery("SELECT e FROM Idea e",Idea.class).getResultList();
			
		}

	@Override
	public void Delete(int id) {
		
	    Idea i = em.find(Idea.class,id);
	    em.remove(i);
		
	}

	@Override
	public void Update(Idea i) {
		
	    em.merge(i);
		
		
	}
	
	
	@Override
	public void UpdateIdeaByIdea(int id) {
		Idea i = em.find(Idea.class,id);
	    em.merge(i);
		
		
	}

	@Override
	public Idea findIdeaById(int idIdea) {
		
			return em.find(Idea.class,idIdea);
		}

	
	@Override
	public void addLikeToIdea(int numIdea,int idLike) {
		Idea b=em.find(Idea.class,numIdea);
		Like2 p=em.find(Like2.class,idLike);
            p.setIdea(b);	
	}

	@Override
	public List<Idea> SearchIdea(String subject) {
		return em.createQuery(" FROM Idea e where e.subject LIKE :subject")
				.setParameter("subject", "%" + subject + "%")
				.getResultList();
		}

	@Override
	public void DislikeIdea(int numIdea) {


	em.createQuery("DELETE FROM Like2 l WHERE l.idea.idIdea like :numIdea ")
	.setParameter("numIdea", numIdea).executeUpdate();
		
	}

	@Override
	public void addIdeaToCustomer(int numIdea, int idCustomer) {
		Idea b=em.find(Idea.class,numIdea);
		Customer p=em.find(Customer.class,idCustomer);
         b.setCustomer(p);
		
	}
	@Override
	public void reportIdea(int idUser, int idIdea) {
		Reclamation r = new Reclamation();
		Customer c1 = em.find(Customer.class, idUser);
		r.setSubject("Report Idea id:" + idIdea+" by "+c1.getFirstName());
		r.setCustomer(c1);
		r.setType("Idea");
		em.persist(r);

	}
	
	
	
	

	
	

	

	
	
	
	
	
	
	
	
	

	}

	


