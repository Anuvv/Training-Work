
//	UTILITY CLASS FOR SCANNER

package com.pkart.util;

import java.util.Scanner;

public class InputUtil {

	private static Scanner scanner=null;

	// This function makes scanner object
	public static Scanner getScanner() {

		if (null == scanner)
			return new Scanner(System.in);
		else
			return scanner;
	}
}
