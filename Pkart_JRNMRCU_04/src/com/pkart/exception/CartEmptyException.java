package com.pkart.exception;

public class CartEmptyException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public CartEmptyException(String str)
	{
		super(str);
	}
}
