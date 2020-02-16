package com.architecture.assignment.ecommercestore.partnerDealerShop;

import com.architecture.assignment.ecommercestore.mobileDevice.BaseMobileModel;
import com.architecture.assignment.ecommercestore.mobileDevice.MobileManufacturer;
import com.architecture.assignment.ecommercestore.mobileDevice.MobileSpecification;
import com.architecture.assignment.ecommercestore.registeredUser.User;
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

	@GetMapping("/dealer/get_dealer_by_email")
	public PartnerDealer getDealerByMail( @RequestParam("email") String email )
	{
		return partnerDealerService.getDealerByEmail( email );
	}

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

	@PutMapping("/dealer/edit_mobile_dealer")
	public void editDealer( @RequestParam long dealerId, @RequestBody PartnerDealer newDealerData )
	{
		partnerDealerService.editDealer( dealerId, newDealerData );
	}

	@DeleteMapping("/dealer/remove_mobile_dealer")
	public void editDealer( @RequestParam long dealerId )
	{
		partnerDealerService.deleteDealer( dealerId );
	}

}
