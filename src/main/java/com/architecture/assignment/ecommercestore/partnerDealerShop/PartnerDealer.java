package com.architecture.assignment.ecommercestore.partnerDealerShop;

import com.architecture.assignment.ecommercestore.mobileDevice.MobileSpecification;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "partner_dealer")
public class PartnerDealer
{
	private long dealerId;
	private String dealerName;
	private String dealerEmail;
	private String dealerPassword;
	private String address;
	private String contactNo;
	private List<MobileSpecification> mobileSpecificationList;

	@Id
	@GeneratedValue
	@Column(name = "dealer_id")
	public long getDealerId()
	{
		return dealerId;
	}

	public void setDealerId( long dealerId )
	{
		this.dealerId = dealerId;
	}

	@Column(name = "address")
	public String getAddress()
	{
		return address;
	}

	public void setAddress( String address )
	{
		this.address = address;
	}

	@Column(name = "contact_no")
	public String getContactNo()
	{
		return contactNo;
	}

	public void setContactNo( String contactNo )
	{
		this.contactNo = contactNo;
	}

	@OneToMany(mappedBy = "dealer", cascade = CascadeType.REMOVE)
	@JsonIgnore
	public List<MobileSpecification> getMobileSpecificationList()
	{
		return mobileSpecificationList;
	}

	public void setMobileSpecificationList(
			List<MobileSpecification> mobileSpecificationList )
	{
		this.mobileSpecificationList = mobileSpecificationList;
	}

	@Column(name = "dealer_mail", unique = true, nullable = false)
	public String getDealerEmail()
	{
		return dealerEmail;
	}

	public void setDealerEmail( String dealerEmail )
	{
		this.dealerEmail = dealerEmail;
	}

	@Column(name = "dealer_password")
	@JsonIgnore
	public String getDealerPassword()
	{
		return dealerPassword;
	}

	public void setDealerPassword( String dealerPassword )
	{
		this.dealerPassword = dealerPassword;
	}

	@Column(name = "dealer_name")
	public String getDealerName()
	{
		return dealerName;
	}

	public void setDealerName( String dealerName )
	{
		this.dealerName = dealerName;
	}
}
