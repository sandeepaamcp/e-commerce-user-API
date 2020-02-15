package com.architecture.assignment.ecommercestore.partnerDealerShop;

public class DealerNotAvailableException extends RuntimeException
{
	public DealerNotAvailableException( String s )
	{
		super( s );
	}
	public DealerNotAvailableException(){
		super();
	}
}