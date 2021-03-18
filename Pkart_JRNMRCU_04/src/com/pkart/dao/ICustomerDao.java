
// 	INTERFACE OF CUSTOMER DAO CLASS

package com.pkart.dao;

import java.util.List;

import com.pkart.model.CartProduct;
import com.pkart.model.Customer;
import com.pkart.model.Product;

public interface ICustomerDao {

	public void addCustomer(Customer customer);
	
	public Customer getCustomer(long id);
	
	public void addProductInCart(Customer customer, List<CartProduct> cartProduct);
	
	public List<CartProduct> viewCart(long id);
	
}
