package com.bloodbank.model;

import java.util.Objects;

public class BloodDetailsModel {
	private Long adharcard;
	private int unit;
	private String bloodType;
	private int price;
	public BloodDetailsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BloodDetailsModel(Long adharcard, int unit, String bloodType, int price) {
		super();
		this.adharcard = adharcard;
		this.unit = unit;
		this.bloodType = bloodType;
		this.price = price;
	}
	@Override
	public String toString() {
		return "BloodDetailsModel [adharcard=" + adharcard + ", unit=" + unit + ", bloodType=" + bloodType + ", price="
				+ price + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(adharcard, bloodType, price, unit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BloodDetailsModel other = (BloodDetailsModel) obj;
		return Objects.equals(adharcard, other.adharcard) && Objects.equals(bloodType, other.bloodType)
				&& price == other.price && unit == other.unit;
	}
	public Long getAdharcard() {
		return adharcard;
	}
	public void setAdharcard(Long adharcard) {
		this.adharcard = adharcard;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
