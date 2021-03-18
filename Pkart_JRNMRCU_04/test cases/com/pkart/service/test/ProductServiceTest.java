package com.pkart.service.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pkart.model.Product;
import com.pkart.service.IProductService;
import com.pkart.service.ProductServiceImpl;


class ProductServiceImplTest {

	private Product product;
	private IProductService productService;
	
	
	@BeforeEach
	void setUp() throws Exception
	{
		productService = new ProductServiceImpl();
		product = new Product();
		
	}
	
	@AfterEach
	void tearDown() throws Exception
	{
		productService = null;
		product = null;
	}
	
	@Test
	void testUpdateProduct() throws ParseException {
		product.setId(5);
		product.setName("Ball");
		product.setPrice(200);
		product.setQuantity(800);
		product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2019"));
		product.setExpiryDate(new SimpleDateFormat("dd/MM/yyyy").parse("25/11/2024"));
		
		productService.add(product);
		product.setPrice(300);
		
		boolean savedProduct = productService.update(product);
		assertTrue(savedProduct == true);
	}
	
	@Test
	void testUpdateProductNotFound() {
		
		boolean savedProduct = productService.update(product);
		assertFalse(savedProduct == true);
	}
	
	@Test
	void testGetProduct() throws ParseException {
		product.setId(5);
		product.setName("Ball");
		product.setPrice(200);
		product.setQuantity(800);
		product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2019"));
		product.setExpiryDate(new SimpleDateFormat("dd/MM/yyyy").parse("25/11/2024"));
		
		productService.add(product);
		
		Product savedProduct = productService.getProduct(5);
		assertTrue(savedProduct == product);
	}
	
	@Test
	void testGetProductNotFound() throws ParseException {
		product.setId(5);
		product.setName("Ball");
		product.setPrice(200);
		product.setQuantity(800);
		product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2019"));
		product.setExpiryDate(new SimpleDateFormat("dd/MM/yyyy").parse("25/11/2024"));
		
		Product savedProduct = productService.getProduct(5);
		assertFalse(savedProduct == product);
	}
	
}
