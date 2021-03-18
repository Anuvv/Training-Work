
//	 VALIDATION CLASS FOR PRODUCT DETAILS

package com.pkart.validation;

import java.util.Date;

public class ProductValidation {

	// This method validates for product id
	public boolean validateProductId(long id)
	{
		if(id<4)
		{
			return true;
		}
		else
			return false;
	}
	
	// This method validates for date of manufacturing and expiration
	public boolean validateDate(Date date)
	{
		if(date != null)
			return false;
		else
			return true;
	}
	
	// This method validates for product name
	public boolean validateProductName(String name)
	{
		if(name.matches(".*\\d.*"))
			return true;
		else
			return false;
	}
	
	// This method validates for product quantity
	public boolean validateProductQuantity(long quantity)
	{
		if(quantity<0)
			return true;
		else
			return false;
	}
	
	// This method validates for product price
	public boolean validateProductPrice(double price)
	{
		if(price<0)
			return true;
		else
			return false;
	}
}
