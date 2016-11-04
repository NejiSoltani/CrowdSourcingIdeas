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

import edu.esprit.CrowdSourcingIdeas.persistence.Photo;
import edu.esprit.CrowdSourcingIdeas.services.PhotoServiceEjb;

@Path("photo")
@RequestScoped
public class PhotoRessource {
	
	@EJB
	PhotoServiceEjb metier;
	
	@Path("add")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPhoto(Photo p){	
		return Response.ok(metier.addPhoto(p)).build();
	}
	@Path("Update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdatePhoto(Photo p){	
		return Response.ok(metier.UpdatePhoto(p)).build();
	}
	@Path("remove/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response removePhoto(@PathParam(value="id")int idPhoto){	
		return Response.ok(metier.removePhoto(idPhoto)).build();
	}
	
	@Path("listAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response ListPhoto(Photo p){	
		return Response.ok(metier.ListPhoto()).build();
	}
	
	@Path("listPhotobyID/{idphoto}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response ListPhotobyID(@PathParam(value="idphoto")int idPhoto){	
		return Response.ok(metier.FindPhotoById(idPhoto)).build();
	}
}
