package edu.esprit.CrowdSourcingIdeas.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.esprit.CrowdSourcingIdeas.persistence.Comment;
import edu.esprit.CrowdSourcingIdeas.services.CommentServiceEJBRemote;

@RequestScoped
@Path("Comment")
public class CommentRessource {
	@EJB 
	CommentServiceEJBRemote metier; 	

	@GET 
	@Produces(MediaType.APPLICATION_JSON) 
	public Response getAllComments(){ 
		return Response.ok(metier.findAllComments()).build(); 
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON) 
	public Response addComment(Comment c){ 
		metier.addComment(c);
			return Response.ok().build(); 
	}
	
	@DELETE
	@Path("{idComment}")
	public Response deleteComment(@PathParam("idComment") int idComment) {
		
		metier.deleteComment(idComment);
		return Response.ok().build(); 

	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateComment(Comment c) {
		
		metier.updateComment(c);
		return Response.ok().build(); 

	}
	

	
	@GET 
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response findCommentbyId(@PathParam("id")int id){ 
		return Response.ok(metier.findCommentbyId(id)).build(); 
	}
	
	@PUT
	@Path("photo/{idComment}/{idPhoto}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCommentToPhoto(@PathParam("idPhoto")int idPhoto,@PathParam("idComment")int idComment) {
		
		metier.addCommentToPhoto(idComment, idPhoto);
		return Response.ok().build(); 

	}
	@PUT
	@Path("idea/{idComment}/{idIdea}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCommentToIdea(@PathParam("idIdea")int idIdea,@PathParam("idComment")int idComment) {
		
		metier.addCommentToIdea(idComment, idIdea);
		return Response.ok().build(); 

	}
	@PUT
	@Path("user/{idComment}/{idUser}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCommentToUser(@PathParam("idUser")int idUser,@PathParam("idComment")int idComment) {
		
		metier.addCommentToUser(idComment, idUser);
		return Response.ok().build(); 

	}
	
	@PUT
	@Path("report/{idComment}/{idUser}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response reportComment(@PathParam("idUser")int idUser,@PathParam("idComment")int idComment) {
		
		metier.reportComment(idUser,idComment );
		return Response.ok().build(); 

	}
	

	

}
