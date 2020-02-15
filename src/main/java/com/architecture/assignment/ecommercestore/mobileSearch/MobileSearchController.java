package com.architecture.assignment.ecommercestore.mobileSearch;

import com.architecture.assignment.ecommercestore.mobileDevice.BaseMobileModel;
import com.architecture.assignment.ecommercestore.mobileDevice.MobileManufacturer;
import com.architecture.assignment.ecommercestore.mobileDevice.MobileSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MobileSearchController
{

	@Autowired
	MobileSearchService mobileSearchService;

	@GetMapping("/mobile_search/get_all_manufacturers")
	public ResponseEntity<List<MobileManufacturer>> getAllMobileModels()
	{
		return mobileSearchService.getAllManufacturers();
	}

	@GetMapping("/mobile_search/get_mobiles_by_manufacturer")
	public List<MobileSpecification> getMobilesByManufacturer( @RequestParam MobileManufacturer manufacturer )
	{
		return mobileSearchService.getMobilesByManufacturer( manufacturer );
	}

	@GetMapping("/mobile_search/get_mobiles_by_manufactuer_and_price")
	public List<MobileSpecification> getMobilesByManufacturerWithPriceCriteria(
			@RequestParam MobileManufacturer manufacturer,
			@RequestParam Double price, @RequestParam ThresholdVariation variation )
	{
		return new PriceCriteria( price, variation )
				.filter( mobileSearchService.getMobilesByManufacturer( manufacturer ) );
	}

	@GetMapping("/mobile_search/get_mobiles_by_keyword")
	public List<MobileSpecification> getMobilesByKeyword( @RequestParam String keyword )
	{
		return mobileSearchService.getMobilesByKeyword( keyword );
	}

	@GetMapping("/mobile_search/get_available_models_for_manufacturer")
	public List<BaseMobileModel> getAllMobileModels( @RequestParam MobileManufacturer manufacturer )
	{
		return mobileSearchService.getBaseModelsByManufacturer( manufacturer );
	}
}
