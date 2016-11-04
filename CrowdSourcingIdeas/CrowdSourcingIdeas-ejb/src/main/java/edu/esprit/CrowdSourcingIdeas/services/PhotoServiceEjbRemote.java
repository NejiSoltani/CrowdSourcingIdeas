package edu.esprit.CrowdSourcingIdeas.services;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.CrowdSourcingIdeas.persistence.Photo;

@Remote
public interface PhotoServiceEjbRemote {
	
	public boolean  addPhoto(Photo p);
	public boolean removePhoto(int idPhoto);
	public boolean UpdatePhoto(Photo p);
	public List<Photo> ListPhoto();
	public List<Photo> ListPhotouser(int customer_idUser);
	public Photo FindPhotoById(int idPhoto);

}
