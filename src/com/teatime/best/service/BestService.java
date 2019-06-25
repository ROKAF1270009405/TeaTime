package com.teatime.best.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.teatime.best.model.BestDAO;
import com.teatime.best.model.BestDTO;
import com.teatime.comm.DBConn;

public class BestService {
	private static BestService instance = new BestService();

	public static BestService getInstance() {
		return instance;
	}

	private BestService() {
	}

	public List<BestDTO> bestList(String kind, String startday, String endday) {
		DBConn db = DBConn.getdb();
		Connection conn = null;
		List<BestDTO> list = null;
		try {
			conn = db.getConnection();
			BestDAO dao = BestDAO.getDAO();
			list = dao.bestList(conn, kind, startday, endday);
		} catch (SQLException | NamingException e) {
			System.out.println(e);
		} finally {	
			if (conn != null) {	try {conn.close();} catch (SQLException e) {}}
		}
		return list;
	}


}
