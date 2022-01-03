package com.bloodbank.Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.Interface.Dao.DonorDAO;
import com.bloodbank.Dao.AdminDAOlmpl;
import com.bloodbank.Dao.BloodDetailsDAOlmpl;
import com.bloodbank.Dao.BloodStackDAOlmpl;
import com.bloodbank.Dao.BookingDAOlmpl;
import com.bloodbank.Dao.DonorDAOImpl;
import com.bloodbank.Dao.SeekerDAOlmpl;
import com.bloodbank.model.AdminModel;
import com.bloodbank.model.BloodDetailsModel;
import com.bloodbank.model.BloodStack;
import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;
import com.bloodbank.model.SeekerDetails;

public class UserMainTest {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Scanner scan = new Scanner(System.in);
		String firstName = null;
		String lastName = null;
		String address = null;
		Long adharcard = null;
		Long phoneNumber = null;
		int age = 0;
		String bloodType = null;
		String date = null;
		int userChoice = 0;
		int tempNumber = 0;
		int ifNumber = 0;
		Date bookDate = null;
		int choice = 0;
		String bloodCollectorName = null;
		Long patientId = null;
		String hospitalName = null;
		int unit = 0;

		System.out.println("welcome");

		String temp3 = null;
		do {
			System.out.println("enter the adharcard number");
			temp3 = scan.nextLine();
			if (temp3.isEmpty()) {
				System.out.println("adharcard number can't be empty");
			}
			if (!temp3.matches("[0-9]{12}")) {
				System.out.println("adharcard number 12 digit");

			}
		} while (!temp3.matches("[0-9]{12}"));
		
		adharcard = Long.parseLong(temp3);

		DonorDAOImpl donorDao = new  DonorDAOImpl();
		Donor donor = donorDao.validAdharcardNumber(adharcard);
		if (donor != null) {

			System.out.println("verification success");
			do {
				System.out.println("\n1.donor booking \n 2.user Edit\n3.logout");

				userChoice = Integer.parseInt(scan.nextLine());
				BookingModel booking = null;
				BookingDAOlmpl bookDao = new BookingDAOlmpl();
				switch (userChoice) {

				case 1:

					System.out.println("booking");

					try {
						String tempDate;

						do {

							System.out.println("enter the date");
							tempDate = scan.nextLine();

							if (tempDate.isEmpty()) {

								System.out.println("Date is mandatory");
							}
							if (!tempDate.matches("(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]\\d{4}")) {

								System.out.println("Date format 'dd/MM/yyyy'");

							}

						} while (!tempDate.matches("(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]\\d{4}"));

						bookDate = sdf.parse(tempDate);

						do {
							System.out.println("enter the Address:");
							address = scan.nextLine();
							if (address.isEmpty()) {
								System.out.println("address can't be empty");
							}
							if (!address.matches("[a-zA-Z0-9,/]{10,}")) {
								System.out.println("address can not be smaller than 10");
							}
						} while (!address.matches("[a-zA-Z0-9,/]{10,}"));

						
						String center = null;

						BookingModel book = null;
					
							System.out.println("address for home or center");
							
							
							center = scan.nextLine();

							Donor donor1 = donorDao.validAdharcardNumber(donor.getAdharcard());

							//System.out.println(donor1.getBloodType());
							SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
                              Date date1=bookDao.dateCheck(donor1);
                              if(date1!=null && bookDate.after(date1)) {
							//System.out.println(date1);
							//System.out.println(sd.format(bookDate));
							
								
								System.out.println("welcome");
							
							
							
							
							BookingModel book1 = new BookingModel(donor1, address, bookDate, donor1.getBloodType(),center);
							
							
							tempNumber = bookDao.booking(book1);

							donorDao=new DonorDAOImpl();
							

							if (tempNumber > 0) {
								System.out.println("booking success ");
							}
							
							
                              
							bookDao.updateDateForDonor(book1);
							
							}else if(date1==null)
							{
								
								System.out.println("welcome");
								
								
								
								
								BookingModel book1 = new BookingModel(donor1, address, bookDate, donor1.getBloodType(),center);
								
								
								tempNumber = bookDao.booking(book1);

								donorDao=new DonorDAOImpl();
								
							}
							else
							{
								System.out.println("See you later");
							}
							

					} catch (ParseException e) {
						e.printStackTrace();
					}

					
					System.out.println("\n 1.booking change \n2.booking cancel \n 3.conformation");

					tempNumber = Integer.parseInt(scan.nextLine());
					Donor donor1 = donorDao.validAdharcardNumber(donor.getAdharcard());
					switch (tempNumber) {

					case 1:

						do {
							System.out.println("enter the Address:");
							address = scan.nextLine();
							if (address.isEmpty()) {
								System.out.println("address can't be empty");
							}
							if (!address.matches("[a-zA-Z0-9,/]{10,}")) {
								System.out.println("address can not be smaller than 10");
							}
						} while (!address.matches("[a-zA-Z0-9,/]{10,}"));

						String tempDate1 = null;
						try {

							System.out.println("enter the date");
							tempDate1 = scan.nextLine();
							if (tempDate1.isEmpty()) {
								System.out.println("Date is mandatory");
							}
							if (!tempDate1.matches("(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]\\d{4}")) {
								System.out.println("Date format 'dd-mm-yyyy'");

							}
							while (!tempDate1.matches("(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]\\d{4}"))
								;

							bookDate = sdf.parse(tempDate1);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						String center = null;

						BookingModel book = null;
						System.out.println("address for home or center");
							center = scan.nextLine();

							donor1 = donorDao.validAdharcardNumber(donor.getAdharcard());

							book = new BookingModel(donor1, address, bookDate, donor.getBloodType(), center);

							tempNumber = bookDao.updateBooking(book);
							if (tempNumber > 0) {
								System.out.println("booking change");
							}

						
							break;
							
			case 2:
		
		
		System.out.println("\n1.booking cancel");
		ifNumber=Integer.parseInt(scan.nextLine());
		if(ifNumber==1) {
			
					System.out.println("enter the adharcard Number");
							adharcard=Long.parseLong(scan.nextLine());
			 tempNumber=bookDao.deleteBooking(adharcard);
			 
			if(tempNumber>0) {
				System.out.println("booking cancel success");
			}
		}			
		break;
		
		
		
		
		
					case 3:
						int alcohol = 0;
						System.out.println("enter the blood pressure");
						int bloodPressure = Integer.parseInt(scan.nextLine());
						if (bloodPressure < 180) {
							System.out.println("have you consume  Alcohol before 24 hours \n1.yes \n 2.no");
							alcohol = Integer.parseInt(scan.nextLine());

							if (alcohol == 2) {

								unit = 1;
								int price = 200;

								//Donor donor2 = donorDao.validNumber(donor.getNumber());
                        
								//System.out.println(donor1.getAge());
								
								BloodDetailsModel details = new BloodDetailsModel(donor1, unit,donor1.getBloodType(),price);
								
								BloodDetailsDAOlmpl detailDao = new BloodDetailsDAOlmpl();
								
								tempNumber = detailDao.insertBloodDetails(details);

								if (tempNumber > 0) {
									BloodStack stack = null;
									System.out.println("donation conform\\n you next donate blood in after 90days");

									BloodStackDAOlmpl stackDao = new BloodStackDAOlmpl();

									stack = new BloodStack(details.getUnit(), details.getBloodType(), price);

									stackDao.showStack();

									int check = stackDao.updateStack(stack);

									if (check > 0) {
										System.out.println("stack update");
									}
									AdminDAOlmpl adminDao=new AdminDAOlmpl();
									AdminModel admin=new AdminModel();
									 admin=adminDao.updateWallet();
									
									if(admin!=null)
									{
									System.out.println("payment success");
										
										
									}

								}

							} else {
								System.out.println("not allowed");
							}

						} else {
							System.out.println("not allowed ");
						}
					}
					break;

				case 2:

					System.out.println("enter address");
					donor.setAddress(scan.nextLine());
					String temp1 = null;

					do {
						System.out.println("enter the age");
						temp1 = scan.nextLine();
						if (temp1.isEmpty()) {
							System.out.println("age can't be empty");
						}

						if (!temp1.matches("[0-9]{1,2}")) {
							System.out.println("age can not be more then 2 ");
						}

					} while (!temp1.matches("[0-9]{1,2}"));
					age = Integer.parseInt(temp1);
					if (age < 45) {

						donor.setAge(age);

						String temp = null;
						do {
							System.out.println("enter the phone  Number:");
							temp = scan.nextLine();
							if (temp.isEmpty()) {
								System.out.println("phone number can't be empty");
							}
							if (!temp.matches("[0-9]{10}")) {
								System.out.println("phone number can not be smaller than 10 ");
							}
						} while (!temp.matches("[0-9]{10}"));

						donor.setNumber(Long.parseLong(temp));
						// donor=new Donor();
						DonorDAOImpl dao = new DonorDAOImpl();
						tempNumber = dao.updateDonor(donor);
						if (tempNumber > 0) {
							System.out.println("update success");
						}
					} else {
						System.out.println("not applicaple for donate blood");
					}
					break;

				}
			} while (userChoice < 3);

		}else {
			
			
			System.out.println("register page");
			do {
		System.out.println("enter the first Name:");
		
		 firstName=scan.nextLine();
		 if(firstName.isEmpty())
		 {
			 System.out.println("first name can't be empty");
		 }
		 if(!firstName.matches("[a-zA-Z]{3,}"))
			{
				System.out.println("first name can't be smaller than 3 ");
			}
		}while(!firstName.matches("[a-zA-Z]{3,}"));
				
		
		do {
			System.out.println("enter the last Name:");
			 lastName=scan.nextLine();
			 if(lastName.isEmpty())
			 {
				 System.out.println("last name can't be empty");
			 }
			if(!lastName.matches("[a-zA-Z]{3,}"))
			{
				System.out.println("last name can't be smaller than 3");
			}
			}while(!lastName.matches("[a-zA-Z]{3,}"));
		
		do {
			System.out.println("enter the Address:");
			 address=scan.nextLine();
			 if(address.isEmpty())
			 {
				 System.out.println("address can't be empty");
			 }
			 if(!address.matches("[a-zA-Z0-9,/]{10,}"))
				{
					System.out.println("address can not be smaller than 10");
				}
			}while(!address.matches("[a-zA-Z0-9,/]{10,}"));
		
		String temp4=null;
		do {
			System.out.println("enter the adharcard number");
			temp4=scan.nextLine();
			 if(temp4.isEmpty())
			 {
				 System.out.println("adharcard number can't be empty");
			 }
			if(!temp4.matches("[0-9]{12}")) {
				System.out.println("adharcard number 12 digit");
				
			}
		}while (!temp4.matches("[0-9]{12}"));
		adharcard=Long.parseLong(temp4);
		
		String temp=null;
		do {
			System.out.println("enter the phone  Number:");
			 temp=scan.nextLine();
			 if(temp.isEmpty())
			 {
				 System.out.println("phone number can't be empty");
			 }
               if(!temp.matches("[0-9]{10}")) {
            	   System.out.println("phone number can not be smaller than 10 ");
               }
			}while(!temp.matches("[0-9]{10}"));
		
                phoneNumber=Long.parseLong(temp);
                
           String temp1=null;
          
           do {
        	   System.out.println("enter the age");
        	   temp1=scan.nextLine();
        	   if(temp1.isEmpty())
  			 {
  				 System.out.println("age can't be empty");
  			 }
        	   
        	   if(!temp1.matches("[0-9]{1,2}")) {
        		   System.out.println("age can not be more then 2 ");
        		     }
        	   
           }while(!temp1.matches("[0-9]{1,2}"));
           
           age=Integer.parseInt(temp1);
           if(age>17) {
           
           do {
        	   System.out.println("enter the blood type");
        	   bloodType=scan.nextLine();
        	   if(bloodType.isEmpty())
  			 {
  				 System.out.println("blood type can't be empty");
  			 }
        	   if(!bloodType.matches("([aboABO]|[aA][bB])[+|-]"))
        	   
        	   System.out.println("blood type can not be enter than exampe A-,ab-");
        	   
           }while(!bloodType.matches("([aboABO]|[aA][bB])[+|-]"));
           
           
           Donor donor1=new Donor(firstName, lastName, address,  adharcard,phoneNumber, age, bloodType);
           DonorDAOImpl dao=new DonorDAOImpl();
        		   dao.insertDonor(donor1);
        	  
        		   
        		   
           }else {
        	   System.out.println("not applicaple to donate blood");
           }

}

		
		
		
		
		
		
		
		
		
		
		
	}
}
