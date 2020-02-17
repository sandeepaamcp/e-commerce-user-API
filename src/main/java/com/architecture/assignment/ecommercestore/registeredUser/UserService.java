package com.architecture.assignment.ecommercestore.registeredUser;

import com.architecture.assignment.ecommercestore.mobileDevice.MobileSpecification;
import com.architecture.assignment.ecommercestore.mobileDevice.MobileSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService
{
	@Autowired
	UserRepository userRepository;

	@Autowired
	MobileSpecificationService mobileSpecificationService;

	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}

	public User saveUser( User user )
	{

		//		user.setPassword( new BCryptPasswordEncoder().encode( user.getPassword() ) );
		user.setPassword( user.getPassword() );
		try
		{
			return userRepository.save( user );

		}
		catch ( DataIntegrityViolationException e )
		{
			throw new UserServiceException( "Email already exists or bad credentials" );
		}

	}

	public User getUser( Long userId )
	{
		Optional<User> userOptional = userRepository.findById( userId );
		if ( !userOptional.isPresent() )
		{
			throw new NoSuchElementException( "User with ID " + userId + " is not found!" );
		}
		return userOptional.get();
	}

	public void removeUser( Long userId )
	{
		userRepository.deleteById( userId );
	}

	public ResponseEntity<Object> editUser( Long userId, User user )
	{
		Optional<User> userOptional = userRepository.findById( userId );
		if ( !userOptional.isPresent() )
		{
			return ResponseEntity.notFound().build();
		}
		user.setUserId( userId );
		userRepository.save( user );
		return ResponseEntity.noContent().build();
	}

	public User getUserByEmail( String email )
	{
		Optional<User> userOptional = userRepository.findByEmail( email );
		if ( !userOptional.isPresent() )
		{
			throw new NoSuchElementException( "User with ID " + email + " is not found!" );
		}
		return userOptional.get();
	}

//	public List<MobileSpecification> addNewFavouriteMobile( Long userId, Long mobileSpecificationId )
//	{
//		User user = userRepository.findById( userId ).get();
//		MobileSpecification mobileSpecification = mobileSpecificationService
//		if ( user.getFavouriteMobiles() == null )
//		{
//
//		}
//	}
}
