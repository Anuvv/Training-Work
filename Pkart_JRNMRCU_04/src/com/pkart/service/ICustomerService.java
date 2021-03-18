
//	INTERFACE OF CUSTOMER SERVICE CLASS

package com.pkart.service;

import java.util.List;

import com.pkart.model.CartProduct;
import com.pkart.model.Customer;
import com.pkart.model.Product;

public interface ICustomerService {

	public boolean add(Customer customer);
	
	public List<Product> viewNonExpiredProducts(List<Product> products);
	
	public boolean addInCart(CartProduct cartproduct, Customer customer);
	
	public  Customer getCustomer(long id);
	
	public List<CartProduct> viewCart(long id);
}
