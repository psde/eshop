package eshop.tests;

import static org.junit.Assert.*;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.junit.Test;

import eshop.hibernate.HibernateUtil;
import eshop.pojo.Category;

public class TestManyToOneRelation {

	@Test
	public void test() {
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		Category c = new Category();
		c.setName("ASD");
		s.save(c);
		
		Product p = new Product();
		t.commit();
	}

}
