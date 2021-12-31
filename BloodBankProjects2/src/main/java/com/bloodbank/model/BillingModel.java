package com.bloodbank.model;

import java.util.Objects;

public class BillingModel {
	private String bloodType;
	private SeekerDetails seeker;
	private int unit;
	private double totalprice;
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public SeekerDetails getSeeker() {
		return seeker;
	}
	public void setSeeker(SeekerDetails seeker) {
		this.seeker = seeker;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bloodType, seeker, totalprice, unit);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillingModel other = (BillingModel) obj;
		return Objects.equals(bloodType, other.bloodType) && Objects.equals(seeker, other.seeker)
				&& Double.doubleToLongBits(totalprice) == Double.doubleToLongBits(other.totalprice)
				&& unit == other.unit;
	}
	@Override
	public String toString() {
		return "BillingModel [bloodType=" + bloodType + ", seeker=" + seeker + ", unit=" + unit + ", totalprice="
				+ totalprice + "]";
	}
	public BillingModel(String bloodType, SeekerDetails seeker, int unit, double totalprice) {
		super();
		this.bloodType = bloodType;
		this.seeker = seeker;
		this.unit = unit;
		this.totalprice = totalprice;
	}
	public BillingModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
