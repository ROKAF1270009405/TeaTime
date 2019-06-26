package com.teatime.detail.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.teatime.comm.DBConn;
import com.teatime.detail.model.DetailDAO;
import com.teatime.shop.model.ShopDTO;

public class DetailService {
	
	private static DetailService service = new DetailService();
	public static DetailService getService() {
		return service;
	}

	public ShopDTO detailService(int shopno) {
		ShopDTO result = new ShopDTO();
		DBConn db = DBConn.getdb();
		Connection conn = null;
		System.out.println("서비스 : "+shopno);
		
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			DetailDAO dao = DetailDAO.getDAO();
			result = dao.detail(conn, shopno);
			conn.commit();
		}catch(SQLException e) {
			try {conn.rollback();} catch(SQLException e2) {}
		}catch(NamingException e) {
			System.out.println(e);
		}finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return result;
	}
	
}
