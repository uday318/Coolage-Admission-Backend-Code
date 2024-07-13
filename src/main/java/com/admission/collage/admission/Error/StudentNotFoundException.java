package com.admission.collage.admission.Error;

public class StudentNotFoundException extends Exception{
	
	public StudentNotFoundException()
	{
		super();
	}
	
	public StudentNotFoundException(String message)
	{
		super(message);
	}
	
	public StudentNotFoundException(String message , Throwable cause)
	{
		super(message,cause);
	}
	

	public StudentNotFoundException(Throwable cause)
	{
		super(cause);
	}
}
