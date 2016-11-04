package edu.esprit.CrowdSourcingIdeas.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import edu.esprit.CrowdSourcingIdeas.persistence.User;

/**
 * Entity implementation class for Entity: MarketingManager
 *
 */
@Entity

public class MarketingManager extends User implements Serializable {

	
	private int idManager;
	@OneToMany(mappedBy="manager")
	private List<Category> categories;
	@OneToMany(mappedBy="manager")
	private List<Comment> comments;
	@OneToMany(mappedBy="manager")
	private List<Photo> photos;
	@OneToMany(mappedBy="manager1")
	private List<Idea> ideas;
	@OneToMany(mappedBy="manager")
	private List<Reclamation> reclamations;
	@OneToMany(mappedBy="manager")
	private List<Customer> customers;
	@OneToMany(mappedBy="manager")
	private List<IdeaReviewer> reviewers;
	private static final long serialVersionUID = 1L;

	public MarketingManager() {
		super();
	}   
	public int getIdManager() {
		return this.idManager;
	}

	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}
   
}
