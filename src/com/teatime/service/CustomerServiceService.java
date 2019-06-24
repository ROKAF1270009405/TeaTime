package com.teatime.service;

public class CustomerServiceService {

	private static CustomerServiceService instance = new CustomerServiceService();
	
	public static CustomerServiceService getInstance() {
		return instance;
	}

	private CustomerServiceService() {
		
	}
}
