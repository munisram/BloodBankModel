package com.bloodbank.model;

import java.util.Date;
import java.util.Objects;

public class RequestModel {
	
	private String hospitalName;
	private String bloodType;
	private int unit;
	private String bloodCollectorName;
	private Long phoneNumber;
	private Long adharcard;
	private Date requestDate;
	public RequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestModel(String hospitalName, String bloodType, int unit, String bloodCollectorName, Long phoneNumber,
			Long adharcard, Date requestDate) {
		super();
		this.hospitalName = hospitalName;
		this.bloodType = bloodType;
		this.unit = unit;
		this.bloodCollectorName = bloodCollectorName;
		this.phoneNumber = phoneNumber;
		this.adharcard = adharcard;
		this.requestDate = requestDate;
	}
	@Override
	public String toString() {
		return "RequestModel [hospitalName=" + hospitalName + ", bloodType=" + bloodType + ", unit=" + unit
				+ ", bloodCollectorName=" + bloodCollectorName + ", phoneNumber=" + phoneNumber + ", adharcard="
				+ adharcard + ", requestDate=" + requestDate + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(adharcard, bloodCollectorName, bloodType, hospitalName, phoneNumber, requestDate, unit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestModel other = (RequestModel) obj;
		return Objects.equals(adharcard, other.adharcard)
				&& Objects.equals(bloodCollectorName, other.bloodCollectorName)
				&& Objects.equals(bloodType, other.bloodType) && Objects.equals(hospitalName, other.hospitalName)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(requestDate, other.requestDate)
				&& unit == other.unit;
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
	public String getBloodCollectorName() {
		return bloodCollectorName;
	}
	public void setBloodCollectorName(String bloodCollectorName) {
		this.bloodCollectorName = bloodCollectorName;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Long getAdharcard() {
		return adharcard;
	}
	public void setAdharcard(Long adharcard) {
		this.adharcard = adharcard;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	

}
