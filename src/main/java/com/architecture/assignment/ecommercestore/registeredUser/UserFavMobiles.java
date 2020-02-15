package com.architecture.assignment.ecommercestore.registeredUser;

import com.architecture.assignment.ecommercestore.mobileDevice.MobileSpecification;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "fav_mobiles")
public class UserFavMobiles
{
	private Long id;
	private User user;
	private MobileSpecification mobileSpecification;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	public User getUser()
	{
		return user;
	}

	public void setUser( User user )
	{
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "specification_id")
	@JsonIgnore
	public MobileSpecification getMobileSpecification()
	{
		return mobileSpecification;
	}

	public void setMobileSpecification(
			MobileSpecification mobileSpecification )
	{
		this.mobileSpecification = mobileSpecification;
	}
}
