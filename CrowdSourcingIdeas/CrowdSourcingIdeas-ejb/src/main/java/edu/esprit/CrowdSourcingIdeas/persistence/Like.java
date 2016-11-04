package edu.esprit.CrowdSourcingIdeas.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Like
 *
 */
@Entity

public class Like implements Serializable {

	   
	@Id
	private int idLike;
	private Date date;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Photo photo;
	@ManyToOne
	private Idea idea;
	private static final long serialVersionUID = 1L;

	public Like() {
		super();
	}   
	public int getIdLike() {
		return this.idLike;
	}

	public void setIdLike(int idLike) {
		this.idLike = idLike;
	}   
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
   
}
