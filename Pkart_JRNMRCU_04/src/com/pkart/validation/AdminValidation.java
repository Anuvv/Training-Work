
//	ADMIN VALIDATION CLASS

package com.pkart.validation;

public class AdminValidation {

	private static String password="adminpassword";
	
	// This function validates admin password
	public boolean validateAdmin(String pass)
	{
		if(password.equals(pass))
			return true;
		else
			return false;
	}
}
