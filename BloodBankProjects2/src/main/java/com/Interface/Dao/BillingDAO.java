package com.Interface.Dao;

import java.util.List;

import com.bloodbank.model.BillingModel;

public interface BillingDAO {
		
	public int insertBilling(BillingModel bill );	
	public List<BillingModel> biilingShow( BillingModel bill);
	
	

}
