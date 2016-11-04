package edu.esprit.CrowdSourcingIdeas.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Prize
 *
 */
@Entity

public class Prize implements Serializable {

	   
	@Id
	private int idPrize;
	private String description;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private IdeaReviewer reviewer;
	private static final long serialVersionUID = 1L;

	public Prize() {
		super();
	}   
	public int getIdPrize() {
		return this.idPrize;
	}

	public void setIdPrize(int idPrize) {
		this.idPrize = idPrize;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
