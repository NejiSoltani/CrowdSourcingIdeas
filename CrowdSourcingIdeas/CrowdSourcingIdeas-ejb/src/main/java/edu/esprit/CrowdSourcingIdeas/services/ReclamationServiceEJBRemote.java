package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.CrowdSourcingIdeas.persistence.Reclamation;


@Remote
public interface ReclamationServiceEJBRemote {
	
	public boolean SendReclamation(Reclamation rec);
	
	public boolean UpdateReclamation( Reclamation rec);
	
	public boolean DeleteReclamation(int idReclamationd);

	public Reclamation GetReclamationById(int idReclamation);
	
	public List<Reclamation> GetAllReclamation();
}
