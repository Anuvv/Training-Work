
//	 CUSTOMER VALIDATION CLASS

package com.pkart.validation;

import java.util.HashMap;
import java.util.Map;

public class CustomerValidation {
	
	private static Map<Long, String> password;
	
	static
	{
		password = new HashMap<Long, String>();
		
		password.put(1l, "anuvv");
		password.put(2l, "abhi");
		password.put(3l, "vish12");
		password.put(4l, "kt45");
		password.put(5l, "dtk002");
	}

	// This function set customer's new password
	public boolean setPassword(String pass, long id)
	{
		if(password.containsKey(id))
			return false;
		else
		{
			password.put(id, pass);
			return true;
		}	
	}
	
	// This function validates customer password
	public boolean validateCustomer(String pass, long id)
	{
		for(Map.Entry map : password.entrySet())
			if(pass.equals(map.getValue()) && id==(long)map.getKey())
				return true;
		
		return false;
	}
	
	// This method updates customer password
	public boolean updatePassword(String newPass,String oldPass)
	{
		for(Map.Entry map : password.entrySet())
		{
			long id=(long)map.getKey();
			return password.replace(id, oldPass, newPass);
		}
			
		return false;
	}
	
	// This method validates customer name
	public boolean validateCustomerName(String name)
	{
		if(name.matches(".*\\d.*"))
			return true;
		else
			return false;
	}
	
	// This method validates customer email
	public boolean validateCustomerEmail(String email)
	{
		if(email.isEmpty())
			return false;
		else
		{
			if(email.endsWith("@gmail.com") || email.endsWith("@yahoo.com") || email.endsWith("@iCloud.com") || email.endsWith("@hotmail.com") || email.endsWith("@outlook.com"))
				return false;
			else
				return true;
		}
			
	}
	
	//This method validates customer phone number
	public boolean validateCustomerPhoneNumber(long phoneNumber)
	{
		if(String.valueOf(phoneNumber).length() != 10)
			return true;
		else
			return false;
	}
	
	// This method validates Customer id
	public boolean validateCustomerId(long id)
	{
		if(id<5)
			return true;
		else
			return false;
	}
	
	// This method validates whether product quantity is which user demanded is smaller than the present total quantity or not
	public boolean validateQuantity(long productQuantity, long customerQuantity)
	{
		if(productQuantity<customerQuantity)
			return true;
		else
			return false;
	}
}
