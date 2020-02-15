package com.architecture.assignment.ecommercestore.mobileDevice;

import com.architecture.assignment.ecommercestore.partnerDealerShop.PartnerDealer;
import com.architecture.assignment.ecommercestore.registeredUser.User;
import com.architecture.assignment.ecommercestore.registeredUser.UserFavMobiles;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mobile_specification")
public class MobileSpecification
{
	private BaseMobileModel mobile;

	private PartnerDealer dealer;

	private List<UserFavMobiles> favMobiles;

	private Long specificationId;

	private Double screenSize;

	private String colour;

	private String processor;

	private Double memory;

	private Double storageCapacity;

	private Boolean isAvailable;

	private Double price;

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
	public Long getSpecificationId()
	{
		return specificationId;
	}

	public void setSpecificationId( Long specificationId )
	{
		this.specificationId = specificationId;
	}

	@OneToMany(mappedBy = "mobileSpecification", cascade = CascadeType.REMOVE)
	@JsonIgnore
	public List<UserFavMobiles> getFavMobiles()
	{
		return favMobiles;
	}

	public void setFavMobiles(
			List<UserFavMobiles> favMobiles )
	{
		this.favMobiles = favMobiles;
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
	public Double getMemory()
	{
		return memory;
	}

	public void setMemory( Double memory )
	{
		this.memory = memory;
	}

	@Column(name = "capacity")
	public Double getStorageCapacity()
	{
		return storageCapacity;
	}

	public void setStorageCapacity( Double storageCapacity )
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
	public Boolean isAvailable()
	{
		return isAvailable;
	}

	public void setAvailable( Boolean available )
	{
		isAvailable = available;
	}

	@Column(name = "price")
	public Double getPrice()
	{
		return price;
	}

	public void setPrice( Double price )
	{
		this.price = price;
	}

}
