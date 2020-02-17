package com.architecture.assignment.ecommercestore.mobileSearch;

import java.util.List;

public class AndCriteria<T> implements Criteria<T>
{
	private Criteria<T> criteria1;
	private Criteria<T> criteria2;

	public AndCriteria( Criteria<T> criteria1, Criteria<T> criteria2 )
	{
		this.criteria1 = criteria1;
		this.criteria2 = criteria2;
	}

	@Override
	public List<T> filter( List<T> input )
	{
		List<T> filteredList1 = criteria1.filter( input );
		return criteria2.filter( filteredList1 );
	}
}
