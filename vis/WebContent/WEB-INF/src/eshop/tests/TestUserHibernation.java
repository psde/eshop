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
		Transaction t = null;
		try {
			t = s.beginTransaction();
			User user = new User("borfd", "pew", true);
			s.save(user);
			t.commit();
		} catch(RuntimeException ex) {
			t.rollback();
			throw ex;
		} finally {
			s.close();
		}
		
		s = HibernateUtil.getSession();
		try {
			t = s.beginTransaction();
			List<User> users = s.createQuery("from User").list();			
			User user2 = (User)users.get(users.size()-1);
			assertEquals("borfd", user2.getUsername());
			s.delete(user2);
			t.commit();
		} catch(RuntimeException ex) {
			t.rollback();
			throw ex;
		} finally {
			s.close();
		}
	}
}