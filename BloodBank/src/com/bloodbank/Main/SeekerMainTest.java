package com.bloodbank.Main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.bloodbank.Dao.BillingDao;
import com.bloodbank.Dao.BloodStackDao;
import com.bloodbank.Dao.RequestDao;
import com.bloodbank.Dao.SeekerDao;
import com.bloodbank.model.BillingModel;
import com.bloodbank.model.RequestModel;
import com.bloodbank.model.SeekerDetails;

public class SeekerMainTest {

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
    				System.out.println("enter the patient id:");
    				 temp1=scan.nextLine();
    				 if(temp1.isEmpty())
    				 {
    					 System.out.println("patient id can't be empty");
    				 }
    	               if(!temp1.matches("[0-9]{5,}")) {
    	            	   System.out.println("patient id can not be smaller than 5 ");
    	               }
    				}while(!temp.matches("[0-9]{5,}"));
    			
    			patientId=Long.parseLong(temp1);
                
                
    			do {
    				System.out.println("enter the hospitalName:");
    				
    				hospitalName=scan.nextLine();
    				 if(hospitalName.isEmpty())
    				 {
    					 System.out.println("hospitalName can't be empty");
    				 }
    				 if(!hospitalName.matches("[a-zA-Z]{5,}"))
    					{
    						System.out.println("hospitalNamecan't be smaller than 5 ");
    					}
    				}while(!hospitalName.matches("[a-zA-Z]{5,}"));
                
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
		
    			  
			  
    			  
    			  
    			  String temp2=null;
	    			do {
	    				System.out.println("enter the unit:");
	    				 temp2=scan.nextLine();
	    				 if(temp2.isEmpty())
	    				 {
	    					 System.out.println("unit can't be empty");
	    				 }
	    	               if(!temp2.matches("[0-9]{1}")) {
	    	            	   System.out.println("patient id can not be smaller than 1");
	    	               }
	    				}while(!temp2.matches("[0-9]{1}"));
	    			
	    			unit=Integer.parseInt(temp2);
    			  
	    			 SeekerDetails seeker=new SeekerDetails(firstName, lastName, address, phoneNumber, patientId, hospitalName, bloodType, unit);
	    			 SeekerDao seekerDao=new SeekerDao();
	    			tempNumber= seekerDao.insertSeekerDetails(seeker);
		
		    if(tempNumber>0) {
		    	System.out.println("register success ");
		    	
		    	
		    }
		    
		    System.out.println("\n1.send request  \n2.request cancel");
		    
		    choice=Integer.parseInt(scan.nextLine());
		    RequestModel reqModel=null;
		    switch(choice) {
		    case 1:
		    	System.out.println("request section");
		    	
		    	
		    	do {
					System.out.println("enter the Hospital Name:");
					
					 firstName=scan.nextLine();
					 if(firstName.isEmpty())
					 {
						 System.out.println("Hospital Name can't be empty");
					 }
					 if(!firstName.matches("[a-zA-Z]{5,}"))
						{
							System.out.println("Hospital Name can't be smaller than 5 ");
						}
					}while(!firstName.matches("[a-zA-Z]{5,}"));
		    	
		    	
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
		    	
		    	 
		    	do {
		    		System.out.println("enter the unit");
		    		temp=scan.nextLine();
		    		if(temp.isEmpty()) {
		    			System.out.println("unit can't empty");
		    			
		    		}
		    		if(!temp.matches("[0-9]{1}")){
		    			
		    			System.out.println("i don't to give blood unit above 9 ");
		    		}
		    		
		    	}while(!temp.matches("[0-9]{1}"));
		    	
		    	
		    	unit=Integer.parseInt(temp);
		    	
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
		    	
		    	
		    	
		    	 do {
						System.out.println("enter the blood Collector Name:");
						
						bloodCollectorName=scan.nextLine();
						 if(bloodCollectorName.isEmpty())
						 {
							 System.out.println("blood Collector Name  can't be empty");
						 }
						 if(!bloodCollectorName.matches("[a-zA-Z]{5,}"))
							{
								System.out.println("blood  Collector  Name can't be smaller than 5 ");
							}
						}while(!bloodCollectorName.matches("[a-zA-Z]{5,}"));
		    	
		 		    	
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
		    	
		    	reqModel=new RequestModel(hospitalName, bloodType, unit, bloodCollectorName, phoneNumber, adharcard);
		    	
		    	RequestDao reqDao=new RequestDao();
		    	
		    	tempNumber=reqDao.insertRequest(reqModel);
		    	
		    	if(tempNumber>0) {
		    		
		    		System.out.println("request booking success");
		    		
		    		
		    	}
		    	
		    	System.out.println("billing process");
		    	
		    	SeekerDao dao=new SeekerDao();
		    	
		    	
		    	
		    	
		    	BloodStackDao bloodStockDao=new BloodStackDao();
		    	
		    	SeekerDao seekerDao1=new SeekerDao();
		    	
		    	SeekerDetails seeker1=seekerDao1.seekerObject(reqModel.getBloodType(), reqModel.getHospitalName());
                  int seekerId=dao.seekerIdFind(seeker1);
		    	
		    	//dao.seekerIdFind(reqModel.getBloodType(), reqModel.getHospitalName());
		    	// seekerDao1.seekerIdFind(seeker1);
		    	 
		    	int price=bloodStockDao.findPrice(reqModel.getBloodType());
		    	
		    	int currentUnit=reqModel.getUnit();
		    	int totalPrice=currentUnit*price;
		    	
		    	
		    	BillingModel bDao1=new BillingModel(reqModel.getBloodType(),seeker1, reqModel.getUnit(),totalPrice);
		    	BillingDao billingDao=new BillingDao();
		    	int n=billingDao.insertBilling(bDao1);
		    	if(n>0) {
		    		System.out.println("billing success");
		    	}
		    	BloodStackDao stackDao=new BloodStackDao();
		    	
		    	if(stackDao.checkOfQuantity(reqModel.getBloodType())>reqModel.getUnit())
		    	{
		    		
		    		stackDao.updateStackReduce(reqModel.getBloodType(),reqModel.getUnit());
		    		System.out.println("Welcome Again");
		    		
		    	}
		    	else
		    	{
		    		System.out.println("Stock not available");
		    	}
//		    	stackDao.FindBlood(reqModel.getBloodType());
		    	
		    	
		    	
		    	
		    	
		    
		    break;
		    
		    case 2:
		    	System.out.println("cancelation");
		    	
		    	
		    	RequestDao reqDao1=new RequestDao();
		    	
		    	tempNumber=reqDao1.deleteRequest(reqModel.getAdharcard());
		    	
		    	if(tempNumber>0) {
		    		
		    		
		    		System.out.println("request cancel conform");
		    	}
		    	
		    	
		    	break;
		    
		  			    
		    
		    
		    }
	}

}
