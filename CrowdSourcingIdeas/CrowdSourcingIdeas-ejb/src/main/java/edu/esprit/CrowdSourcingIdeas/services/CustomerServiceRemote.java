package edu.esprit.CrowdSourcingIdeas.services;

import javax.ejb.Remote;

import edu.esprit.CrowdSourcingIdeas.persistence.Customer;
import edu.esprit.CrowdSourcingIdeas.persistence.User;

@Remote
public interface CustomerServiceRemote {
	public void inscription(Customer c);
	public Customer login(String login,String password);
	public void updateAccount(int idCustomer,Customer c);
	public Customer findCustomerById(int idCustomer);
	public Customer findCustomerByName(String name);
	public int checkBonus(int c);
	public void deleteAccount(int idCustomer);
	public void reportAccount(int idUser,Customer c);
	public void hello();
	
	
}
