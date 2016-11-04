package edu.esprit.CrowdSourcingIdeas.services;

import java.util.Collection;

import javax.ejb.Remote;

import edu.esprit.CrowdSourcingIdeas.persistence.Comment;


@Remote
public interface CommentServiceEJBRemote {

	void addComment(Comment c);

	void deleteComment(int idComment);

	void updateComment(Comment c);

	Collection<Comment> findAllComments();

	Comment findCommentbyId(int id);
	
	void addCommentToPhoto(int idComment,int idPhoto);
	
	void addCommentToIdea(int idComment ,int idIdea);
	
	void addCommentToUser(int idComment,int idUser);
	
	void addTagToComment(int idUser ,int idComment);
	
	void reportComment(int idUser ,int idComment);


}
