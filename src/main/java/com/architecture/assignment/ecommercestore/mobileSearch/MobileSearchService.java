package com.architecture.assignment.ecommercestore.mobileSearch;

import com.architecture.assignment.ecommercestore.mobileDevice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MobileSearchService
{
	@Autowired
	BaseMobileService baseMobileService;

	@Autowired
	MobileSpecificationService mobileSpecificationService;

	public List<MobileSpecification> getMobilesByManufacturer( MobileManufacturer manufacturer )
	{
		List<MobileSpecification> mobileSpecificationList = new ArrayList<>();
		baseMobileService.getAllMobileModelsByManufacturerName( manufacturer ).stream()
				.forEach( baseMobileModel -> baseMobileModel.getMobileSpecificationList()
						.forEach( mobileSpecification -> mobileSpecificationList.add( mobileSpecification ) ) );
		return mobileSpecificationList;
	}

	public List<MobileSpecification> getMobilesByKeyword( String keyword )
	{
		List<MobileSpecification> mobileSpecificationList = new ArrayList<>();
		baseMobileService.getModelsStartingWithName( keyword ).stream()
				.forEach( baseMobileModel -> baseMobileModel.getMobileSpecificationList()
						.forEach( mobileSpecification -> mobileSpecificationList.add( mobileSpecification ) ) );
		return mobileSpecificationList;
	}

	public List<BaseMobileModel> getBaseModelsByManufacturer( MobileManufacturer manufacturer )
	{
		return baseMobileService.getAllMobileModelsByManufacturerName( manufacturer );
	}

	public ResponseEntity<List<MobileManufacturer>> getAllManufacturers()
	{
		return baseMobileService.getAllManufacturers();
	}

	public List<MobileSpecification> getSetOfMobiles()
	{
		List<MobileSpecification> mobilesList = new ArrayList<>();
		List<MobileManufacturer> manufacturers = getAllManufacturers().getBody();
		for ( MobileManufacturer manufacturer : manufacturers )
		{
			List<BaseMobileModel> models = getBaseModelsByManufacturer( manufacturer );
			for ( BaseMobileModel model : models )
			{
				model.getMobileSpecificationList().stream().forEach( specification -> {
					mobilesList.add( specification );
				} );
				if ( mobilesList.size() > 20 )
				{
					return mobilesList;
				}
			}
		}
		return mobilesList;
	}
}
