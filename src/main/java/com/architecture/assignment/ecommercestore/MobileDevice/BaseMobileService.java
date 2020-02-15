package com.architecture.assignment.ecommercestore.MobileDevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BaseMobileService
{
	@Autowired
	private BaseMobileRepository baseMobileRepository;

	public BaseMobileModel saveMobileModel( BaseMobileModel baseMobileModel )
	{
		return baseMobileRepository.save( baseMobileModel );
	}

	public ResponseEntity<List<MobileManufacturer>> getAllManufacturers()
	{
		return new ResponseEntity<>( Arrays.asList( MobileManufacturer.values() ), HttpStatus.OK );
	}

	public void editMobileModel( long baseModelId, BaseMobileModel newModel )
	{
		baseMobileRepository.findById( baseModelId ).ifPresent( baseMobileModel -> {
			if ( !newModel.getModelName().equals( "" ) )
			{
				baseMobileModel.setModelName( newModel.getModelName() );
			}

			if ( !newModel.getManufacturer().equals( "" ) )
			{
				baseMobileModel.setManufacturer( newModel.getManufacturer() );
			}
		} );
	}

	public List<BaseMobileModel> getAllMobileModels()
	{
		return baseMobileRepository.findAll();
	}

	public List<BaseMobileModel> getAllMobileModelsByManufacturerName( MobileManufacturer manufacturer )
	{
		return baseMobileRepository.getAllByManufacturer( manufacturer );
	}
}