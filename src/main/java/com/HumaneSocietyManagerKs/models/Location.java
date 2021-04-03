package com.HumaneSocietyManagerKs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name="Location")
@Table (name="Location")
public class Location {
	
	@Id
	@Column (name="id")
	private int id;
	@Column (name="name")
	private String name;
	@Column (name="address")
	private String address;
	
	
	
	public Location() {
		super();
		
	}



	public Location(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		// need to fill out %3s  in quotation marks (for each thingy)
		return String.format("", id, name, address);
	}
	
	
	
	
}
