package edu.esprit.CrowdSourcingIdeas.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.esprit.CrowdSourcingIdeas.persistence.Contact;

import edu.esprit.CrowdSourcingIdeas.services.ContactServiceEJBRemote;

@RequestScoped
@Path("Contact")
public class ContactRessource {
	@EJB 
	ContactServiceEJBRemote metier; 	

	@POST
	@Path("feedback")
	@Consumes(MediaType.APPLICATION_JSON) 
	public Response addFeedBack(Contact f){ 
		metier.addFeedBack(f);
		return Response.ok().build(); 
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) 
	public Response addContact(Contact f){ 
		metier.addContact(f);
		return Response.ok().build(); 
	}
	@PUT
	@Path("{idContact}/{idUser}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUserToContact(@PathParam("idUser")int idUser,@PathParam("idContact")int idContact) {
		
		metier.addUserToContact(idUser,idContact );
		return Response.ok().build(); 

	}
	
}
