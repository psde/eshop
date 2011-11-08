package eshop.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(
			name = "getUserByUsernameAndPassword",
			query = "from User u where u.username=:username and u.password=:password"
	)
})

@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private boolean admin;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User() {
		/*
		 * This constructor is required for Hibernate.
		 */
	}
	
	public User(long id, String username, String password, boolean admin) {
		/*
		 * Constructor for application and/or testing,
		 */
		this.id = id;
		this.username = username;
		this.password = password;
		this.admin = admin;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
