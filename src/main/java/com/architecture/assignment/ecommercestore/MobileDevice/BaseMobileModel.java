package com.architecture.assignment.ecommercestore.MobileDevice;

import javax.persistence.*;

@Entity
@Table(name = "mobile_model")
public class BaseMobileModel
{
	private long modelId;
	private String modelName;
	private MobileManufacturer manufacturer;

	@Id
	@GeneratedValue
	@Column(name="mobile_id")
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
}
