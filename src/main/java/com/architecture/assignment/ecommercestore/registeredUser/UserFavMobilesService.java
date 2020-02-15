package com.architecture.assignment.ecommercestore.registeredUser;

import com.architecture.assignment.ecommercestore.mobileDevice.MobileSpecification;
import com.architecture.assignment.ecommercestore.mobileDevice.MobileSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFavMobilesService
{
	@Autowired
	UserService userService;

	@Autowired
	MobileSpecificationService mobileSpecificationService;

	@Autowired
	UserFavMobilesRepository favMobilesRepository;

	public UserFavMobiles addNewFavMobile( Long userId, Long mobileSpecificationId )
	{
		User user = userService.getUser( userId );
		MobileSpecification mobileSpecification = mobileSpecificationService.getMobileSpec( mobileSpecificationId );
		UserFavMobiles favMobilesRelation = new UserFavMobiles();
		favMobilesRelation.setMobileSpecification( mobileSpecification );
		favMobilesRelation.setUser( user );
		return favMobilesRepository.save( favMobilesRelation );
	}

	public List<UserFavMobiles> getFavMobilesByUser( Long userId )
	{
		User user = userService.getUser( userId );
		return favMobilesRepository.findAllByUser( user );
	}

	public List<UserFavMobiles> getFavUsersForMobileSpec( Long mobileSpecId )
	{
		MobileSpecification mobileSpecification = mobileSpecificationService.getMobileSpec( mobileSpecId );
		return favMobilesRepository.findAllByMobileSpecification( mobileSpecification );
	}

	public void removeFavMobileRelation( Long favRelationId )
	{
		favMobilesRepository.deleteById( favRelationId );
	}
}
