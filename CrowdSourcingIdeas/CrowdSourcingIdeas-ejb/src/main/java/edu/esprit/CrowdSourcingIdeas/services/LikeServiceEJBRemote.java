package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.CrowdSourcingIdeas.persistence.Like2;

@Remote
public interface LikeServiceEJBRemote {
public void AddLike(Like2 l);

public boolean  addLike(Like2 l);
public boolean 	removeLike(int idLike);

public Like2 FindLikeById(int idLike);

public List<Like2>  Findall();
}
