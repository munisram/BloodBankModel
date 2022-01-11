package com.bloodbank.Dao;

import java.util.Date;
import java.util.List;

import com.bloodbank.model.BookingModel;
import com.bloodbank.model.Donor;

public interface BookingDAO {

	public int  booking(BookingModel book);
	
	 public int updateBooking(BookingModel book);
	
	
	 public int deleteBooking(Long adharcard);
	
	 public List<BookingModel> HomeCollection();
	
	 public Date dateCheck(Donor donor);
	
	 public int updateDateForDonor(BookingModel book);
	 public List<BookingModel> ShowBookingAdmin();
	
	
	
	
	
}
