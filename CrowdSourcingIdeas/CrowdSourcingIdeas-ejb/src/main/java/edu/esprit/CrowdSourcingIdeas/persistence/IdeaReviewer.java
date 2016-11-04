package edu.esprit.CrowdSourcingIdeas.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import edu.esprit.CrowdSourcingIdeas.persistence.User;

/**
 * Entity implementation class for Entity: IdeaReviewer
 *
 */
@Entity

public class IdeaReviewer extends User implements Serializable {

	
	private int idReviewer;
	@ManyToOne
	private MarketingManager manager;
	@OneToMany(mappedBy="reviewer")
	private List<Prize> prizes;
	@OneToMany(mappedBy="reviewer")
	private List<Contact> feeds;
	@OneToMany(mappedBy="reviewer")
	private List<Idea> ideas;
	@OneToMany(mappedBy="reviewer")
	private List<Quiz> quizs;
	private static final long serialVersionUID = 1L;

	public IdeaReviewer() {
		super();
	}   
	public int getIdReviewer() {
		return this.idReviewer;
	}

	public void setIdReviewer(int idReviewer) {
		this.idReviewer = idReviewer;
	}
   
}
