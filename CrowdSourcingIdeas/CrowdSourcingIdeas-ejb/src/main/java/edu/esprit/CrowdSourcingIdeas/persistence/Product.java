package edu.esprit.CrowdSourcingIdeas.persistence;

import java.io.Serializable;
import java.lang.Float;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity

public class Product implements Serializable {

	   
	@Id
	private int idProduct;
	private String name;
	private Float price;
	private String photo;
	private String description;
	private int nbrrate;
	private float score;
	@ManyToOne 
	private Category category;
	private static final long serialVersionUID = 1L;

	public Product() {
		super();
	}  
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}   
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public float getScore() {
		return this.score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getNbrrate() {
		return nbrrate;
	}

	public void setNbrrate(int nbrrate) {
		this.nbrrate = nbrrate;
	}
	
   
}
