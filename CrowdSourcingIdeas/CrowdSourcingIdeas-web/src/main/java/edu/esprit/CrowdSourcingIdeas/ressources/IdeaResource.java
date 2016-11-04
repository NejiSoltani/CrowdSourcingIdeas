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

import edu.esprit.CrowdSourcingIdeas.persistence.Idea;
import edu.esprit.CrowdSourcingIdeas.services.IdeaServiceEJBRemote;

@Path("ideas")
@RequestScoped
public class IdeaResource {
@EJB
IdeaServiceEJBRemote metier;


@POST
@Consumes(MediaType.APPLICATION_JSON)
public String AddIdea(Idea a)
{
	
	//return Reponse.status(status.CREATED).build();
	//return Response.status(Status.NOT_FOUND).build();
	
	
	metier.addIdea(a);
	return "ok";
}

@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getIdeas()
{
	return Response.ok(metier.findAll()).build();
}







@DELETE
@Path("{idIdea}")
public Response getIdeas(@PathParam("idIdea") int idIdea)
{
    metier.Delete(idIdea);
	
	return Response.ok().build();
}



@DELETE
@Path("{a}/{idIdea}")
public Response DislikeIdea(@PathParam("idIdea") int idIdea)
{
    metier.DislikeIdea(idIdea);
	
	return Response.ok().build();
}





@PUT
@Consumes(MediaType.APPLICATION_JSON)
public String updateIdea(Idea a)
{
	        
			metier.Update(a);
			return "ok";
}


@GET
@Path("{subject}")
@Produces(MediaType.APPLICATION_JSON)
public Response searchIdeas(@PathParam("subject") String subject)
{
	return Response.ok(metier.SearchIdea(subject)).build();
}




@PUT
@Path("{idIdea}/{idLike}")
@Consumes(MediaType.APPLICATION_JSON)
public Response setPhotoToComment(@PathParam("idLike")int idLike,@PathParam("idIdea")int idIdea) {
	
	metier.addLikeToIdea(idIdea,idLike);
	return Response.ok().build(); 
}



@PUT
@Path("{addIdeaToCustomer}/{idIdea}/{idCustomer}")
@Consumes(MediaType.APPLICATION_JSON)
public Response addIdeaToCustomer(@PathParam("idCustomer")int idCustomer,@PathParam("idIdea")int idIdea) {
	
	metier.addIdeaToCustomer(idIdea, idCustomer);
	return Response.ok().build(); 
}





@PUT
@Path("{reportIdea}/{idUser}/{idIdea}")
@Consumes(MediaType.APPLICATION_JSON)
public Response reportIdea(@PathParam("idUser")int idUser,@PathParam("idIdea")int idIdea)
{
	
	//return Reponse.status(status.CREATED).build();
	//return Response.status(Status.NOT_FOUND).build();
	
	
	metier.reportIdea(idUser, idIdea);
	return Response.ok().build();
}






}
