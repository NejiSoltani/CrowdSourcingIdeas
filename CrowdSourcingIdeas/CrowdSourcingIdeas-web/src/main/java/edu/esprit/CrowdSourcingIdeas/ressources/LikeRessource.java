package edu.esprit.CrowdSourcingIdeas.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.esprit.CrowdSourcingIdeas.persistence.Like2;
import edu.esprit.CrowdSourcingIdeas.persistence.Photo;
import edu.esprit.CrowdSourcingIdeas.services.LikeServiceEJBRemote;


@Path("like")
@RequestScoped
public class LikeRessource {
	
	@EJB
	LikeServiceEJBRemote metier;
	
	@Path("add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addLike(Like2 l){	
		return Response.ok(metier.addLike(l)).build();
}
	
	@Path("remove/{idlike}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeLike(@PathParam(value="idlike")int idLike){	
		return Response.ok(metier.removeLike(idLike)).build();
	}
	
	@Path("listAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response Listall(Photo p){	
		return Response.ok(metier.Findall()).build();
	}
	
}
