package com.bloodbank.model;

import java.util.Objects;

public class SeekerDetails {
	private String firstName;
	private String lastName;
	private String address;
	private Long phoneNumber;
	private Long  patientId;
	private String hospitalName;
	private String bloodType;
	private int unit;
	public SeekerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SeekerDetails(String firstName, String lastName, String address, Long phoneNumber, Long patientId,
			String hospitalName, String bloodType, int unit) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.patientId = patientId;
		this.hospitalName = hospitalName;
		this.bloodType = bloodType;
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "Seeker [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", patientId=" + patientId + ", hospitalName=" + hospitalName + ", bloodType="
				+ bloodType + ", unit=" + unit + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, bloodType, firstName, hospitalName, lastName, patientId, phoneNumber, unit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeekerDetails other = (SeekerDetails) obj;
		return Objects.equals(address, other.address) && Objects.equals(bloodType, other.bloodType)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(hospitalName, other.hospitalName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(patientId, other.patientId)
				&& Objects.equals(phoneNumber, other.phoneNumber) && unit == other.unit;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	
	

}
