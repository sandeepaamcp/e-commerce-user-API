package com.architecture.assignment.ecommercestore.registeredUser;

import com.architecture.assignment.ecommercestore.mobileDevice.MobileSpecification;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User
{
	private long userId;
	private String username;
	private String email;
	private String password;
	private List<MobileSpecification> favouriteMobiles;

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	public long getUserId()
	{
		return userId;
	}

	public void setUserId( long userId )
	{
		this.userId = userId;
	}

	@Column(name = "username")
	public String getUsername()
	{
		return username;
	}

	public void setUsername( String username )
	{
		this.username = username;
	}

	@Column(name = "email", nullable = false)
	public String getEmail()
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	@Column(name = "password")
	public String getPassword()
	{
		return password;
	}

	public void setPassword( String password )
	{
		this.password = password;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.DETACH)
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
