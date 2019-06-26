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
		//System.out.println("베스트 서비스 진입");
		try {
			conn = db.getConnection();
			BestDAO dao = BestDAO.getDAO();
			//System.out.println("베스트 DAO 간다..");
			list = dao.bestList(conn, kind, startday, endday);
			//System.out.println("DAO 갔다가 베스트 서비스로 돌아왔다.");
		} catch (SQLException | NamingException e) {
			System.out.println(e);
		} finally {	
			if (conn != null) {	try {conn.close();} catch (SQLException e) {}}
		}
		//System.out.println("베스트 서비스에서 액션으로 돌아간다아!!!");
		return list;
	}


}
