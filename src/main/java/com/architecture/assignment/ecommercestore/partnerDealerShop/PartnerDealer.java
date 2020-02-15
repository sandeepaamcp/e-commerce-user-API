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
}
