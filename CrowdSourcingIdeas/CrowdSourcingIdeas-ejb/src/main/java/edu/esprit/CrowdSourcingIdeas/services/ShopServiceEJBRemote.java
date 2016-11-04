package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.CrowdSourcingIdeas.persistence.Reservation;
import edu.esprit.CrowdSourcingIdeas.persistence.Shop;

@Remote
public interface ShopServiceEJBRemote {
	/**
	 *add Shop to database
	 *
	 * @param  a Shop to add 
	 * @return nothing
	 */	
	public void addShop(Shop a);
	/**
	 *find all Shops 
	 *
	 * @param  no paramaeter
	 * @return a list Shops
	 */
	public List<Shop> findAllShop();
	/**
	 *find a Shop by her id
	 *
	 * @param  id is the the paramater with we gonna search
	 * @return a Shop
	 */
	public Shop findById(int id);
	/**
	 *Remove a Shop by her id
	 *
	 * @param  id is the the paramater with we gonna search
	 * @return nothing
	 */
	public void removeShop(int id);
	/**
	 *Edit a shop in database
	 *
	 * @param  a shop to edit 
	 * @return nothing
	 */	
	public void updateShop(Shop a);
	/**
	 *add reservation to shop
	 *
	 * @param  List of reservation to add
	 * @param  the shop to add to it 
	 * @return nothing
	 */
	public void addReserToShop(Reservation res,Shop a);
	/**
	 *add resevation to shop by id 
	 *find the shop by id and then add the list to it
	 *
	 * @param  List of reservaton to add
	 * @param  the id of the shop 
	 * @return nothing
	 */
	public void addReserToShopbyid(Reservation res, int id,int idc);
}
