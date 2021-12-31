package com.Interface.Dao;

import com.bloodbank.model.SeekerDetails;

public interface SeekerDAO  {
	
	public int insertSeekerDetails( SeekerDetails details);
	
	
	public int seekerIdFind(SeekerDetails seeker);
	
	public SeekerDetails seekerObject(String bloodType, String hospital);
	
	public SeekerDetails SeekerFindId(int seekerId);
	
	
	
	
	
	
	
	
	
}
