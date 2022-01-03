package com.Interface.Dao;

import com.bloodbank.model.SeekerDetails;

public interface SeekerDAO  {
	
	public int insertSeekerDetails( SeekerDetails details);
	
	
	public int seekerIdFind(SeekerDetails seeker);
	
	public SeekerDetails seekerObject(String password, Long phoneNumber);
	
	public SeekerDetails SeekerFindId(int seekerId);
	
	
	
	
	
	
	
	
	
}
