package edu.esprit.CrowdSourcingIdeas.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Photo
 *
 */
@Entity

public class Photo implements Serializable {

	   
	@Id
	private int idPhoto;
	private String Picture;
	private String description;
	private Date date;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private MarketingManager manager;
	@OneToMany(mappedBy="photo")
	private List<Comment> comments;
	@OneToMany(mappedBy="photo")
	private List<Like> likes;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	private static final long serialVersionUID = 1L;

	public Photo() {
		super();
	}   
	public int getIdPhoto() {
		return this.idPhoto;
	}

	public void setIdPhoto(int idPhoto) {
		this.idPhoto = idPhoto;
	}   
	public String getPicture() {
		return this.Picture;
	}

	public void setPicture(String Picture) {
		this.Picture = Picture;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
   
}
