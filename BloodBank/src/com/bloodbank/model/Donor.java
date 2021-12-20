package com.bloodbank.model;

import java.util.Objects;

public class Donor {

	private String firstName;
	private String lastName;
	private String address;
	private Long adharcard;
	private long number;
	private int age;
	private String bloodType;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Donor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Donor(String firstName, String lastName, String address, Long adharcard, long number, int age,
			String bloodType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.adharcard = adharcard;
		this.number = number;
		this.age = age;
		this.bloodType = bloodType;
	}
	@Override
	public String toString() {
		return "Donor [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", adharcard="
				+ adharcard + ", number=" + number + ", age=" + age + ", bloodType=" + bloodType + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, adharcard, age, bloodType, firstName, lastName, number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Donor other = (Donor) obj;
		return Objects.equals(address, other.address) && Objects.equals(adharcard, other.adharcard) && age == other.age
				&& Objects.equals(bloodType, other.bloodType) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && number == other.number;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getAdharcard() {
		return adharcard;
	}
	public void setAdharcard(Long adharcard) {
		this.adharcard = adharcard;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
}
