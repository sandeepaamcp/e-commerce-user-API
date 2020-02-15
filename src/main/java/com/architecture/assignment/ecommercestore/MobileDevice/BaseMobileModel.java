package com.architecture.assignment.ecommercestore.MobileDevice;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mobile_model")
public class BaseMobileModel
{
	private long modelId;
	private String modelName;
	private MobileManufacturer manufacturer;
	private List<MobileSpecification> mobileSpecificationList;

	@Id
	@GeneratedValue
	@Column(name = "model_id")
	public long getModelId()
	{
		return modelId;
	}

	public void setModelId( long modelId )
	{
		this.modelId = modelId;
	}

	@Column(name = "model_name")
	public String getModelName()
	{
		return modelName;
	}

	public void setModelName( String modelName )
	{
		this.modelName = modelName;
	}

	@Column(name = "manufacturer")
	public MobileManufacturer getManufacturer()
	{
		return manufacturer;
	}

	public void setManufacturer( MobileManufacturer manufacturer )
	{
		this.manufacturer = manufacturer;
	}

	@OneToMany(mappedBy = "mobile", cascade = CascadeType.REMOVE)
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
