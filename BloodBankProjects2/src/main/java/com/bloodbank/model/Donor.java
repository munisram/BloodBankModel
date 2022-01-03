package com.bloodbank.model;

import java.util.Date;
import java.util.Objects;

public class Donor {

	private String firstName;
	private String lastName;
	private String address;
	private Long adharcard;
	private long number;
	private Date donorDate;
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
	public Date getDonorDate() {
		return donorDate;
	}
	public void setDonorDate(Date donorDate) {
		this.donorDate = donorDate;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, adharcard, bloodType, donorDate, firstName, lastName, number);
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
		return Objects.equals(address, other.address) && Objects.equals(adharcard, other.adharcard)
				&& Objects.equals(bloodType, other.bloodType) && Objects.equals(donorDate, other.donorDate)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& number == other.number;
	}
	@Override
	public String toString() {
		return "Donor [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", adharcard="
				+ adharcard + ", number=" + number + ", donorDate=" + donorDate + ", bloodType=" + bloodType + "]";
	}
	public Donor(String firstName, String lastName, String address, Long adharcard, long number, Date donorDate,
			String bloodType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.adharcard = adharcard;
		this.number = number;
		this.donorDate = donorDate;
		this.bloodType = bloodType;
	}
	public Donor() {
		super();
		// TODO Auto-generated constructor stub
	}

}
