package com.bloodbank.exception;

public class ExeceptionHandle extends Exception{
	
public String DonorMessage() {	
	
	
	
	return "*Invalid aadharcard Number";
}
	
	
	
public String SeekerMessage() {
	
	
	
	
	return "*Invalid PhoneNumber and password";
}
	


public String AdminMessage() {




return "*Invalid Email Id and password";

}

public String ForgetPassword() {




return "*Two password  must same";

}

public String PhoneNumber() {
	
	return "*Phone number already register";
}
public String AadharcardNumber() {
	
	return "*Phone number already register";
} 


public String HomeCollection() {
	
	return "No one choice the Home";
	
	
}
}
