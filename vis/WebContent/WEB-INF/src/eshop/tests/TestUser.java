package eshop.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import eshop.pojo.User;

public class TestUser {
	
	private User user;
	
	public void setUp() {
		this.user = new User("borfd", "123", true);
	}
	
	@Test
	public void testUserGetId() {
		assert(user.getId() == 42);
	}
	
	@Test
	public void testUserGetUsername() {
		assert(user.getUsername() == "borfd");
	}
	
	@Test
	public void testGetPassword() {
		assert(user.getPassword() == "123");
	}
	
	@Test
	public void testIsAdmin() {
		assert(user.isAdmin() == true);
	}

}
