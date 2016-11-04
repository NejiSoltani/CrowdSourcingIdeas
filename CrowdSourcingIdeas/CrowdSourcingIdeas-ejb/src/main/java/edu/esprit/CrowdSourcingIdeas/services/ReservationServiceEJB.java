package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.CrowdSourcingIdeas.persistence.Product;
import edu.esprit.CrowdSourcingIdeas.persistence.Reservation;
import edu.esprit.CrowdSourcingIdeas.persistence.Shop;

/**
 * Session Bean implementation class ReservationServiceEJB
 */
@Stateless
@LocalBean
public class ReservationServiceEJB implements ReservationServiceEJBRemote {
	@PersistenceContext(unitName="CrowdSourcingIdeas-ejb")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ReservationServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Reservation> findAll() {
		return em.createQuery("SELECT p FROM Reservation p", Reservation.class).getResultList();
	}

	@Override
	public Reservation findbyid(int id) {
		return em.find(Reservation.class,id);
	}

}
