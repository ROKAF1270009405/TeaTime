package com.teatime.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.teatime.dto.CustomerServiceDTO;

public class CustomerServiceDAO {

	private static CustomerServiceDAO dao = new CustomerServiceDAO();

	public static CustomerServiceDAO getDAO() {
		
		
		return dao;
	}

	private CustomerServiceDAO() {

	}

	public List<CustomerServiceDTO> getListData(Connection conn, int startrow, int endrow) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCount(Connection conn) throws SQLException {
		
		
		
		return 0;
	}
	
}
