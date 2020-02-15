package com.architecture.assignment.ecommercestore.PartnerDealerShop;

import com.architecture.assignment.ecommercestore.MobileDevice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerDealerService
{
	@Autowired
	private PartnerDealerRepository partnerDealerRepository;

	@Autowired
	private MobileSpecificationService mobileSpecificationService;

	@Autowired
	private BaseMobileService baseMobileService;

	public PartnerDealer addNewDealer( PartnerDealer dealer )
	{
		return partnerDealerRepository.save( dealer );
	}

	public PartnerDealer getDealerById( long dealerId )
	{
		if ( !partnerDealerRepository.findById( dealerId ).isPresent() )
		{
			throw new DealerNotAvailableException();
		}
		return partnerDealerRepository.findById( dealerId ).get();
	}

	public List<BaseMobileModel> getAllBaseModels()
	{
		return baseMobileService.getAllMobileModels();
	}

	public List<BaseMobileModel> getBaseModelsByManufacturer( MobileManufacturer manufacturer )
	{
		return baseMobileService.getAllMobileModelsByManufacturerName( manufacturer );
	}

	public MobileSpecification addNewMobileSpec( long baseMobileId, long dealerId,
			MobileSpecification mobileSpecification )
	{

		PartnerDealer dealer = getDealerById( dealerId );

		mobileSpecification.setDealer( dealer );

		return mobileSpecificationService.addNewMobileSpec( baseMobileId, mobileSpecification );
	}

	public void editMobileSpec( long mobileSpecId, long dealerId,
			MobileSpecification mobileSpecification )
	{

		PartnerDealer dealer = getDealerById( dealerId );

		mobileSpecification.setDealer( dealer );

		mobileSpecificationService.editMobileSpecification( mobileSpecId, mobileSpecification );
	}

	public void deleteMobileSpec( long mobileSpecId )
	{
		mobileSpecificationService.removeMobileSpec( mobileSpecId );
	}

	public ResponseEntity<List<MobileManufacturer>> getAllManufacturers()
	{
		return baseMobileService.getAllManufacturers();
	}

	public List<MobileSpecification> getAllMobileSpecsByDealerId( long dealerId )
	{
		return getDealerById( dealerId ).getMobileSpecificationList();
	}
}
