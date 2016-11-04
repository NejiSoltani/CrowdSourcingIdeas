package edu.esprit.CrowdSourcingIdeas.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.esprit.CrowdSourcingIdeas.services.QuizServiceEJBRemote;

@Path("quizs")
@RequestScoped
public class QuizRessource {
	@EJB
	QuizServiceEJBRemote metier;

	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response AfficherMeilleuresScore()
	{
		return Response.ok(metier.classementQuiz()).build();
	}
	
	
	

}
