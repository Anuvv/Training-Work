
//	SERVICE LAYER OF CUSTOMER

package com.pkart.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pkart.dao.CustomerDaoImpl;
import com.pkart.dao.ICustomerDao;
import com.pkart.exception.NoSuchCustomerException;
import com.pkart.model.CartProduct;
import com.pkart.model.Customer;
import com.pkart.model.Product;

public class CustomerServiceImpl implements ICustomerService {

	private static ICustomerDao customerDao;
	
	public CustomerServiceImpl()
	{
		if(null == customerDao)
			customerDao = new CustomerDaoImpl();
	}
	
	// This method gives customer object to Dao layer and checks whether customer is added or not
	@Override
	public boolean add(Customer customer) {
		customerDao.addCustomer(customer);
		
		Customer savedCustomer = customerDao.getCustomer(customer.getId());
		
		if(savedCustomer != null)
			return true;
		else
			return false;
	}
	
	// This method adds products in the customer's cart
	@Override
	public boolean addInCart(CartProduct cartProduct, Customer customer) {
		
		List<CartProduct> cart = new ArrayList<CartProduct>();
		
		if(customerDao.viewCart(customer.getId()) == null)
		{
			cart.add(cartProduct);
			customerDao.addProductInCart(customer, cart);
			return true;
		}
		
		cart = customerDao.viewCart(customer.getId());
		if(!cart.contains(cartProduct))
		{
			cart.add(cartProduct);
			customerDao.addProductInCart(customer, cart);
			return true;
		}
		else
			return false;
	}

	// This method gets all non expired products from all products
	@Override
	public List<Product> viewNonExpiredProducts(List<Product> products) {
		
		List<Product> unexpireProduct = new ArrayList<Product>();
		
		for(Product product : products)
		{
			Date expiryDate = product.getExpiryDate();
			Date currentDate = new Date();
			
			if(currentDate.before(expiryDate))
				unexpireProduct.add(product);
		}
		
		return unexpireProduct;
	}

	// This method gets the specified customer details from dao layer
	@Override
	public Customer getCustomer(long id) {
		return customerDao.getCustomer(id);
	}

	// This method gets the cart of specified customer
	@Override
	public List<CartProduct> viewCart(long id) {
			if(customerDao.getCustomer(id) != null)
				return customerDao.viewCart(id);
			else
				return null;
	}

}
