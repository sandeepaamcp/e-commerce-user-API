package com.architecture.assignment.ecommercestore.MobileSearch;

import java.util.List;

public interface Criteria<T>
{
	List<T> filter( List<T> input );
}
