
//	TEST CLASS FOR CUSTOMER CONTROLLER LAYER

package com.pkart.controller.test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pkart.model.Customer;
import com.pkart.service.CustomerServiceImpl;
import com.pkart.service.ICustomerService;
import com.pkart.validation.CustomerValidation;

class CustomerControllerTest {

	private Customer customer;
	private ICustomerService customerService;
	private CustomerValidation customerValidation;
		
	// It is used to signal that this method should be executed before each @Test method in the current class.
	@BeforeEach
	void setUp() throws Exception
	{
		customer = new Customer();
		customerService = new CustomerServiceImpl();
		customerValidation = new CustomerValidation();
	}
	
	// It is used to signal that this method should be executed after each @Test method in the current class.
	@AfterEach
	void tearDown() throws Exception
	{
		customer = null;
		customerService = null;
		customerValidation = null;
	}
	
	
	// this method is used to test customer password
	@Test
	void testCustomerPassword()
	{
		customer.setId(1);
		customer.setName("anubhav");
		customer.setEmail("anuvv1999@gmail.com");
		customer.setPhoneNumber(9863729287L);
		customer.setAddress("Kanpur");
		customerService.add(customer);
		
		String password="anuvv";
		Customer savedCustomer = customerService.getCustomer(1);
		customerValidation.setPassword(password, savedCustomer.getId());
		
		assertTrue(customerValidation.validateCustomer("anuvv", savedCustomer.getId()) == true);
	}
	
	// this method is used to test for wrong customer password
	@Test
	void testCustomerWrongPassword()
	{
		customer.setId(1);
		customer.setName("anubhav");
		customer.setEmail("anuvv1999@gmail.com");
		customer.setPhoneNumber(9863729287L);
		customer.setAddress("Kanpur");
		customerService.add(customer);
		
		String password="anuvv";
		Customer savedCustomer = customerService.getCustomer(1);
		customerValidation.setPassword(password, savedCustomer.getId());
		
		assertFalse(customerValidation.validateCustomer("anu", savedCustomer.getId()) == true);
	}
	
}
