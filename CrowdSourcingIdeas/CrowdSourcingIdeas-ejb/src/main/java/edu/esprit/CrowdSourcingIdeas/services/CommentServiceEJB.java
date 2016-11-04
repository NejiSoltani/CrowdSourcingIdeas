package edu.esprit.CrowdSourcingIdeas.services;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.CrowdSourcingIdeas.persistence.Comment;
import edu.esprit.CrowdSourcingIdeas.persistence.Customer;
import edu.esprit.CrowdSourcingIdeas.persistence.Idea;
import edu.esprit.CrowdSourcingIdeas.persistence.Photo;
import edu.esprit.CrowdSourcingIdeas.persistence.Reclamation;

/**
 * Session Bean implementation class ClientServiceEJBRemote
 */
@Stateless
@LocalBean
public class CommentServiceEJB implements CommentServiceEJBRemote {
	@PersistenceContext(unitName = "CrowdSourcingIdeas-ejb")
	EntityManager em;

	public CommentServiceEJB() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addComment(Comment c) {
		em.persist(c);

	}

	@Override
	public void deleteComment(int idComment) {
		// em.remove(em.contains(c) ? c : em.merge(c));
		Comment c = em.find(Comment.class, idComment);

		em.remove(c);

	}

	@Override
	public void updateComment(Comment c) {

		em.merge(c);

	}

	@Override
	public Comment findCommentbyId(int id) {

		return em.find(Comment.class, id);
	}

	@Override
	public Collection<Comment> findAllComments() {

		return em.createQuery("from Comment", Comment.class).getResultList();
	}

	@Override
	public void addCommentToPhoto(int idComment, int idPhoto) {
		Comment c = em.find(Comment.class, idComment);
		Photo p = em.find(Photo.class, idPhoto);
		c.setPhoto(p);

	}

	@Override
	public void addCommentToIdea(int idComment, int idIdea) {
		Comment c = em.find(Comment.class, idComment);
		Idea idea = em.find(Idea.class, idIdea);
		c.setIdea(idea);

	}

	@Override
	public void addCommentToUser(int idComment, int idUser) {
		Comment c = em.find(Comment.class, idComment);
		Customer customer = em.find(Customer.class, idUser);
		c.setCustomer(customer);
	}

	@Override
	public void addTagToComment(int idUser, int idComment) {

	}

	@Override
	public void reportComment(int idUser, int idComment) {
		Reclamation r = new Reclamation();
		Customer c1 = em.find(Customer.class, idUser);
		r.setSubject("Report Comment id:" + idComment+" by "+c1.getFirstName());
		r.setCustomer(c1);
		r.setType("Comment");
		em.persist(r);

	}
}
