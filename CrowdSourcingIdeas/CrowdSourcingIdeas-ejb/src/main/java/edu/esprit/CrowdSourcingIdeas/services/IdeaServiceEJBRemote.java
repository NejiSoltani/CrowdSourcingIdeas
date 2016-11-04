package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.Remote;


import edu.esprit.CrowdSourcingIdeas.persistence.Idea;


@Remote
public interface IdeaServiceEJBRemote {
	public void addIdea(Idea a);
	public List<Idea> findAll();
	public void Delete(int id);
	public void Update(Idea i);
	public Idea findIdeaById(int idIdea) ;
	public void UpdateIdeaByIdea(int id);
	public void addLikeToIdea(int numIdea,int idLike);
	public void addIdeaToCustomer(int numIdea,int idCustomer);
	public void DislikeIdea(int numIdea);
	public List<Idea> SearchIdea(String subject);
	public void reportIdea(int idUser, int idIdea);
	
	}


