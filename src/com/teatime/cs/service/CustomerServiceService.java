package com.teatime.cs.service;

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
	    	list = dao.getListData(conn, startrow, pagepercount);
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

	public void addService(CustomerServiceDTO dto) {

		DBConn db = DBConn.getdb();
		Connection conn = null;
		
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			CustomerServiceDAO dao = CustomerServiceDAO.getDAO();
			dao.addData(conn, dto);
			
			conn.commit();
			
		}catch (SQLException | NamingException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println(e1);
			}
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
		}
	}

	public CustomerServiceDTO detailService(int boardnum) {
		
		DBConn db = DBConn.getdb();
		Connection conn = null;
		CustomerServiceDTO data = new CustomerServiceDTO();
		
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			CustomerServiceDAO dao = CustomerServiceDAO.getDAO();
			dao.detailData(conn, boardnum);
			
			conn.commit();
			
		}catch (SQLException | NamingException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println(e1);
			}
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
		}
		
		return data;
	}
}
