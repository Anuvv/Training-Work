
//	MAIN CONTROLLER CLASS

package com.pkart.controller;

import java.text.ParseException;
import java.util.Scanner;

import com.pkart.exception.UserException;
import com.pkart.util.InputUtil;

public class MainController {

	public static void main(String[] args) throws ParseException, UserException {

		runApplication();
	}

	// This method is used to run all functionalities
	private static void runApplication() throws ParseException, UserException {

		Scanner scanner = InputUtil.getScanner();
		boolean status=true;
		
		while(status)
		{
			System.out.println("------WELCOME TO PKart-------");
			System.out.println("1. Customer \n 2.Admin \n 3.Exit");

			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();

			switch (choice) 
			{
			case 1:
				CustomerController customerController = new CustomerController();
				customerController.operations();
				break;

			case 2:
				AdminController adminController = new AdminController();
				adminController.operations();
				break;

			case 3:
				status=false;
				System.out.println("--- PLEASE VISIT AGAIN ---");
				break;
				
			default:
				System.out.println("WRONG CHOICE!!!");
			}
		}
	}
}
