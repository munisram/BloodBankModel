package com.bloodbank.Main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.bloodbank.Dao.AdminModelDao;
import com.bloodbank.Dao.BillingDao;
import com.bloodbank.Dao.BloodStackDao;
import com.bloodbank.Dao.BookingDao;
import com.bloodbank.Dao.RequestDao;
import com.bloodbank.model.AdminModel;
import com.bloodbank.model.BillingModel;
import com.bloodbank.model.BloodStack;
import com.bloodbank.model.BookingModel;

public class AdminMainTest {

	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
		Scanner scan=new Scanner(System.in);
		String firstName=null;
		String lastName=null;
		String  address=null;
		Long adharcard=null;
		Long phoneNumber=null;
		int age=0;
		String bloodType=null;
		String date=null;
		int userChoice=0;
		int tempNumber=0;
		int ifNumber=0;
		Date bookDate=null;
		int choice=0;
		String bloodCollectorName=null;
		Long patientId=null;
		String hospitalName=null;
		int unit=0;
		
		System.out.println("welcome");
		System.out.println("admin process");
		
		String email=null;
		String password=null;
		
		do {
			System.out.println("enter emailId:");
			email = scan.nextLine();
			if (!email.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+")) {
				System.out.println("email must include upper&special character");
			}
			if (email.isEmpty()) {
				System.out.println("email cant be empty");
			}

		} while (!email.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]+") || email.isEmpty());

		do {
			System.out.println("enter password");
			password = scan.nextLine();
			if (!password.matches("[A-Za-z0-9@#.!&]{8,16}")) {
				System.out.println("password must include 8 or 16 character");
			}
			if (password.isEmpty()) {
				System.out.println("password should be 8 character");
			}
		} while (!password.matches("[A-Za-z0-9@#.!&]{8,16}") || password.isEmpty());
		
		
		AdminModel adminModel=new AdminModel(email, password,0);
		
		AdminModelDao adminDao=new AdminModelDao();
		adminModel=adminDao.verificationAdmin(adminModel);
		
		if(!adminModel.equals(null)) {
			System.out.println("verification success");
		}
		System.out.println("\n1.show Stock \n2.show billing \n3.request cancel \n4.booking cancel \n5.Home collection");
		
		int adminChioce=Integer.parseInt(scan.nextLine());
		switch(adminChioce) {
		case 1:
			System.out.println("blood stocks");
			BloodStackDao stockDao=new BloodStackDao();
			List<BloodStack> bloodStackList =new ArrayList<BloodStack>();
					bloodStackList=stockDao.showStack();
					for(int i=0;i<bloodStackList.size();i++) {
						System.out.println(bloodStackList.get(i));
					}
			
			break;
		case 2:
			System.out.println("billing ");
			BillingDao billingDao=new BillingDao();
			List<BillingModel>billingList=new ArrayList<BillingModel>();
			
			billingList= billingDao.biilingShow();
			for(int i=0;i<billingList.size();i++) {
			System.out.println(billingList.get(i));
			}
			
			break;
		case 3:
		
			System.out.println("enter the adharcard number of seeker");
			adharcard =Long.parseLong(scan.nextLine());
			
			RequestDao RequestDao=new RequestDao();
			tempNumber=RequestDao.deleteRequest(adharcard);
			if(tempNumber>0) {
				System.out.println("request cancel");
			}
			
			break;
		case 4:
			
			BookingDao bookingDao=new BookingDao();
			System.out.println("enter the donor adharcard number ");
			Long adharcard1=Long.parseLong(scan.nextLine());
		
			tempNumber=bookingDao.deleteBooking(adharcard1);
			if(tempNumber>0) {
				System.out.println("booking cancel");
			}
			break;
		case 5:
			System.out.println("collecting blood from donor Home");
			 BookingDao bookingDao1=new BookingDao();
			 
			 List<BookingModel>bookingList=new ArrayList<BookingModel>();
			 
			 bookingList=bookingDao1.HomeCollection();
			 
			 for(int i=0;i<bookingList.size();i++) {
				 
				System.out.println(bookingList.get(i));			 
				 
			 }
			
			break;
		}
	}

}