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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.esprit.CrowdSourcingIdeas.persistence.Reservation;
import edu.esprit.CrowdSourcingIdeas.persistence.Shop;
import edu.esprit.CrowdSourcingIdeas.services.ShopServiceEJBRemote;

@Path("Shops")
@RequestScoped
public class ShopResource {
	@EJB
	ShopServiceEJBRemote metier;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("all")
	public Response getShops()
	
	{ return Response.ok(metier.findAllShop()).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("find/{n}")
	public Response getShopbyId(@PathParam(value="n")int id)
	{
		return Response.ok(metier.findById(id)).build();
	}
	@DELETE
	@Path("{n}")
	public String removeShop(@PathParam(value="n")int id)
	{
		
				metier.removeShop(id);
				return "ok";
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String addShop(Shop a)
	{
		
				metier.addShop(a);
				return "ok";
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String updateShop(Shop a)
	{
		
				metier.updateShop(a);
				return "ok";
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("add/{a}/{b}")
	public String addReservationtoShop(  Reservation r,@PathParam(value="a") int a ,@PathParam(value="b") int b)
	{
		metier.addReserToShopbyid (r, a,b);
		return "ok";
	}

}
