package edu.esprit.CrowdSourcingIdeas.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.esprit.CrowdSourcingIdeas.services.NotificationServiceEJBRemote;

@RequestScoped
@Path("Notification")
public class NotificationRessource {
	@EJB 
	NotificationServiceEJBRemote metier; 	
	@GET 
	@Path("{idUser}")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response getAllCommentsbyId(@PathParam("idUser") int idUser){ 
		return Response.ok(metier.findAllNotificationsById(idUser)).build(); 
	}
	@PUT
	@Path("{idNotification}/{idUser}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUserToNotification(@PathParam("idUser")int idUser,@PathParam("idNotification")int idNotification) {
		
		metier.addUserToNotification(idUser,idNotification );
		return Response.ok().build(); 

	}

}
