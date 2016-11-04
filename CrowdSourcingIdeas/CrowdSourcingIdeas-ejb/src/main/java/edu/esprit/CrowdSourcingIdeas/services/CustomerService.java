package edu.esprit.CrowdSourcingIdeas.services;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.CrowdSourcingIdeas.persistence.Customer;
import edu.esprit.CrowdSourcingIdeas.persistence.Reclamation;
import edu.esprit.CrowdSourcingIdeas.persistence.User;


/**
 * Session Bean implementation class CustomerService
 */
@Stateful
@LocalBean
public class CustomerService implements CustomerServiceRemote {
	@PersistenceContext(unitName="CrowdSourcingIdeas-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public CustomerService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void inscription(Customer c) {
		// TODO Auto-generated method stub
		
			em.persist(c);
			System.out.println("ok");
		
	}

	@Override
	public Customer login(String login, String password) {
		// TODO Auto-generated method stub
		Customer customer = em.createQuery("FROM Customer WHERE login = ? AND password = ?",Customer.class).setParameter(1,login).setParameter(2, password).getSingleResult();
		if (customer.equals(null)) {
			System.out.println("please verify ");
		}
		else{
			System.out.println("You are connected mr "+customer.getLogin());
			return customer;
		}
		return null;
	}

	@Override
	public void updateAccount(int idCustomer,Customer c) {
		// TODO Auto-generated method stub
		Customer customer = findCustomerById(idCustomer);
		customer.setFirstName(c.getFirstName());
		customer.setLastName(c.getLastName());
		customer.setLogin(c.getLogin());
		customer.setEmail(c.getEmail());
		customer.setTel(c.getTel());
		em.merge(customer);
		
	}

	@Override
	public Customer findCustomerById(int idCustomer) {
		// TODO Auto-generated method stub
		return em.find(Customer.class, idCustomer);
	}

	@Override
	public Customer findCustomerByName(String name) {
		// TODO Auto-generated method stub
		Customer c= em.createQuery("FROM Customer WHERE firstName like ?",Customer.class).setParameter(1, "%"+name+"%").getSingleResult();
		if(!c.equals(null))
			return c;
		return null;
	}

	@Override
	public int checkBonus(int c) {
		// TODO Auto-generated method stub
		Customer customer = findCustomerById(c);
		return customer.getScore();

	}

	@Override
	public void deleteAccount(int idCustomer) {
		// TODO Auto-generated method stub
		Customer customer = findCustomerById(idCustomer);
		em.remove(customer);
		
		
	}

	@Override
	public void reportAccount(int idUser, Customer c) {
		// TODO Auto-generated method stub
		Reclamation r = new Reclamation();
		Customer user = em.find(Customer.class, idUser);
		r.setDateReclamation(new Date());
		r.setCustomer(c);
		r.setSubject("Report Customer id:"+idUser+",name="+user.getFirstName()+" "+user.getLastName());
		r.setType("Customer");
		em.persist(r);
	}
	@Override
	public void hello() {
		System.out.println("Hello chiheb");
		
	}

}
