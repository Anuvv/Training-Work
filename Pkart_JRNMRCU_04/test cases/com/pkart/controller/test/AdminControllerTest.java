
//	 TEST CLASS FOR ADMIN CONTROLLER LAYER

package com.pkart.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.pkart.validation.AdminValidation;

class AdminControllerTest {

	private AdminValidation adminValidation;
	
	// It is used to signal that this method should be executed before each @Test method in the current class.
	@BeforeEach
	void setUp() throws Exception
	{
		adminValidation = new AdminValidation();
	}
	
	// It is used to signal that this method should be executed after each @Test method in the current class.
	@AfterEach
	void tearDown() throws Exception
	{
		adminValidation = null;
	}
	
	// This method validates admin password
	@Test
	void testPasswordValidation() {
		assertEquals(adminValidation.validateAdmin("adminpassword"),true);
	}
	
	// This method validates for wrong admin password
	@Test
	void testPasswordNonValidation()
	{
		assertEquals(adminValidation.validateAdmin("adpass"),false);
	}
	
	
}
