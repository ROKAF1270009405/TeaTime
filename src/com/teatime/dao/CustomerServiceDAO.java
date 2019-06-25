package com.teatime.dao;

public class CustomerServiceDAO {

	private static CustomerServiceDAO dao = new CustomerServiceDAO();

	public static CustomerServiceDAO getDAO() {
		return dao;
	}

	private CustomerServiceDAO() {

	}
	
}
