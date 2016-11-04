package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.CrowdSourcingIdeas.persistence.Category;
import edu.esprit.CrowdSourcingIdeas.persistence.Product;
import edu.esprit.CrowdSourcingIdeas.persistence.Shop;

/**
 * Session Bean implementation class CategoryServiceEJB
 */
@Stateless
@LocalBean
public class CategoryServiceEJB implements CategoryServiceEJBRemote {
	@PersistenceContext(unitName="CrowdSourcingIdeas-ejb")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public CategoryServiceEJB() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public Category findById(int id) {
		return em.find(Category.class,id);
	}
    @Override
    public List<Category> findAllCategorys() {
		return em.createQuery("SELECT p FROM Category p", Category.class).getResultList();
	}

	@Override
	public void AddProductToCategory(List<Product> pro, Category c) {
		// TODO Auto-generated method stub
		c.addProductToCategory(pro);
		em.merge(c);
	}
	@Override
	public void AddProductToCategorybyID(List<Product> pro, int id) {
		Category c=findById(id);
		c.addProductToCategory(pro);
		em.merge(c);
	}

}
