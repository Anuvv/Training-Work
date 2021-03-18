
//  DAO LAYER OF CUSTOMER

package com.pkart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pkart.exception.CartEmptyException;
import com.pkart.exception.NoSuchCustomerException;
import com.pkart.model.CartProduct;
import com.pkart.model.Customer;
import com.pkart.model.Product;

public class CustomerDaoImpl implements ICustomerDao{

	private static Map<Customer, List<CartProduct>> cart;
	
	static
	{
		cart = new HashMap<Customer, List<CartProduct>>();
		
		cart.put(new Customer(1,"anubhav","anuvv19@gmail.com",95375123409L,"kanpur"),null);
		cart.put(new Customer(2,"abhinav","abhi29@outlook.com",95375372009L,"lucknow"),null);
		cart.put(new Customer(3,"vishal","vishi12@hotmail.com",8325123429L,"chandigarh"),null);
		cart.put(new Customer(4,"kritika","kriti2812@iCoud.com",9924309029L,"chennai"),null);
		cart.put(new Customer(5,"drutika","drut002@gmail.com",8174338484L,"guwahati"),null);
	}
	
	// This method adds new customer
	@Override
	public void addCustomer(Customer customer) {
		cart.put(customer, null);
	}

	// This method adds the product in the cart
	@Override
	public void addProductInCart(Customer customer, List<CartProduct> cartProduct) {
			cart.put(customer, cartProduct);
	}

	// This method get the cart of customer
	@Override
	public List<CartProduct> viewCart(long id) {
		try
		{
			for(Customer customer : cart.keySet())
			{
				if(customer.getId() == id)
					return cart.get(customer);
			}
			
			throw new CartEmptyException("CART IS EMPTY");
		}
		catch(CartEmptyException e)
		{
			System.out.println(e);
			return null;
		}
		
	}

	// This method get customer details 
	@Override
	public Customer getCustomer(long id) {
		
		try
		{
			for(Customer customer : cart.keySet())
			{
				if(customer.getId() == id)
					return customer;
			}
		
			throw new NoSuchCustomerException("NO SUCH CUSTOMER FOUND");
		}
		catch(NoSuchCustomerException e)
		{
			System.out.println(e);
			return null;
		}	
	}
}
