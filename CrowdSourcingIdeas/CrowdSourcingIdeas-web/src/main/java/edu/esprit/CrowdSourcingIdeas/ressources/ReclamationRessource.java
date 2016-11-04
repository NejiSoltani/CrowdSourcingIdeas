package edu.esprit.CrowdSourcingIdeas.ressources;

import java.util.List;

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
import edu.esprit.CrowdSourcingIdeas.persistence.Reclamation;
import edu.esprit.CrowdSourcingIdeas.services.ReclamationServiceEJBRemote;

	@Path("reclamation")
	@RequestScoped
	public class ReclamationRessource {
	
		@EJB
		ReclamationServiceEJBRemote metier;
		
		@Path("SendReclamation")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		
		public Response SendReclamation(Reclamation rec){	
			return Response.ok(metier.SendReclamation(rec)).build();

	}
		
		@Path("UpdateReclamation")
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public Response UpdateReclamation(Reclamation rec){	
			return Response.ok(metier.UpdateReclamation(rec)).build();
	}
		
		@DELETE
		@Path("DeleteReclamation/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response DeleteReclamation(@PathParam(value="id")int id){	
			return Response.ok(metier.DeleteReclamation(id)).build();
		
	}
		
		@Path("GetReclamationByUser")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response GetReclamationById(int idUser){	
			return Response.ok(metier.GetReclamationById(idUser)).build();
	
	}
		
		@Path("GetAllReclamation")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response GetAllReclamation(){	
			return Response.ok(metier.GetAllReclamation()).build();
		
	}
		
	}
