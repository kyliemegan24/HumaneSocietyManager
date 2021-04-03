package com.HumaneSocietyManagerKs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name="Dog")
@Table (name="Dog")
public class Dog {
	
	@Id
	@Column (name="id")
	private int id;
	@Column (name="id")
	private String name;
	@Column (name="id")
	private int age;
	@Column (name="id")
	private String breed;
	@Column (name="id")
	private boolean upToDateShots;
	@Column (name="id")
	private int gender;
	@Column (name="id")
	private int locationId;
	
	
	public Dog() {
		super();
	}


	public Dog(int id, String name, int age, String breed, boolean upToDateShots, int gender, int locationId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.breed = breed;
		this.upToDateShots = upToDateShots;
		this.gender = gender;
		this.locationId = locationId;
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	public boolean isUpToDateShots() {
		return upToDateShots;
	}


	public void setUpToDateShots(boolean upToDateShots) {
		this.upToDateShots = upToDateShots;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public int getLocationId() {
		return locationId;
	}


	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	
	@Override
	public String toString() {
		// need to fill out %3s in quotation marks for each param
		return String.format("", id, name, age, breed, upToDateShots, gender, locationId);
	}
}