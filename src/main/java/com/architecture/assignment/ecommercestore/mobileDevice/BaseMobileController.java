package com.architecture.assignment.ecommercestore.mobileDevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BaseMobileController
{
	@Autowired
	private BaseMobileService baseMobileService;

	@GetMapping("/mobile_model/get_all_models")
	public List<BaseMobileModel> getAllMobileModels(){
		return baseMobileService.getAllMobileModels();
	}

	@GetMapping("/mobile_model/get_all_models_by_manufacturer")
	public List<BaseMobileModel> getAllMobileModelsByManufacturer(@RequestParam MobileManufacturer manufacturer){
		return baseMobileService.getAllMobileModelsByManufacturerName(manufacturer);
	}

	@PostMapping("/mobile_model/add_new")
	public BaseMobileModel addNewBaseMobileModel( @Valid @RequestBody BaseMobileModel baseMobileModel )
	{
		return baseMobileService.saveMobileModel(baseMobileModel);
	}

	@PutMapping("/mobile_model/edit_model")
	public void editBaseMobileModel(long baseModelId, BaseMobileModel newModel){
		baseMobileService.editMobileModel(baseModelId, newModel);
	}

	public void deleteBaseMobileModel(long baseModelId){
		baseMobileService.deleteMobileModel(baseModelId);
	}

	@GetMapping("/mobile_model/get_available_manufacturers")
	public ResponseEntity<List<MobileManufacturer>> getAllMobileManufacturers(){
		return baseMobileService.getAllManufacturers();
	}
}
