package com.teatime.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.teatime.comm.DBConn;
import com.teatime.cs.model.CustomerServiceDAO;
import com.teatime.cs.model.CustomerServiceDTO;

public class CustomerServiceService {

	private static CustomerServiceService instance = new CustomerServiceService();
	
	public static CustomerServiceService getInstance() {
		return instance;
	}

	private CustomerServiceService() {
		
	}

	public List<CustomerServiceDTO> getList(int startrow, int pagepercount) {	//자료 목록 가져옴
		
		Connection conn=null;
	    List<CustomerServiceDTO> list=null;
	    
	    try {
	    	DBConn db = DBConn.getdb();
	    	conn = db.getConnection();
	    	
	    	CustomerServiceDAO dao = CustomerServiceDAO.getDAO();
	    	System.out.println("dddd");
	    	list = dao.getListData(conn, startrow, pagepercount);
	    	System.out.println("사이즈:"+list.size());
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
		
		DBConn db = DBConn.getdb();
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
