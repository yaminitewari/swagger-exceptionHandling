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
@Table(name="Details")
public class Details {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer detailId;
	private String name;
	private Integer age;
	private String gender;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="region_id")
	private Region region;
	public Details(Integer detailId, String name, Integer age, String gender, Region region) {
		super();
		this.detailId = detailId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.region = region;
	}
	
	public Details() {
		
	}
	
	public Integer getDetailId() {
		return detailId;
	}
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
	

}
