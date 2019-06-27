package com.teatime.mypage.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.teatime.comm.DBConn;
import com.teatime.member.MemberDTO;
import com.teatime.mypage.model.MypageDAO;
import com.teatime.mypage.model.MypageDTO;

public class MypageService {

	// singleton pattern
	private static MypageService service = new MypageService();

	private MypageService() {

	}

	public static MypageService getInstance() {
		return service;
	}
	
	// 리뷰 가져오기
	public List<MypageDTO> reviewService() {
		
		Connection conn = null;
		List<MypageDTO> list = null;
		try {
			DBConn db = DBConn.getdb();
			conn = db.getConnection();
			MypageDAO dao = MypageDAO.getDAO();
			list = dao.getReview(conn, dto);
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
	} // end reviewService method

/*	// memberListService
	public List<MemberDTO> memberListService(MemberDTO dto) {

		Connection conn = null;
		List<MemberDTO> list = null;

		try {
			DBConn db = DBConn.getdb();
			conn = db.getConnection();
			MypageDAO dao = MypageDAO.getDAO();
			list = dao.getMemberList(conn, dto);

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
*/
} // end MypageService class
