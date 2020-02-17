package com.architecture.assignment.ecommercestore.mobileSearch;

import java.util.List;

public interface Criteria<T>
{
	List<T> filter( List<T> input );
}
