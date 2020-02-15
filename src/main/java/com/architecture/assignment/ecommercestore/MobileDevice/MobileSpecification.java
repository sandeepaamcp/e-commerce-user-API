package com.architecture.assignment.ecommercestore.MobileDevice;

public class MobileSpecification
{

	private BaseMobileModel mobile;

	private long specificationId;

	private Double screenSize;

	private String colour;

	private String processor;

	private double memory;

	private double storageCapacity;

	private String otherSpecifications;

	public BaseMobileModel getMobile()
	{
		return mobile;
	}

	public void setMobile( BaseMobileModel mobile )
	{
		this.mobile = mobile;
	}

	public Double getScreenSize()
	{
		return screenSize;
	}

	public void setScreenSize( Double screenSize )
	{
		this.screenSize = screenSize;
	}

	public String getColour()
	{
		return colour;
	}

	public void setColour( String colour )
	{
		this.colour = colour;
	}

	public String getProcessor()
	{
		return processor;
	}

	public void setProcessor( String processor )
	{
		this.processor = processor;
	}

	public double getMemory()
	{
		return memory;
	}

	public void setMemory( double memory )
	{
		this.memory = memory;
	}

	public double getStorageCapacity()
	{
		return storageCapacity;
	}

	public void setStorageCapacity( double storageCapacity )
	{
		this.storageCapacity = storageCapacity;
	}

	public String getOtherSpecifications()
	{
		return otherSpecifications;
	}

	public void setOtherSpecifications( String otherSpecifications )
	{
		this.otherSpecifications = otherSpecifications;
	}
}
