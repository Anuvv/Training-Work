
//	SERVICE LAYER OF PRODUCT

package com.pkart.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.pkart.dao.IProductDao;
import com.pkart.dao.ProductDaoImpl;
import com.pkart.exception.NoSuchProductException;
import com.pkart.model.Product;

public class ProductServiceImpl implements IProductService {

	private static IProductDao productDao;
	
	public ProductServiceImpl()
	{
		if(null == productDao)
			productDao = new ProductDaoImpl();
	}
	
	// This method gives the product to Dao layer to be added and check whether it is added or not
	@Override
	public boolean add(Product product) {
		
		productDao.addProduct(product);
		Product savedProduct = productDao.getProduct(product.getId());
		if(savedProduct != null)
			return true;
		else
			return false;
	}

	// This method updates the existing product
	@Override
	public boolean update(Product product) {
		
		Product updatedProduct = productDao.getProduct(product.getId());
		
		try
		{
			if(updatedProduct != null)
			{
				productDao.updateProduct(product);
				return true;
			}
			else
				throw new NoSuchProductException("NO PRODUCT FOUND");	
		}
		catch(NoSuchProductException e)
		{
			System.out.println(e);
			return false;
		}
		
	}

	// This method gives id of product which is to be removed to Dao layer 
	@Override
	public boolean remove(long id) {
		return productDao.removeProduct(id);
	}

	// This method gets products specified by user from Dao layer
	@Override
	public Product getProduct(long id) {
		return productDao.getProduct(id);
	}

	// This method gets all products from the Dao layer
	@Override
	public List<Product> getAllProduct() {
		
		Map<Long, Product> allProducts=productDao.getAllProduct();
		List<Product> product=new ArrayList<Product>();
		Iterator<Long> itr=allProducts.keySet().iterator();
		
		while(itr.hasNext())
		{
			long key=(long)itr.next();
			product.add(allProducts.get(key));
		}
		return product;
	}

}
