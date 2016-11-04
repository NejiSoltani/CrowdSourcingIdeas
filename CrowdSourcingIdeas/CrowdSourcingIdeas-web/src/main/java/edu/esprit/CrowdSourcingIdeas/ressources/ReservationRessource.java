package edu.esprit.CrowdSourcingIdeas.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.esprit.CrowdSourcingIdeas.services.ReservationServiceEJBRemote;
import edu.esprit.CrowdSourcingIdeas.services.ShopServiceEJBRemote;
@Path("Reservation")
@RequestScoped
public class ReservationRessource {
	@EJB
	ReservationServiceEJBRemote metier;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("all")
	public Response getShops()
	
	{ return Response.ok(metier.findAll()).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{n}")
	public Response getShopbyId(@PathParam(value="n")int id)
	{
		return Response.ok(metier.findbyid(id)).build();
	}

}
