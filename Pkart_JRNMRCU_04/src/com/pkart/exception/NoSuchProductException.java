package com.pkart.exception;

public class NoSuchProductException extends Exception
{
	private static final long serialVersionUID = 1L;

	public NoSuchProductException(String str)
	{
		super(str);
	}
}
