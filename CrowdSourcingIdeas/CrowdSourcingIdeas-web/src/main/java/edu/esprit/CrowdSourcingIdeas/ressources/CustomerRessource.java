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

import edu.esprit.CrowdSourcingIdeas.persistence.Customer;
import edu.esprit.CrowdSourcingIdeas.services.CustomerServiceRemote;

@Path("customer")
@RequestScoped
public class CustomerRessource {
	@EJB
	CustomerServiceRemote metier;
	
	/*
	public void reportAccount(Customer customer);*/
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inscription(Customer c){
		metier.inscription(c);
		return Response.ok("the customer has been added").build();
	}
	@GET
	@Path("{username}/{pwd}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@PathParam("username") String login,@PathParam("pwd") String password){
		
		return Response.ok(metier.login(login, password)).build();
	}
	@GET
	@Path("findId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findCustomerById(@PathParam("id") int idCustomer){
		//metier.findCustomerById(idCustomer);
		return Response.ok().entity(metier.findCustomerById(idCustomer)).build();
	}
	@PUT
	@Path("{idCustomer}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateAccount(@PathParam("idCustomer")int idCustomer,Customer c){
		metier.updateAccount(idCustomer, c);
		return Response.ok("update success").build();
	}
	@GET
	@Path("{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findCustomerByName(@PathParam("name") String name){
		//metier.findCustomerById(idCustomer);
		return Response.ok().entity(metier.findCustomerByName(name)).build();
	}
	@GET
	@Path("bonus/{c}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response checkBonus(@PathParam("c")int c){
		
		return Response.ok().entity(metier.checkBonus(c)).build();
	}
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAccount(@PathParam("id")int idCustomer){
		metier.deleteAccount(idCustomer);
		return Response.ok("the customer deleted").build();
	}
	@POST
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response reportAccount(@PathParam("id") int idUser,Customer c){
		metier.reportAccount(idUser, c);
		return Response.ok("the report sent succesfuly").build();
	}
	
}
