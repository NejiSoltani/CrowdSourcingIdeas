package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.CrowdSourcingIdeas.persistence.Like2;

/**
 * Session Bean implementation class LikeServiceEJB
 */
@Stateless
@LocalBean
public class LikeServiceEJB implements LikeServiceEJBRemote {
	@PersistenceContext(name="CrowdSourcingIdeas-ejb") 
	EntityManager em;
    /**
     * Default constructor. 
     */
    public LikeServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AddLike(Like2 l) {
		em.merge(l);
		
	}
	
	public boolean addLike(Like2 l) {
		em.merge(l);
		return true;
		
	}

	@Override
	public boolean removeLike(int idLike) {
		em.remove(FindLikeById(idLike));	
		return true;

	}

	@Override
	public Like2 FindLikeById(int idLike) {
		return em.find(Like2.class, idLike);
	}

	@Override
	public List<Like2> Findall() {
		return em.createQuery("SELECT l FROM Like2 l",Like2.class).getResultList();
	}
	
	
	
	
	


}
