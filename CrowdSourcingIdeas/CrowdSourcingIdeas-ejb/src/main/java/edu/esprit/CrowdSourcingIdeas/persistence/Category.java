package edu.esprit.CrowdSourcingIdeas.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	   
	@Id
	private int idCategory;
	private String name;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Customer> customers;
	@ManyToOne(cascade=CascadeType.ALL)
	private MarketingManager manager;
	@OneToMany(mappedBy="category" )
	private List<Shop> shops;
	
	
	
	@OneToMany(mappedBy="category",fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Product> products;
	
	
	
	
	private static final long serialVersionUID = 1L;

	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Category() {
		super();
	}   
	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void addProductToCategory(List<Product> pro){
		for(Product r:pro){
			r.setCategory(this);
			this.getProducts().add(r);
		}
	}

}
