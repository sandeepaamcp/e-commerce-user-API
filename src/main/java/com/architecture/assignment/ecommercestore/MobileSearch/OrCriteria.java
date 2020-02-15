package com.architecture.assignment.ecommercestore.MobileSearch;

import java.util.ArrayList;
import java.util.List;

public class OrCriteria<T> implements Criteria<T>
{

	private Criteria<T> criteria1;
	private Criteria<T> criteria2;

	public OrCriteria( Criteria<T> criteria1, Criteria<T> criteria2 )
	{
		this.criteria1 = criteria1;
		this.criteria2 = criteria2;
	}

	@Override
	public List<T> filter( List<T> input )
	{
		List<T> filteredList = new ArrayList<>();
		filteredList.addAll( criteria1.filter( input ) );
		filteredList.addAll( criteria2.filter( input ) );

		return filteredList;
	}
}
