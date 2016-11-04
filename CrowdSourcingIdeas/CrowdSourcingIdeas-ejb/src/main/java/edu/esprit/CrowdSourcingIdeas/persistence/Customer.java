package edu.esprit.CrowdSourcingIdeas.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import edu.esprit.CrowdSourcingIdeas.persistence.User;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity

public class Customer extends User implements Serializable {

	   
	private int score;
	@OneToMany(mappedBy="customer")
	private List<Reclamation> reclamations;
	@ManyToMany(mappedBy="customers")
	private List<Category> categories;
	@OneToMany(mappedBy="customer")
	private List<Comment> comments;
	@OneToMany(mappedBy="customer")
	private List<Reservation> reservations;
	@OneToMany(mappedBy="customer")
	private List<Photo> photos;
	@OneToMany(mappedBy="customer")
	private List<Quiz> quiz;
	@OneToMany(mappedBy="customer")
	private List<Like> likes;
	@OneToMany(mappedBy="customer")
	private List<Idea> ideas;
	@OneToMany(mappedBy="customer")
	private List<Contact> feedBacks;
	@OneToMany(mappedBy="customer")
	private List<Prize> prizes;
	@ManyToOne
	private MarketingManager manager;
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}   
  
	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

   
}
