package eshop.tests;

import static org.junit.Assert.*;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import eshop.pojo.User;
import eshop.hibernate.HibernateUtil;

public class TestUserHibernation {
	@Test
	public void testAddUser() {
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		User user = new User("borfd", "pew", true);
		s.save(user);
		t.commit();
		s.close();
		
		s = HibernateUtil.getSession();
		t = s.beginTransaction();
		List<User> users = s.createQuery("from User").list();
		assertEquals(1, users.size());
		
		user = (User)users.get(0);
		assertEquals("borfd", user.getUsername());
		s.delete(user);
		t.commit();
		s.close();
	}
}