package edu.esprit.CrowdSourcingIdeas.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: Idea
 *
 */
@Entity

public class Idea implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIdea;
	private String subject;
	private String content;
	private String statut;
	private Date dateDepot;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private MarketingManager manager1;
	@ManyToOne
	private IdeaReviewer reviewer;
	@OneToMany(mappedBy="idea")
	private List<Comment> comments;
	@OneToMany(mappedBy="idea",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Like2> likes;
	private static final long serialVersionUID = 1L;

	public Idea() {
		super();
	}   
	public int getIdIdea() {
		return this.idIdea;
	}

	public void setIdIdea(int idIdea) {
		this.idIdea = idIdea;
	}   
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}   
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}   
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}   
	public Date getDate() {
		return this.dateDepot;
	}

	public void setDate(Date date) {
		this.dateDepot = date;
	}
	
	public List<Like2> getLikes() {
		return likes;
	}
	public void setLikes(List<Like2> likes) {
		this.likes = likes;
	}
	public void affectClientToCompte(List<Like2> lLikes)
	{
			for(Like2 compte:lLikes)
			{
				compte.setIdea(this);
			}
			this.setLikes(lLikes);
			
	}
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Idea [idIdea=" + idIdea + ", subject=" + subject + ", content=" + content + ", statut=" + statut
				+ ", dateDepot=" + dateDepot + ", customer=" + customer + ", manager=" + manager1 + ", reviewer="
				+ reviewer + ", comments=" + comments + ", likes=" + likes + "]";
	}
	
	
	
   
}
