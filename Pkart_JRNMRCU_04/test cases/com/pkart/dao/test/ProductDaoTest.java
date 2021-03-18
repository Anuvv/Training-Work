package com.pkart.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pkart.dao.IProductDao;
import com.pkart.dao.ProductDaoImpl;
import com.pkart.model.Product;

class ProductDaoImplTest {

	private Product product;
	private IProductDao productDao;
	@BeforeEach
	void setUp() throws Exception{
		product =new Product();
		productDao = new ProductDaoImpl();
	}
	
	@AfterEach
	void tearDown() throws Exception
	{
		product = null;
		productDao = null;
	}
	
	@Test
	void testAddProduct() throws ParseException {
		product.setId(5);
		product.setName("Ball");
		product.setPrice(200);
		product.setQuantity(800);
		product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2019"));
		product.setExpiryDate(new SimpleDateFormat("dd/MM/yyyy").parse("25/11/2024"));
		productDao.addProduct(product);
		
		Product savedProduct = productDao.getProduct(5);
		assertTrue(savedProduct == product);
	}

	@Test
	void testNotAddProduct() throws ParseException {
		productDao.addProduct(product);
		Product savedProduct = productDao.getProduct(5);
		assertFalse(savedProduct == product);
	}
	
	@Test
	void testRemoveProduct() throws ParseException {
		product.setId(5);
		product.setName("Ball");
		product.setPrice(200);
		product.setQuantity(800);
		product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2019"));
		product.setExpiryDate(new SimpleDateFormat("dd/MM/yyyy").parse("25/11/2024"));
		productDao.addProduct(product);
		
		boolean savedProduct = productDao.removeProduct(5);
		assertTrue(savedProduct == true);
	}
	
	@Test
	void testRemoveProductNotFound() throws ParseException {
		
		boolean savedProduct = productDao.removeProduct(6);
		assertEquals(false,savedProduct);
	}
	
	@Test
	void testtGetProduct() throws ParseException {
		product.setId(5);
		product.setName("Ball");
		product.setPrice(200);
		product.setQuantity(800);
		product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2019"));
		product.setExpiryDate(new SimpleDateFormat("dd/MM/yyyy").parse("25/11/2024"));
		productDao.addProduct(product);
		
		Product savedProduct = productDao.getProduct(5);
		assertTrue(savedProduct == product);
	}
	
	@Test
	void testGetProductNotFound() throws ParseException {
		
		Product savedProduct = productDao.getProduct(5);
		assertFalse(savedProduct == product);
	}
}
