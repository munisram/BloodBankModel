package com.bloodbank.model;

import java.util.Date;
import java.util.Objects;

public class BookingModel {

	private Long adharcard;
	private String address;
	private Date appdate;
	private  String bloodType;
	public BookingModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingModel(Long adharcard, String address, Date appdate, String bloodType) {
		super();
		this.adharcard = adharcard;
		this.address = address;
		this.appdate = appdate;
		this.bloodType = bloodType;
	}
	@Override
	public String toString() {
		return "BookingModel [adharcard=" + adharcard + ", address=" + address + ", appdate=" + appdate + ", bloodType="
				+ bloodType + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, adharcard, appdate, bloodType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingModel other = (BookingModel) obj;
		return Objects.equals(address, other.address) && Objects.equals(adharcard, other.adharcard)
				&& Objects.equals(appdate, other.appdate) && Objects.equals(bloodType, other.bloodType);
	}
	public Long getAdharcard() {
		return adharcard;
	}
	public void setAdharcard(Long adharcard) {
		this.adharcard = adharcard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getAppdate() {
		return appdate;
	}
	public void setAppdate(Date appdate) {
		this.appdate = appdate;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
}