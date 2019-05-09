package com.global.rest.controller;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Region")
public class Region {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer regionId;
	private String area;
	private Integer pincode;
	
	
	
//	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//	@JoinColumn(name="address_id")
//	private Address address;
	
	public Region(Integer regionId, String area, Integer pincode) {
		super();
		this.regionId = regionId;
		this.area = area;
		this.pincode = pincode;
	}
	
	public Region() {
		
	}
	public Integer getRegionId() {
		return regionId;
	}
	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
	

}
