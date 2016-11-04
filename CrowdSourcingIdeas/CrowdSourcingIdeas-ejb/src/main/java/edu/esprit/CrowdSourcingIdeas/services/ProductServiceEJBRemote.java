package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.CrowdSourcingIdeas.persistence.Product;
import edu.esprit.CrowdSourcingIdeas.persistence.Reservation;

@Remote
public interface ProductServiceEJBRemote {
	/**
	 *add product to database
	 *
	 * @param  a product to add 
	 * @return nothing
	 */	
public void addProduct(Product a);
/**
 *find all Products 
 *
 * @param  no paramaeter
 * @return a list products
 */
public List<Product> findAllProduct();
/**
 *find a product by her id
 *
 * @param  id is the the paramater with we gonna search
 * @return a Product
 */
public Product findById(int id);
/**
 *Remove a product by her id
 *
 * @param  id is the the paramater with we gonna search
 * @return nothing
 */
public void removeProduct(int id);
/**
 *Edit a product in database
 *
 * @param  a product to edit 
 * @return nothing
 */	

public void updateProduct(Product a);
/**
 *find a product by her id of Category
 *
 * @param  id is the the paramater with we gonna search
 * @return a List Product
 */
public List<Product> findProductsByCategoryID(int id);
/**
 *rate
 *
 * @param  note is the the rate with we gonna give
 * @param  id of the product
 * @return a note final
 */
public float RateProduct(float note , int id);

}
