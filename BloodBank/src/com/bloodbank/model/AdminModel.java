package com.bloodbank.model;

import java.util.Objects;

public class AdminModel {
	
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminModel other = (AdminModel) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}
	@Override
	public String toString() {
		return "AdminModel [email=" + email + ", password=" + password + "]";
	}
	public AdminModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public AdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}