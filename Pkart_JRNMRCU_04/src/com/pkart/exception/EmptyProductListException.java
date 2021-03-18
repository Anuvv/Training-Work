package com.pkart.exception;

public class EmptyProductListException extends Exception
{
	private static final long serialVersionUID = 1L;

	public EmptyProductListException(String str)
	{
		super(str);
	}
}
