package com.architecture.assignment.ecommercestore.mobileDevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileSpecificationService
{
	@Autowired
	private MobileSpecificationRepository specificationRepository;

	@Autowired
	private BaseMobileRepository baseMobileRepository;

	public MobileSpecification addNewMobileSpec( long baseMobileModelId, MobileSpecification mobileSpecification )
	{
		if ( baseMobileRepository.findById( baseMobileModelId ).isPresent() )
		{
			BaseMobileModel model = baseMobileRepository.findById( baseMobileModelId ).get();
			mobileSpecification.setMobile( model );
			specificationRepository.save( mobileSpecification );
			return mobileSpecification;
		}
		else
		{
			throw new MobileNotFoundException();
		}
	}

	public void editMobileSpecification( long mobileSpecId, MobileSpecification newSpcifications )
	{
		if ( specificationRepository.findById( mobileSpecId ).isPresent() )
		{
			MobileSpecification model = specificationRepository.findById( mobileSpecId ).get();
			specificationRepository.save( newSpcifications );
		}
		else
		{
			throw new MobileNotFoundException();
		}
	}

	public void removeMobileSpec( long mobileSpecId )
	{
		if ( specificationRepository.findById( mobileSpecId ).isPresent() )
		{
			specificationRepository.deleteById( mobileSpecId );
		}
		else
		{
			throw new MobileNotFoundException();
		}
	}
}
