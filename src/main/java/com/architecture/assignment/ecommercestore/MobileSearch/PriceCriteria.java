package com.architecture.assignment.ecommercestore.MobileSearch;

import com.architecture.assignment.ecommercestore.MobileDevice.MobileSpecification;

import java.util.ArrayList;
import java.util.List;

public class PriceCriteria implements Criteria<MobileSpecification>
{
	private Double thresholdPrice;
	private ThresholdVariation variation;

	public PriceCriteria( Double thresholdPrice,
			ThresholdVariation variation )
	{
		this.thresholdPrice = thresholdPrice;
		this.variation = variation;
	}

	@Override
	public List<MobileSpecification> filter( List<MobileSpecification> input )
	{
		List<MobileSpecification> filteredList = new ArrayList<>();

		for ( MobileSpecification mobile : input )
		{
			if ( mobile.getPrice() < thresholdPrice && variation.equals( ThresholdVariation.LESS_THAN ) )
			{
				filteredList.add( mobile );
			}
			else if ( mobile.getPrice() > thresholdPrice && variation.equals( ThresholdVariation.GREATER_THAN ) )
			{
				filteredList.add( mobile );
			}
		}
		return filteredList;
	}
}
