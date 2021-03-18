
// 	INTERFACE OF PRODUCT SERVICE CLASS

package com.pkart.service;

import java.util.List;

import com.pkart.model.Product;

public interface IProductService {

	public boolean add(Product product);

	public boolean update(Product product);
	
	public boolean remove(long id);
	
	public Product getProduct(long id);
	
	public List<Product> getAllProduct();
	
}
