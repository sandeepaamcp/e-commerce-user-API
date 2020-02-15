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

	public BaseMobileModel getMobileModel( Long id )
	{
		if ( !baseMobileRepository.findById( id ).isPresent() )
		{
			throw new MobileNotFoundException();
		}
		return baseMobileRepository.findById( id ).get();
	}

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
		if ( !baseMobileRepository.findById( baseModelId ).isPresent() )
		{
			throw new MobileNotFoundException( "The requested mobile with id " + baseModelId + " is not found." );
		}
		BaseMobileModel baseMobileModel = baseMobileRepository.findById( baseModelId ).get();

		if ( !newModel.getModelName().equals( "" ) )
		{
			baseMobileModel.setModelName( newModel.getModelName() );
		}

		if ( newModel.getManufacturer() != null )
		{
			baseMobileModel.setManufacturer( newModel.getManufacturer() );
		}
		baseMobileRepository.save( baseMobileModel );
	}

	public List<BaseMobileModel> getAllMobileModels()
	{
		return baseMobileRepository.findAll();
	}

	public List<BaseMobileModel> getAllMobileModelsByManufacturerName( MobileManufacturer manufacturer )
	{
		return baseMobileRepository.getAllByManufacturer( manufacturer );
	}

	public void deleteMobileModel( long baseModelId )
	{
		if ( !baseMobileRepository.findById( baseModelId ).isPresent() )
		{
			throw new MobileNotFoundException(
					"The requested mobile with ID: " + baseModelId + " is not found for deletion" );
		}
		BaseMobileModel model = baseMobileRepository.findById( baseModelId ).get();
		baseMobileRepository.delete( model );
	}
}