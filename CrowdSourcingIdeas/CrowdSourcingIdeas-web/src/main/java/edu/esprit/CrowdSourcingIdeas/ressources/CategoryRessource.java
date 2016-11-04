package edu.esprit.CrowdSourcingIdeas.ressources;

import java.util.List;

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

import edu.esprit.CrowdSourcingIdeas.persistence.Product;
import edu.esprit.CrowdSourcingIdeas.persistence.Reservation;
import edu.esprit.CrowdSourcingIdeas.services.CategoryServiceEJBRemote;

@Path("category")
@RequestScoped
public class CategoryRessource {
	@EJB
	CategoryServiceEJBRemote metier;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("all")
	public Response getCategorys()
	{
		return Response.ok(metier.findAllCategorys()).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{n}")
	public Response getCategorybyId(@PathParam(value="n")int id)
	{
		return Response.ok(metier.findById(id)).build();
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{a}")
	public String addProducttoCategory( List<Product> r,@PathParam(value="a") int a )
	{
		metier.AddProductToCategorybyID (r, a);
		return "ok";
	}
}
