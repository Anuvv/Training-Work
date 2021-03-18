package com.pkart.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pkart.model.Customer;
import com.pkart.model.Product;
import com.pkart.service.CustomerServiceImpl;
import com.pkart.service.ICustomerService;


class CustomerServiceImplTest {

	private Customer customer;
	private  Product product;
	private  ICustomerService customerService;
	
	@BeforeEach
	void setUp() throws Exception
	{
		customer = new Customer();
		product = new Product();
		customerService = new CustomerServiceImpl();
	}
	
	@AfterEach
	void tearDown() throws Exception
	{
		customerService = null;
		customer = null;
		product = null;
	}
		
	@Test
	void testViewNonExpiredProducts() throws ParseException
	{
		List<Product> products = new ArrayList<Product>();
		
		product.setId(1);
		product.setName("TV");
		product.setPrice(50000);
		product.setQuantity(20);
		product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2019"));
		product.setExpiryDate(new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2029"));
		products.add(product);
		
		product.setId(2);
		product.setName("Phone");
		product.setPrice(20000);
		product.setQuantity(100);
		product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2019"));
		product.setExpiryDate(new SimpleDateFormat("dd/MM/yyyy").parse("14/10/2022"));
		products.add(product);
	
		assertEquals(customerService.viewNonExpiredProducts(products), products);
	}
	
	@Test
	void testViewAllProducts() throws ParseException
	{
		List<Product> products = new ArrayList<Product>();
		
		product.setId(1);
		product.setName("TV");
		product.setPrice(50000);
		product.setQuantity(20);
		product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2019"));
		product.setExpiryDate(new SimpleDateFormat("dd/MM/yyyy").parse("12/12/2020"));
		products.add(product);
		
		product.setId(2);
		product.setName("Phone");
		product.setPrice(20000);
		product.setQuantity(100);
		product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2019"));
		product.setExpiryDate(new SimpleDateFormat("dd/MM/yyyy").parse("14/10/2022"));
		products.add(product);
	
		assertFalse(products == customerService.viewNonExpiredProducts(products));
	}

	@Test
	void testGetCustomer() {
		customer.setId(2);
		customer.setName("anubhav");
		customer.setEmail("anuvv1999@gmail.com");
		customer.setPhoneNumber(9863729287L);
		customer.setAddress("Kanpur");
		customerService.add(customer);
		
		assertTrue(customer == customerService.getCustomer(2));
	}
	
	@Test
	void testGetCustomerNotFound() {
		customer.setId(1);
		customer.setName("anubhav");
		customer.setEmail("anuvv1999@gmail.com");
		customer.setPhoneNumber(9863729287L);
		customer.setAddress("Kanpur");
		customerService.add(customer);
		
		Customer savedCustomer = customerService.getCustomer(2);
		assertFalse(customer == savedCustomer);
	}
}
