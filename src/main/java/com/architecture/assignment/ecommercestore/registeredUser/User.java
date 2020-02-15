package com.architecture.assignment.ecommercestore.registeredUser;

import com.architecture.assignment.ecommercestore.mobileDevice.MobileSpecification;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity

public class User
{
	private String username;
	private String email;
	private String password;
	private List<MobileSpecification> favouriteMobiles;

	@Column(name = "username")
	public String getUsername()
	{
		return username;
	}

	public void setUsername( String username )
	{
		this.username = username;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword( String password )
	{
		this.password = password;
	}

	public List<MobileSpecification> getFavouriteMobiles()
	{
		return favouriteMobiles;
	}

	public void setFavouriteMobiles(
			List<MobileSpecification> favouriteMobiles )
	{
		this.favouriteMobiles = favouriteMobiles;
	}
}
