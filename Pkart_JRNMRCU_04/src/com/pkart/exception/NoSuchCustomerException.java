package com.pkart.exception;

public class NoSuchCustomerException extends Exception
{
	private static final long serialVersionUID = 1L;

	public NoSuchCustomerException(String str)
	{
		super(str);
	}
}
