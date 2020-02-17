package com.architecture.assignment.ecommercestore.registeredUser;

import com.architecture.assignment.ecommercestore.mobileDevice.MobileSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserFavMobilesController
{
	@Autowired
	private UserFavMobilesService favMobilesService;

	@PostMapping("/user_fav_mobiles/add_new")
	public UserFavMobiles addNewUserFavMobile( @RequestParam Long userId, @RequestParam Long mobileSpecificationId )
	{
		return favMobilesService.addNewFavMobile( userId, mobileSpecificationId );
	}

	@GetMapping("/user_fav_mobiles/get_fav_mobiles_of_user")
	public List<UserFavMobiles> getUserFavMobiles( @RequestParam Long userId )
	{
		return favMobilesService.getFavMobilesByUser( userId );
	}

	@GetMapping("/user_fav_mobiles/get_subscribed_fav_users_of_mobiles")
	public List<UserFavMobiles> getFavMobileSubscribedUsers( @RequestParam Long mobileSpecId )
	{
		return favMobilesService.getFavUsersForMobileSpec( mobileSpecId );
	}

	//TODO: find the issue of CORS blocking DELETE mapping OPTIONS request
	@PostMapping("/user_fav_mobiles/remove_relation")
	public void deleteUserFavMobile( @RequestParam Long favMobileRelationId )
	{
		favMobilesService.removeFavMobileRelation( favMobileRelationId );
	}
}
