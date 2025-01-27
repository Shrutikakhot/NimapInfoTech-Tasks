package com.example.demo.exception;

public class UserNotFoundException extends Exception {

	public UserNotFoundException()
	{
		
	}
	
	public UserNotFoundException(String msg)
	{
		super(msg);
	}
	
	public UserNotFoundException(Throwable cause)
	{
		super(cause);
	}
	
	public UserNotFoundException(String msg,Throwable cause)
	{
		super(msg,cause);
	}
	
	
	
}
