package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.CrowdSourcingIdeas.persistence.Customer;
import edu.esprit.CrowdSourcingIdeas.persistence.Reservation;
import edu.esprit.CrowdSourcingIdeas.persistence.Shop;

/**
 * Session Bean implementation class ShopServiceEJB
 */
@Stateless
@LocalBean
public class ShopServiceEJB implements ShopServiceEJBRemote {
	@PersistenceContext(unitName="CrowdSourcingIdeas-ejb")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ShopServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addShop(Shop a) {
		em.persist(a);
		
	}

	@Override
	public List<Shop> findAllShop() {
		return em.createQuery("SELECT p FROM Shop p", Shop.class).getResultList();
	}

	@Override
	public Shop findById(int id) {
		return em.find(Shop.class,id);
	}

	@Override
	public void removeShop(int id) {
		Shop a=findById(id);
		em.remove(em.contains(a)?a: em.merge(a));
		
	}

	@Override
	public void updateShop(Shop a) {
		em.merge(a);
		
	}

	@Override
	public void addReserToShop(Reservation res, Shop a) {
		a.ajouterR(res);
		em.merge(a);
		
	}

	@Override
	public void addReserToShopbyid(Reservation res, int id,int idc) {
		
		Customer c=	 em.find(Customer.class,idc);
		
		res.setCustomer(c);
		Shop a=findById(id);
		a.ajouterR(res);
		em.merge(a);
	}

}
