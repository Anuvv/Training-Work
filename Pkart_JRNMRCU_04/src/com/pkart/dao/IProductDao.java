
//	INTERFACE OF PRODUCT DAO CLASS

package com.pkart.dao;

import java.util.Map;

import com.pkart.model.Product;

public interface IProductDao {
	
	public void addProduct(Product product);

	public boolean updateProduct(Product product);
	
	public boolean removeProduct(long id);
	
	public Product getProduct(long id);
	
	public Map<Long, Product> getAllProduct();
	
}
