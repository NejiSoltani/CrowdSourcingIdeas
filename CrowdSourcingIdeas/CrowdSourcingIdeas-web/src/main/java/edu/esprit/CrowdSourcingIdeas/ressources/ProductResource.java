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

import edu.esprit.CrowdSourcingIdeas.persistence.Product;
import edu.esprit.CrowdSourcingIdeas.persistence.Reservation;
import edu.esprit.CrowdSourcingIdeas.services.ProductServiceEJBRemote;

@Path("products")
@RequestScoped
public class ProductResource {
	@EJB
	ProductServiceEJBRemote metier;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("all")
	public Response getProduct()
	{
		return Response.ok(metier.findAllProduct()).build();
	}
		
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{n}")
	public Response getProductbyId(@PathParam(value="n")int id)
	{
		return Response.ok(metier.findById(id)).build();
	}
	
	@DELETE
	@Path("{n}")
	public String removeProduct(@PathParam(value="n")int id)
	{
		
				metier.removeProduct(id);
				return "ok";
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String addProduct(Product a)
	{
		
				metier.addProduct(a);
				return "ok";
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	
	public String updateProduct(Product a)
	{
		
				metier.updateProduct(a);
				return "ok";
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("findbyc/{n}")
	public Response getProductbyCategory(@PathParam(value="n")int id)
	{
		return Response.ok(metier.findProductsByCategoryID(id)).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{a}/{n}")
	public float rateProduct(@PathParam(value="a") float a, @PathParam(value="n")int id)
	{
		return metier.RateProduct(a, id);
	}
	

}
