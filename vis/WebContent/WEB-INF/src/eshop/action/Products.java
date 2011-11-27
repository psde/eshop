package eshop.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import eshop.manager.CategoryManager;
import eshop.manager.ProductManager;
import eshop.pojo.Category;
import eshop.pojo.Product;

public class Products extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map session;
	private List<Product> products;
	private List<Category> categories;
	
	private Product product; /* for detail view */
	
	private Long productId;
	
	/*
	 * CRUD entry point: List products
	 */
	
	public String listProducts() {
		products = ProductManager.getAllProducts();
		return SUCCESS;
	}
	
	/*
	 * CRUD entry point: detail view of a product
	 */
	public String productDetails() {
		product = ProductManager.getProduct(productId);
		return SUCCESS;
	}
	
	public String insertOrUpdateProduct() {
		product = ProductManager.getProduct(productId);
		categories = CategoryManager.getCategories();
		return INPUT;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;	
	}
	
	public Map getSession() {
		return session;
	}
	
	public String execute() throws Exception {
		return SUCCESS;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
