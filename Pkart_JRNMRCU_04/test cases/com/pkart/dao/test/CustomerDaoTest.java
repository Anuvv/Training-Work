package com.pkart.dao.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pkart.dao.CustomerDaoImpl;
import com.pkart.dao.ICustomerDao;
import com.pkart.model.Customer;

class CustomerDaoImplTest {

	private Customer customer;
	private  ICustomerDao customerDao;
	
	
	
	@BeforeEach
	void setUp() throws Exception
	{
		customer = new Customer();
		customerDao = new CustomerDaoImpl();
	}
	
	@AfterEach
	void tearDown() throws Exception
	{
		customerDao = null;
		customer = null;
	}
	
	@Test
	void testAddCustomer() {
		customer.setId(2);
		customer.setName("anubhav");
		customer.setEmail("anuvv1999@gmail.com");
		customer.setPhoneNumber(9863729287L);
		customer.setAddress("Kanpur");
		customerDao.addCustomer(customer);
		
		Customer savedCustomer=customerDao.getCustomer(2);
		assertEquals(customer, savedCustomer);
	}
	
	@Test
	void testAddCustomerNotFound() {
		customer.setId(1);
		customer.setName("anubhav");
		customer.setEmail("anuvv1999@gmail.com");
		customer.setPhoneNumber(9863729287L);
		customer.setAddress("Kanpur");
		
		Customer savedCustomer=customerDao.getCustomer(1);
		assertFalse(customer == savedCustomer);
	}

	@Test
	void testGetCustomer() {
		customer.setId(3);
		customer.setName("anubhav");
		customer.setEmail("anuvv1999@gmail.com");
		customer.setPhoneNumber(9863729287L);
		customer.setAddress("Kanpur");
		customerDao.addCustomer(customer);
		
		assertEquals(customer, customerDao.getCustomer(3));
	}
	
	@Test
	void testGetCustomerNotFound() {
		customer.setId(1);
		customer.setName("anubhav");
		customer.setEmail("anuvv1999@gmail.com");
		customer.setPhoneNumber(9863729287L);
		customer.setAddress("Kanpur");
		customerDao.addCustomer(customer);
		
		Customer savedCustomer = customerDao.getCustomer(2);
		assertFalse(customer == savedCustomer);
	}
	
}
