package com.HumaneSocietyManagerKs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Employee")
@Table (name="Employee")
public class Employee {

	@Id
	@Column (name="id")
	private int id;
	@Column (name="firstName")
	private String firstName;
	@Column (name="lastName")
	private String lastName;
	@Column (name="salary")
	private double salary;
	@Column (name="position")
	private String position;
	@Column (name="locationId")
	private int locationId;
	@Column (name="password")
	private String password;
	
	public Employee() {
		super();
	}

	public Employee(int id, String firstName, String lastName, double salary, String position, int locationId, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.position = position;
		this.locationId = locationId;
		this.password = password;
	}

	public int getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public int getLocationId() {
		return locationId;
	}
	
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		// need to fill out %3s  in quotation marks (for each thingy)
		return String.format("", id, firstName, lastName, salary, position, locationId, password);
	}
	
	
}