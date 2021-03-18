
//	CONTROLLER LAYER OF ADMIN

package com.pkart.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.pkart.exception.UserException;
import com.pkart.model.CartProduct;
import com.pkart.model.Customer;
import com.pkart.model.Product;
import com.pkart.service.CustomerServiceImpl;
import com.pkart.service.ProductServiceImpl;
import com.pkart.util.DateUtil;
import com.pkart.util.InputUtil;
import com.pkart.validation.AdminValidation;
import com.pkart.validation.ProductValidation;

public class AdminController {

	private static ProductServiceImpl productService = null;
	private static AdminValidation adminValidation = null;
	private static CustomerServiceImpl customerService = null;
	
	static
	{
		if(productService == null)
			productService=new ProductServiceImpl();
		
		if(adminValidation == null)
			adminValidation=new AdminValidation();
	
		if(customerService == null)
			customerService=new CustomerServiceImpl();
	}
	
	
	// This method does all operations like add product, remove product, view all products, view customer
	public void operations() throws ParseException, UserException
	{
		Scanner scanner=InputUtil.getScanner();
		boolean retry=true;
		boolean permission=true;
		int chances=3;
		String password;
		int choice;
		
		while(retry)
		{
			System.out.println("Enter password: ");
			password=scanner.next();
			
			if(adminValidation.validateAdmin(password))
			{
				
				
				while(permission)
				{
					System.out.println("----- WELCOME TO ADMIN OPERATIONS ----");
					System.out.println(" 1.Product operations \n 2.Customer operations \n 3.Exit");
					choice=scanner.nextInt();
					Product product;
					Customer customer;
					boolean status;
					long id;
					
					switch(choice)
					{
					case 1:
						status=true;
						
						while(status)
						{
							System.out.println(" 1.Add product \n 2.Update product \n 3.Remove product \n 4.View product \n 5.View all products \n 6.Exit");
							System.out.println("Enter your choice: ");
							choice=scanner.nextInt();
							boolean updateStatus=true;
							
							switch(choice)
							{
							case 1:
								product=addProduct();
								productService.add(product);
								
								if(product.getId() != 0)
									System.out.println("Product added successfully.");
								else
									System.out.println("Product not added.");
								break;
								
							case 2:
								System.out.println("Enter product id: ");
								id=scanner.nextLong();
								
								while(updateStatus)
								{
									product=productService.getProduct(id);
									if(product!= null)
									{
										System.out.println(" 1.Name \n 2.Price \n 3.Exit");
										System.out.println("Enter your choice: ");
										int updateChoice=scanner.nextInt();
										
										switch(updateChoice)
										{
										case 1:
											System.out.println("Enter new name: ");
											String name=scanner.next();
											product.setName(name);
											
											if(productService.update(product))
												System.out.println("Product updated successfully.");
											else
												System.out.println("Product not updated");
											break;
											
										case 2:
											System.out.println("Enter new price: ");
											double price=scanner.nextDouble();
											product.setPrice(price);
											
											if(productService.update(product))
												System.out.println("Product updated successfully.");
											else
												System.out.println("Product not updated");
											break;
											
										case 3:
											updateStatus=false;
											break;
											
										default:
											System.out.println("WRONG CHOICE!!!");
										}
									}
									else
										break;
									
								}
								break;
								
							case 3:
								System.out.println("Enter product id to be removed: ");
								id=scanner.nextLong();
								
								if(productService.remove(id))
									System.out.println("Product removed successfully.");
								
								break;
								
							case 4:
								System.out.println("Enter product id: ");
								id=scanner.nextLong();
								product = productService.getProduct(id);
								
								if(product != null)
									System.out.println(product);
								
								break;
								
							case 5:
								System.out.println("All products: ");
								List<Product> products= productService.getAllProduct();
								
								if(products != null)
									System.out.println(products);
								System.out.println();
								break;
								
							case 6:
								status=false;
								break;
								
							default:
								System.out.println("WRONG CHOICE!!!");
							}
						}
						break;
						
					case 2:
						status=true;
						
						while(status)
						{
							System.out.println(" 1.View customer \n 2.View purchased products of customer \n 3.Exit");
							System.out.println("Enter your choice: ");
							choice=scanner.nextInt();
							
							switch(choice)
							{
							case 1:
								System.out.println("Enter customer id: ");
								id=scanner.nextLong();
								customer=customerService.getCustomer(id);
								if(customer != null)
									System.out.println(customer);
								else
									System.out.println("No customer found");
								break;
								
							case 2:
								System.out.println("Enter customer id: ");
								id=scanner.nextLong();
								List<CartProduct> cart=customerService.viewCart(id);
								
								if(cart != null)
									System.out.println("Product purchased by " + id + " are: " + cart);
								else
									System.out.println("Cart is empty.");
								break;
								
							case 3:
								status=false;
								break;
								
							default:
								System.out.println("WRONG CHOICE!!!");
							}
						}
						break;
						
					case 3:
						permission=false;
						retry=false;
						break;
						
					default:
						System.out.println("WRONG CHOICE!!!");
					}
				}	
			}
			else
			{
				System.out.println("Wrong password!!!");
				chances--;
				System.out.println("Only " + chances + " chance remaining.");
			}
		}
	}
	
	
	//this method is taking details of product from admin to be added
	private Product addProduct() throws ParseException
	{
			Scanner scanner = InputUtil.getScanner();
			ProductValidation productValidation=new ProductValidation();

			boolean status=true;
			long id = 0;
			String name=null;
			double price=0;
			long quantity=0;                 
			Date mDate = null;
			Date eDate = null;
			String strDate;
			
			while(status)
			{
				System.out.println("Enter product id: ");
				id=scanner.nextLong();
				if(productValidation.validateProductId(id))
				{
					System.out.println("Product id should be greater than 4");
				}
				else
					status=false;
			}
			
			status=true;
			while(status)
			{
				System.out.println("Enter product name: ");
				name=scanner.next();
				if(productValidation.validateProductName(name))
					System.out.println("Product name is not valid");
				else
					status=false;
			}
			
			status=true;
			while(status)
			{
				System.out.println("Enter product price: ");
				price=scanner.nextDouble();
				if(productValidation.validateProductPrice(price))
					System.out.println("Product price is not valid");
				else
					status=false;
			}
			
			status=true;
			while(status)
			{
				System.out.println("Enter product quantity: ");
				quantity=scanner.nextLong();
				if(productValidation.validateProductQuantity(quantity))
					System.out.println("Product quantity is not valid");
				else
					status=false;
			}
			
			status=true;
			while(status)
			{
				System.out.println("Enter product's manufactured date: ");
				strDate=scanner.next();
				mDate=DateUtil.getDate(strDate);
				if(productValidation.validateDate(mDate))
					System.out.println("Product manufacture date is not valid");
				else
					status=false;
			}
			
			status=true;
			while(status)
			{
				System.out.println("Enter product's expiry date: ");
				strDate=scanner.next();
				eDate=DateUtil.getDate(strDate);
				if(productValidation.validateDate(eDate))
					System.out.println("Product expiry date is not valid");
				else
					status=false;
			}
			
			return new Product(id, name, price, quantity, mDate, eDate);
	}
}
