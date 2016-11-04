package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.CrowdSourcingIdeas.persistence.Category;
import edu.esprit.CrowdSourcingIdeas.persistence.Product;
import edu.esprit.CrowdSourcingIdeas.persistence.Reservation;

/**
 * Session Bean implementation class ProductServiceEJB
 */
@Stateless
@LocalBean
public class ProductServiceEJB implements ProductServiceEJBRemote {
	@PersistenceContext(unitName="CrowdSourcingIdeas-ejb")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ProductServiceEJB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addProduct(Product a) {
		em.persist(a);
		
	}
	
	@Override
	public List<Product> findAllProduct() {
		return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
	}

	@Override
	public Product findById(int id) {
		return em.find(Product.class,id);
	}

	@Override
	public void removeProduct(int id) {
		Product a=findById(id);
		if (a!=null)
		em.remove(em.contains(a)?a: em.merge(a));
		
	}

	@Override
	public void updateProduct(Product a) {
		em.merge(a);
		
	}

	@Override
	public List<Product> findProductsByCategoryID(int id) {
		Category c = em.find(Category.class,id);
		return c.getProducts();
	}

	@Override
	public float RateProduct(float note, int id) {
		Product p = findById(id);
		int nbr=p.getNbrrate();
		float n=p.getScore();
		float finlescore=((n*nbr) + note)/(nbr+1);
		p.setNbrrate(nbr+1);
		p.setScore(finlescore);
		updateProduct(p);
		return finlescore;
		
	}

	

}
