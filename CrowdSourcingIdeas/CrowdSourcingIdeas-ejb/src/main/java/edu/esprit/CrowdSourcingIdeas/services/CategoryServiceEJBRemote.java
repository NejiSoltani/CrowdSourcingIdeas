package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.CrowdSourcingIdeas.persistence.Category;
import edu.esprit.CrowdSourcingIdeas.persistence.Product;
import edu.esprit.CrowdSourcingIdeas.persistence.Shop;

@Remote
public interface CategoryServiceEJBRemote {
	/**
	 *find a category by her id
	 *
	 * @param  id is the the paramater with we gonna search
	 * @return a Category
	 */
	public Category findById(int id);
	/**
	 *find all categorys 
	 *
	 * @param  no paramaeter
	 * @return a list Category
	 */
public List<Category> findAllCategorys();
/**
 *add product to category 
 *
 * @param  List of product to add
 * @param  the category to add to it 
 * @return nothing
 */
public void AddProductToCategory(List<Product> pro,Category c);
/**
 *add product to category by id 
 *find the category by id and then add the list to it
 *
 * @param  List of product to add
 * @param  the id of the category 
 * @return nothing
 */
public void AddProductToCategorybyID(List<Product> pro,int id) ;
}
