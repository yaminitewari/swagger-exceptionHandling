package com.global.rest.controller;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="address")
public class Address implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	 
	//@Column(name="region")
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="region_id")
	private Region region;
	
	/*
	 * @OneToMany(mappedBy="address") private List<Region> region;
	 */
	
	@Column(name="district")
	private String district;
	
	//foreign key reference to employee id 
	@JsonBackReference
	@ManyToOne(cascade= {CascadeType.ALL},fetch= FetchType.EAGER)
	@JoinColumn(name="employee_id")
    private Employee employee;
	
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	/*
	 * public Region getRegion() { return region; } public void setRegion(Region
	 * region) { this.region = region; }
	 */
	
	
	public String getDistrict() {
		return district;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Address(Integer addressId, Region region, String district, Employee employee) {
		super();
		this.addressId = addressId;
		this.region = region;
		this.district = district;
		this.employee = employee;
	}
	public Address() {
		
	}
}
