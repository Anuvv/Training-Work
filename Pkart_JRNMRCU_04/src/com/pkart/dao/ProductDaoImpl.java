
//  DAO LAYER OF PRODUCT

package com.pkart.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.pkart.exception.EmptyProductListException;
import com.pkart.exception.NoSuchProductException;
import com.pkart.model.Product;

public class ProductDaoImpl implements IProductDao{

	private static Map<Long, Product> products;	
	static
	{
		products = new HashMap<Long, Product>();

		try {
			products.put((long)1, new Product((long)1, "TV", 50000, 58, new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2019"), new SimpleDateFormat("dd/MM/yyyy").parse("15/12/2040")));
			products.put((long)2, new Product((long)2, "Laptop", 65000, 47, new SimpleDateFormat("dd/MM/yyyy").parse("02/10/2018"), new SimpleDateFormat("dd/MM/yyyy").parse("17/06/2027")));
			products.put((long)3, new Product((long)3, "Mobile", 22000, 1101, new SimpleDateFormat("dd/MM/yyyy").parse("22/01/2017"), new SimpleDateFormat("dd/MM/yyyy").parse("14/05/2028")));
			products.put((long)4, new Product((long)4, "Mobile cover", 250, 2505, new SimpleDateFormat("dd/MM/yyyy").parse("19/12/2016"), new SimpleDateFormat("dd/MM/yyyy").parse("27/09/2030")));
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
	}
	
	// This method adds new products
	@Override
	public void addProduct(Product product) {
		products.put(product.getId(), product);
	}

	
	// This method removes the product which is given by admin
	@Override
	public boolean removeProduct(long id) {
		try
		{
			if(products.containsKey(id))
			{
				products.remove(id);
				return true;
			}
		
			throw new NoSuchProductException("NO PRODUCT FOUND");
		}
		catch(NoSuchProductException e)
		{
			System.out.println(e);
			return false;
		}	
	}

	// This method gets the particular product which is asked by admin
	@Override
	public Product getProduct(long id) {
		
		try
		{
			if(products.containsKey(id))
				return products.get(id);
			
			throw new NoSuchProductException("NO PRODUCT FOUND");
		}
		catch(NoSuchProductException e)
		{
			System.out.println(e);
			return null;
		}
	}

	// This method is getting all the products that supplier have
	@Override
	public Map<Long, Product> getAllProduct() {
		
		try
		{
			if(products.isEmpty())
				throw new EmptyProductListException("NO PRODUCTS FOUND");
			
			return products;
		}
		catch(EmptyProductListException e)
		{
			System.out.println(e);
			return null;
		}
		
	}


	@Override
	public boolean updateProduct(Product product) {
		
		if(products.containsKey(product.getId()))
		{
			products.replace(product.getId(), product);
			return true;
		}
		else
			return false;
	}

}
