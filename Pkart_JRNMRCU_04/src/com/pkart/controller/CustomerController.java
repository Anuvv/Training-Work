
//  CONTROLLER LAYER OF CUSTOMER

package com.pkart.controller;

import java.util.List;
import java.util.Scanner;

import com.pkart.model.CartProduct;
import com.pkart.model.Customer;
import com.pkart.model.Product;
import com.pkart.service.CustomerServiceImpl;
import com.pkart.service.ICustomerService;
import com.pkart.service.IProductService;
import com.pkart.service.ProductServiceImpl;
import com.pkart.util.InputUtil;
import com.pkart.validation.CustomerValidation;

public class CustomerController {

	private static ICustomerService customerService;
	private static IProductService productService;
	private static CustomerValidation customerValidation;
	
	public CustomerController()
	{
		if(null == customerService)
			customerService = new CustomerServiceImpl();
		
		if(null == productService)
			productService = new ProductServiceImpl();
		
		if(null == customerValidation)
			customerValidation = new CustomerValidation();
	}
	
	// This method does all operations like register, login, view cart, view product, etc. for customer
	public void operations()
	{
		Scanner scanner = InputUtil.getScanner();
		boolean status = true;
		boolean proceed=true;
		boolean permission=true;
		Customer customer;
		Product product;
		CartProduct cartProduct;
		long id=0;
		String password;
		
		while(proceed)
		{
			System.out.println("----Welcome to Customer operations----");
			System.out.println("\n 1.Register \n 2.Login \n 3.Exit");
			System.out.println("Enter your choice: ");
			int choose=scanner.nextInt();
			
		switch(choose)
		{
		case 1:
			status=true;
			permission=true;
			customer=readCustomerInfo();
			
			if(customer.getId() == 0)
			{
				System.out.println("Try again!!");
				status=false;
				break;
			}
			
			while(permission)
			{	
				System.out.println("Enter new password: ");
				password=scanner.next();
			
				if(customerValidation.setPassword(password, customer.getId()))
				{
					id=customer.getId();
					permission=false;
					System.out.println("password set.");
				}
				else
				{
					System.out.println("Id is already taken.");
					System.out.println("Enter new id: ");
					id=scanner.nextLong();
					customer.setId(id);
				}
			}
			
			if(customerService.add(customer))
				System.out.println("Customer added with " + customer.getId() + " successfully.");
			else
				System.out.println("Customer not added.");
			break;
			
		case 2:
			status=true;
			
			System.out.println("Enter your id: ");
			id=scanner.nextLong();
			System.out.println("Enter password to login: ");
			password=scanner.next();
			
			if(customerValidation.validateCustomer(password, id))
				System.out.println("logged in");
			else
			{
				System.out.println("Wrong credentials!!!");
				status=false;
			}
			break;

		case 3:
			proceed=false;
			status=false;
			break;
			
		default:
			System.out.println("Wrong choice!!!");
		}
		
		while(status)
		{
			System.out.println("\n 1.View products \n 2.Add product to cart \n 3.View cart \n 4.Update password \n 5.Logout");
			System.out.println("Enter your choice: ");
			int choice=scanner.nextInt();
			
			switch(choice)
			{	
			case 1:
				System.out.println(customerService.viewNonExpiredProducts(productService.getAllProduct()));
				break;
				
			case 2:
				boolean again=true;
				System.out.println("Enter the product id: ");
				long pid=scanner.nextLong();
				long customerQuantity=0;
				customer=customerService.getCustomer(id);
				product=productService.getProduct(pid);
				long productQuantity=product.getQuantity();
				
				while(again)
				{
					System.out.println("Enter the quantity: ");
					customerQuantity=scanner.nextLong();
						
					if(customerValidation.validateQuantity(productQuantity, customerQuantity))
						System.out.println("This much quantity is not present");
					else
						again=false;
				}
						
				cartProduct=readProductDetails(product,customerQuantity);
				
				if(customerService.addInCart(cartProduct, customer))
					System.out.println("Product added");
				
				product.setQuantity(productQuantity-customerQuantity);
				productService.update(product);
				break;
				
			case 3:
				List<CartProduct> purchasedProducts= customerService.viewCart(id);
				
				if(purchasedProducts != null)
					System.out.println(purchasedProducts);
				else
					System.out.println("Cart is empty.");
				break;
				
			case 4:
				System.out.println("Enter old password: ");
				String oldPass=scanner.next();
				System.out.println("Enter new password: ");
				password=scanner.next();
				
				if(customerValidation.updatePassword(password,oldPass))
					System.out.println("password updated successfully");
				else
					System.out.println("password not updated");
				break;

			case 5:
				password=null;
				id=0;
				status=false;
				System.out.println("logged out.");
				break;
				
			default: 
				System.out.println("Wrong choice!!!!");
			}
		}
		
		}
	}

	// This method gets all the details of product to the cart product object
	private CartProduct readProductDetails(Product product, long customerQuantity) {

		CartProduct cartProduct = new CartProduct();
		
		cartProduct.setId(product.getId());
		cartProduct.setName(product.getName());
		cartProduct.setPrice(product.getPrice());
		cartProduct.setQuantity(customerQuantity);
		cartProduct.setManufacturedDate(product.getManufacturedDate());
		cartProduct.setExpiryDate(product.getExpiryDate());
		
		return cartProduct;
	}

	// This method takes details of customer to be added
	private Customer readCustomerInfo() {

		Scanner scanner = InputUtil.getScanner();
		CustomerValidation customerValidation = new CustomerValidation();
		
		boolean status=true;
		long id=0;
		long phoneNumber=0;
		String name=null;
		String email=null;
		String address;
		
		while(status)
		{
			System.out.println("Enter your id: ");
			id=scanner.nextLong();
			if(customerValidation.validateCustomerId(id))
				System.out.println("Customer id is not valid");
			else
				status=false;
		}
		
		status=true;
		while(status)
		{
			System.out.println("Enter your name: ");
			name=scanner.next();
			if(customerValidation.validateCustomerName(name))
				System.out.println("Customer name is not valid");
			else
				status=false;
		}
		
		status=true;
		while(status)
		{
			System.out.println("Enter your email:");
			email=scanner.next();
			if(customerValidation.validateCustomerEmail(email))
				System.out.println("Customer email is not valid");
			else
				status=false;
		}
		
		status=true;
		while(status)
		{
			System.out.println("Enter your phone number: ");
			phoneNumber=scanner.nextLong();
			if(customerValidation.validateCustomerPhoneNumber(phoneNumber))
				System.out.println("Customer phone number is not valid");
			else
				status=false;
		}
		
		System.out.println("Enter your address: ");
		address=scanner.next();
		
		return new Customer(id, name, email, phoneNumber, address);
	}
		
}
