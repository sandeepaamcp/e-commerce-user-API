package com.architecture.assignment.ecommercestore.mobileDevice;

public class MobileNotFoundException extends RuntimeException
{
	public MobileNotFoundException( String s )
	{
		super( s );
	}
	public MobileNotFoundException(){
		super();
	}
}
