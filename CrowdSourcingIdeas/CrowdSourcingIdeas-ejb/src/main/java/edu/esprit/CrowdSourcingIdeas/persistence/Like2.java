package edu.esprit.CrowdSourcingIdeas.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Like2
 *
 */
@Entity

public class Like2 implements Serializable {

	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		private int idLike;
		private Date date;
		@ManyToOne(cascade=CascadeType.ALL)
		private Customer customer;
		@ManyToOne(cascade=CascadeType.ALL)
		private Photo photo;
		@ManyToOne(cascade=CascadeType.ALL)
		private Idea idea;
	private static final long serialVersionUID = 1L;

	public Like2() {
		super();
	}

	public int getIdLike() {
		return idLike;
	}

	public void setIdLike(int idLike) {
		this.idLike = idLike;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}
	
	
   
}
