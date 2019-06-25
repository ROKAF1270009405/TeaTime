package com.teatime.service;

import java.sql.Connection;
import java.util.List;

import com.teatime.dto.CustomerServiceDTO;

public class CustomerServiceService {

	private static CustomerServiceService instance = new CustomerServiceService();
	
	public static CustomerServiceService getInstance() {
		return instance;
	}

	private CustomerServiceService() {
		
	}

	public List<CustomerServiceDTO> ListService() {
		
		Connection conn=null;
	    List<CustomerServiceDTO> list=null;
		
		return null;
	}
}
