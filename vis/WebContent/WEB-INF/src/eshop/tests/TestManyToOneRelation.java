package eshop.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.junit.Test;

import eshop.hibernate.HibernateUtil;
import eshop.pojo.Category;
import eshop.pojo.Product;

public class TestManyToOneRelation {

	@Test
	public void test() {
		Session s = HibernateUtil.getSession();
		Transaction t = s.beginTransaction();
		
		Category c = new Category();
		c.setName("ASD");
		s.save(c);
		
		Product p = new Product("Picka", 1500, c);
		s.save(p);
		
		//since we have a bidirectional relationship we need to set it on the category side as well
		//to ensure consistency 
		c.getProducts().add(p);
		s.save(c);
		t.commit();
		s.flush();
		s.close();
		
		s = HibernateUtil.getSession();
		t = s.beginTransaction();
		
		List categories = s.createQuery("from Category").list();
		c = (Category)categories.get(0);
		List products = s.createQuery("from Product").list();
		p = (Product)products.get(0);
		
		assertFalse(c.getProducts().isEmpty());
		assertEquals(p.getCategory().getName(), "ASD");
		
		s = HibernateUtil.getSession();
		t = s.beginTransaction();
		s.createQuery("delete from Product").executeUpdate();
		s.createQuery("delete from Category").executeUpdate();		
		t.commit();
		s.close();
	}

}
