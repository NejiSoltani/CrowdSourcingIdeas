package edu.esprit.CrowdSourcingIdeas.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Shop
 *
 */
@Entity

public class Shop implements Serializable {

	   
	@Id
	private int idShop;
	private String name;
	private String address;
	private String photo;
	private String lat;
	private String lng;
	private int phone;
	private float score;
	@ManyToOne
	private Category category;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="shop", fetch = FetchType.EAGER)
	private List<Reservation> reservations=new ArrayList<Reservation>();
	private static final long serialVersionUID = 1L;
	
	
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Shop() {
		super();
	}   
	public int getIdShop() {
		return this.idShop;
	}

	public void setIdShop(int idShop) {
		this.idShop = idShop;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}   
	public String getLat() {
		return this.lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}   
	public String getLng() {
		return this.lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}   
	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}   
	public float getScore() {
		return this.score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public void ajouterR(Reservation res){
		
			res.setShop(this);
			this.getReservations().add(res);
		
	}
   
}
