package com.architecture.assignment.ecommercestore.mobileDevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MobileSpecificationController
{
	@Autowired
	MobileSpecificationService mobileSpecificationService;

	@PostMapping("/mobile_specs/add_new")
	public void addNewMobileSpecification( @RequestParam long baseMobileModelId,
			@Valid @RequestBody MobileSpecification mobileSpecification )
	{
		mobileSpecificationService.addNewMobileSpec( baseMobileModelId, mobileSpecification );
	}

	@PutMapping("/mobile_specs/edit_spec")
	public void editMobileSpecification( @RequestParam long mobileSpecId,
			@RequestBody MobileSpecification mobileSpecification )
	{
		mobileSpecificationService.editMobileSpecification( mobileSpecId, mobileSpecification );
	}

	@DeleteMapping("/mobile_specs/delete_spec")
	public void deleteMobileSpecification( long specificationId )
	{
		mobileSpecificationService.removeMobileSpec( specificationId );
	}
}