package com.Interface.Dao;

import java.util.List;

import com.bloodbank.model.Donor;

public interface DonorDAO {
	
	
	public Donor validNumber(Long number);

	public int insertDonor(Donor donor);
	
	public int updateDonor(Donor donor);
	
	public List<Donor> showDonor();
	
	public Long adharcardNumber(Donor donor);
	
	public Donor validAdharcardNumber(Long adharcard);
}
