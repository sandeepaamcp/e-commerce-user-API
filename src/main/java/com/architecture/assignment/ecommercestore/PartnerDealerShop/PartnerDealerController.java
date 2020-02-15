package com.architecture.assignment.ecommercestore.PartnerDealerShop;

import com.architecture.assignment.ecommercestore.MobileDevice.BaseMobileModel;
import com.architecture.assignment.ecommercestore.MobileDevice.MobileManufacturer;
import com.architecture.assignment.ecommercestore.MobileDevice.MobileSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PartnerDealerController
{

	@Autowired
	PartnerDealerService partnerDealerService;

	@PostMapping("/dealer/add_new_dealer")
	public PartnerDealer addNewDealerShop( @RequestBody @Valid PartnerDealer dealer )
	{
		return partnerDealerService.addNewDealer( dealer );
	}

	@GetMapping("/dealer/get_all_base_models")
	public List<BaseMobileModel> getAllBaseModels()
	{
		return partnerDealerService.getAllBaseModels();
	}

	@GetMapping("/dealer/get_all_mobile_manufacturers")
	public ResponseEntity<List<MobileManufacturer>> getAllMobileManufacturers()
	{
		return partnerDealerService.getAllManufacturers();
	}

	@GetMapping("/dealer/get_all_base_models_by_manufacturer")
	public List<BaseMobileModel> getAllBaseModelsByManufacturer( @RequestParam MobileManufacturer manufacturer )
	{
		return partnerDealerService.getBaseModelsByManufacturer( manufacturer );
	}

	@GetMapping("/dealer/get_all_mobile_specifications")
	public List<MobileSpecification> getAllMobileSpecifciations( @RequestParam long dealerId )
	{
		return partnerDealerService.getAllMobileSpecsByDealerId( dealerId );
	}

	@PostMapping("/dealer/add_new_mobile_specification")
	public MobileSpecification addNewMobileDevice( @RequestParam long baseMobileId, @RequestParam long dealerId,
			@RequestBody MobileSpecification mobileSpecification )
	{
		return partnerDealerService.addNewMobileSpec( baseMobileId, dealerId, mobileSpecification );
	}

	@PutMapping("/dealer/edit_mobile_specification")
	public void editMobileSpec( @RequestParam long mobileSpecId, @RequestParam long dealerId,
			@RequestBody MobileSpecification specification )
	{
		partnerDealerService.editMobileSpec( mobileSpecId, dealerId, specification );
	}

	@DeleteMapping("/dealer/delete_mobile_specification")
	public void deleteMobileSpec( @RequestParam long mobileSpecId )
	{
		partnerDealerService.deleteMobileSpec( mobileSpecId );
	}

}
