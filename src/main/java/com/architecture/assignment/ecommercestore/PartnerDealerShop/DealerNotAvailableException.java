package com.architecture.assignment.ecommercestore.PartnerDealerShop;

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