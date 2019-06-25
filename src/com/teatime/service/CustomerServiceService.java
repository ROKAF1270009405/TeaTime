package com.teatime.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.teatime.dao.CustomerServiceDAO;
import com.teatime.dto.CustomerServiceDTO;
import com.teatime.util.DBConnection;

public class CustomerServiceService {

	private static CustomerServiceService instance = new CustomerServiceService();
	
	public static CustomerServiceService getInstance() {
		return instance;
	}

	private CustomerServiceService() {
		
	}

	public List<CustomerServiceDTO> getList(int startrow, int endrow) {	//자료 목록 가져옴
		
		Connection conn=null;
	    List<CustomerServiceDTO> list=null;
	    
	    try {
	    	DBConnection db = DBConnection.getDB();
	    	conn = db.getConnection();
	    	
	    	CustomerServiceDAO dao = CustomerServiceDAO.getDAO();
	    	
	    	list = dao.getListData(conn, startrow, endrow);
	    	
	    }catch(SQLException | NamingException | RuntimeException e) {
	    	System.out.println(e);
	    	try {
				conn.rollback();
			} catch (SQLException e1) {
			}
	    } finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		
		return list;
	}

	public int getCount() { // 자료 갯수를 가져옴
		
		DBConnection db = DBConnection.getDB();
		Connection conn = null;
		int datacount = 0;
		
		try {

			conn = db.getConnection();
			CustomerServiceDAO dao = CustomerServiceDAO.getDAO();
			datacount = dao.getCount(conn);

		} catch (SQLException | NamingException e) {
			System.out.println(e);
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
		}
		return datacount;
	}
}
