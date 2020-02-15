package com.architecture.assignment.ecommercestore.registeredUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/")
public class UserController
{
	@Autowired
	private UserService userService;

	@PostMapping("/user/signup")
	public User createUser( @Valid @RequestBody User user )
	{
		try
		{

			User registeredUser = userService.getUserByEmail( user.getEmail() );
			throw new UserServiceException( "User is already registered with email " + user.getEmail() );
		}
		catch ( NoSuchElementException e )
		{
			return userService.saveUser( user );
		}
	}

	@GetMapping("/user/all_users")
	public List<User> getAllUsers()
	{
		return userService.getAllUsers();
	}

	@GetMapping("/user/get_by_id")
	public User getUser( @RequestParam("userId") Long userId )
	{
		return userService.getUser( userId );
	}

	@GetMapping("/user/get_by_email")
	public User getUserByEmail( @RequestParam("email") String email )
	{
		return userService.getUserByEmail( email );
	}

	@PutMapping("/user/edit_user")
	public ResponseEntity<Object> updateUser( @RequestParam("userId") Long userId, @Valid @RequestBody User user )
	{
		return userService.editUser( userId, user );
	}

	@DeleteMapping("/user/remove_user")
	public void deleteUser( @RequestParam("userId") Long userId )
	{
		userService.removeUser( userId );
	}

	@PostMapping("/user/add_new_favourite_mobile")
	public void addNewFavouriteMobile( @RequestParam Long userId, @RequestParam Long mobileSpecificationId )
	{
		userService.addNewFavouriteMobile( userId, mobileSpecificationId );
	}
}
