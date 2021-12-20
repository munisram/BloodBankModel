package com.bloodbank.model;

import java.util.Objects;

public class BloodStack {
	private int quantity;
	private String bloodType;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bloodType, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BloodStack other = (BloodStack) obj;
		return Objects.equals(bloodType, other.bloodType) && quantity == other.quantity;
	}
	@Override
	public String toString() {
		return "BloodStack [quantity=" + quantity + ", bloodType=" + bloodType + "]";
	}
	public BloodStack(int quantity, String bloodType) {
		super();
		this.quantity = quantity;
		this.bloodType = bloodType;
	}
	public BloodStack() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
