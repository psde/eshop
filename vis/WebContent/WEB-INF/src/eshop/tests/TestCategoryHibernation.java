package eshop.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.junit.Test;

import eshop.hibernate.HibernateUtil;
import eshop.pojo.Category;
import eshop.pojo.User;

public class TestCategoryHibernation {

	@Test
	public void test() {
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		Category c = new Category();
		c.setName("ASD");
		s.save(c);
		t.commit();
		s.close();
		
		s = HibernateUtil.getSession();
		t = s.beginTransaction();
		List categories = s.createQuery("from Category").list();
		assertEquals(1, categories.size());
		
		c = (Category)categories.get(0);
		assertEquals("ASD", c.getName());
		s.delete(c);
		t.commit();
		s.close();
	}

}
