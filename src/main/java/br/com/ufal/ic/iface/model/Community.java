package br.com.ufal.ic.iface.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Community {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String name;
	
	@OneToOne
	private User admin;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
	List<User> members = new ArrayList();
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	List<Postage> posts = new ArrayList();
	
	public Community() {
		
	}
	
	public Community(String name, User admin, ArrayList<User> members, ArrayList<Postage> posts) {
		this.name = name;
		this.admin = admin;
		this.members = members;
		this.posts = posts;
	}
	
	public String getName() {
		return this.name;
	}
	
	public User getAdmin() {
		return this.admin;
	}
	
	public List<User> getMembers() {
		return this.members;
	}

	public void setMembers(List<User> members) {
		for(User u : members){
			this.members.add(u);
		}
	}

	public List<Postage> getPosts() {
		return this.posts;
	}
	
	public void setPosts(List<Postage> posts) {
		for(Postage p : posts){
			this.posts.add(p);
		}
	}

}

