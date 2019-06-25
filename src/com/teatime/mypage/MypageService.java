package com.teatime.mypage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.teatime.comm.DBConn;
import com.teatime.member.MemberDTO;

public class MypageService {

	// singleton pattern
	private static MypageService service = new MypageService();

	private MypageService() {

	}

	public static MypageService getInstance() {
		return service;
	}

	// memberListService
	public List<MemberDTO> memberListService() {

		Connection conn = null;
		List<MemberDTO> list = null;

		try {
			DBConn db = DBConn.getdb();
			conn = db.getConnection();
			MypageDAO dao = MypageDAO.getDAO();
			list = dao.getMemberList(conn);
		} catch (SQLException | NamingException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return list;
	} // end memberListService method

} // end MypageService class
