package com.architecture.assignment.ecommercestore.MobileDevice;

import com.architecture.assignment.ecommercestore.PartnerDealerShop.PartnerDealer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "mobile_specification")
public class MobileSpecification
{
	private BaseMobileModel mobile;

	private PartnerDealer dealer;

	private long specificationId;

	private Double screenSize;

	private String colour;

	private String processor;

	private double memory;

	private double storageCapacity;

	private boolean isAvailable;

	private double price;

	private String otherSpecifications;

	@ManyToOne
	@JoinColumn(name = "model_id", nullable = false)
	//	@JsonIgnore
	public BaseMobileModel getMobile()
	{
		return mobile;
	}

	public void setMobile( BaseMobileModel mobile )
	{
		this.mobile = mobile;
	}

	@Id
	@GeneratedValue
	@Column(name = "specification_id")
	public long getSpecificationId()
	{
		return specificationId;
	}

	public void setSpecificationId( long specificationId )
	{
		this.specificationId = specificationId;
	}

	@ManyToOne
	@JoinColumn(name = "dealer_id", nullable = false)
	//	@JsonIgnore
	public PartnerDealer getDealer()
	{
		return dealer;
	}

	public void setDealer( PartnerDealer dealer )
	{
		this.dealer = dealer;
	}

	@Column(name = "screen_size")
	public Double getScreenSize()
	{
		return screenSize;
	}

	public void setScreenSize( Double screenSize )
	{
		this.screenSize = screenSize;
	}

	@Column(name = "colour")
	public String getColour()
	{
		return colour;
	}

	public void setColour( String colour )
	{
		this.colour = colour;
	}

	@Column(name = "processor")
	public String getProcessor()
	{
		return processor;
	}

	public void setProcessor( String processor )
	{
		this.processor = processor;
	}

	@Column(name = "memory")
	public double getMemory()
	{
		return memory;
	}

	public void setMemory( double memory )
	{
		this.memory = memory;
	}

	@Column(name = "capacity")
	public double getStorageCapacity()
	{
		return storageCapacity;
	}

	public void setStorageCapacity( double storageCapacity )
	{
		this.storageCapacity = storageCapacity;
	}

	@Column(name = "other_specs")
	public String getOtherSpecifications()
	{
		return otherSpecifications;
	}

	public void setOtherSpecifications( String otherSpecifications )
	{
		this.otherSpecifications = otherSpecifications;
	}

	@Column(name = "is_available")
	public boolean isAvailable()
	{
		return isAvailable;
	}

	public void setAvailable( boolean available )
	{
		isAvailable = available;
	}

	@Column(name = "price")
	public double getPrice()
	{
		return price;
	}

	public void setPrice( double price )
	{
		this.price = price;
	}
}
