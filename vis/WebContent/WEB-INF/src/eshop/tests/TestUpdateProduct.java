package eshop.tests;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.junit.Test;
import org.slf4j.Logger;

import eshop.hibernate.HibernateUtil;
import eshop.manager.ProductManager;
import eshop.pojo.Category;
import eshop.pojo.Product;

public class TestUpdateProduct {
	private String categoryName="test Category @##";
	private String productName="test Product hakjsdasd";
	@Test
	public void testUpdate() {
		Log log = LogFactory.getLog(TestUpdateProduct.class);
		
		Long productId = null;
		Integer categoryId = null;
		
		Session s = HibernateUtil.getSession();
		Transaction t = null;
		
		try {
			t = s.beginTransaction();
			Category c = new Category(categoryName);
			s.save(c);
			categoryId = c.getId();
			
			Product p = new Product(productName, 666, c);
			s.save(p);
			t.commit();
			
			productId = p.getId();
			p.setCost(777);
			s.close();
			
			ProductManager.updateProduct(p);
			
			s = HibernateUtil.getSession();
			t = s.beginTransaction();
			Product p2 = (Product)s.load(Product.class, productId);
			
			assertTrue(p2.getCost() == 777);
			
			Category c2 = (Category)s.load(Category.class, categoryId);
			
			s.delete(p2);
			s.delete(c2);
			t.commit();
		
		} catch (RuntimeException ex) {
			log.error(ex.getLocalizedMessage());
			t.rollback();
		} finally {
//			Query q = s.createQuery("delete from Product where name=?").setString(0, productName);
//			q.executeUpdate();
//			q = s.createQuery("delete from Category where name=?").setString(0, categoryName);
//			q.executeUpdate();
			s.close();
		}
		
		
	}
}