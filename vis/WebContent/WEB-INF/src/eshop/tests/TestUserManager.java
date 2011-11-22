package eshop.tests;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import eshop.hibernate.HibernateUtil;
import eshop.manager.UserManager;
import eshop.pojo.User;

public class TestUserManager {

	@Test
	public void testNotExisting() {
		assertFalse(UserManager.authenticate("asdasdasdasd123123", "*@)(#UJLKDNSJA"));
	}
	
	@Test
	public void testExisting() {
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		User user = new User("borfd", "pew", true);
		
		s.save(user);
		t.commit();
		s.flush();
		s.close();
		
		assertTrue(UserManager.authenticate("borfd", "pew"));
		
		s = HibernateUtil.getSession();
		t = s.beginTransaction();
		s.delete(user);
		t.commit();
		s.flush();
		s.close();
	}
	
	@Test
	public void testExistingWithFalsePassword() {
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		User user = new User("borfd", "pew", true);
		
		s.save(user);
		t.commit();
		s.flush();
		s.close();
		
		assertFalse(UserManager.authenticate("borfd", "obviously another password"));
		
		s = HibernateUtil.getSession();
		t = s.beginTransaction();
		s.delete(user);
		t.commit();
		s.flush();
		s.close();
	}
	
	@Test 
	public void testAddUser() {
		UserManager.addUser("brat", "b");
		assertTrue(UserManager.authenticate("brat", "b"));
		UserManager.deleteUser("brat", "b");
	}

}
