package com.packt.cardatabase.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ownerid;
	private String firstname, lastname;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	@JsonIgnore
	private List<Car> cars;

	public Owner() {

	}

	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public long getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(long ownerid) {
		this.ownerid = ownerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
