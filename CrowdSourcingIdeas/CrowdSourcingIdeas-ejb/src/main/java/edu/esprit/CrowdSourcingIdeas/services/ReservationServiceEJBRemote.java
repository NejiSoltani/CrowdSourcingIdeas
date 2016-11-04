package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.CrowdSourcingIdeas.persistence.Reservation;

@Remote
public interface ReservationServiceEJBRemote {
public List<Reservation> findAll();
public Reservation findbyid(int id);
}
