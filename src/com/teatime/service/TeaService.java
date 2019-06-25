package com.teatime.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.teatime.comm.DBConn;
import com.teatime.dao.ReviewDAO;
import com.teatime.dao.ShopDAO;
import com.teatime.dto.ReviewDTO;
import com.teatime.dto.ShopDTO;

public class TeaService {
	private static TeaService instance = new TeaService();

	public static TeaService getInstance() {
		return instance;
	}

	private TeaService() {
	}

	public List<ShopDTO> bestList(String kind, String startday, String endday) {
		DBConn db = DBConn.getdb();
		Connection conn = null;
		List<ShopDTO> list = null;
		try {
			conn = db.getConnection();
			ShopDAO dao = ShopDAO.getDAO();
			list = dao.bestList(conn, kind, startday, endday);
		} catch (SQLException | NamingException e) {
			System.out.println(e);
		} finally {	
			if (conn != null) {	try {conn.close();} catch (SQLException e) {}}
		}
		return list;
	}


}
