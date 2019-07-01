package com.teatime.mypage.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.teatime.comm.DBConn;
import com.teatime.member.MemberDTO;
import com.teatime.mypage.model.MypageDAO;
import com.teatime.mypage.model.MypageDTO;
import com.teatime.review.model.ReviewDTO;

public class MypageService {

	// singleton pattern
	private static MypageService service = new MypageService();

	private MypageService() {

	}

	public static MypageService getInstance() {
		return service;
	}

	// 리뷰 가져오기
	public List<MypageDTO> reviewService(MemberDTO dto) {

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
	
	// modify용 method
	public ReviewDTO modiService(int reviewno) {
		
		Connection conn = null;
		ReviewDTO dto = new ReviewDTO(); 
		try {
			DBConn db = DBConn.getdb();
			conn = db.getConnection();
			MypageDAO dao = MypageDAO.getDAO();
			dto = dao.getModiReview(conn, reviewno);
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
		return dto;
		
	} // end modiService method

	// 수정하기
	public int modifyService(ReviewDTO dto) {

		Connection conn = null;
		int result = 0;

		try {
			DBConn db = DBConn.getdb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			MypageDAO dao = MypageDAO.getDAO();
			result = dao.modifyreview(conn, dto);
			conn.commit();
		} catch (SQLException | NamingException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return result;
	} // end modifyService method

	// 삭제하기
	public int deleteService(int num) {

		Connection conn = null;
		int result = 0;

		try {
			System.out.println("여기 Service인데 들어올 수 있나요?");
			DBConn db = DBConn.getdb();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			MypageDAO dao = MypageDAO.getDAO();
			result = dao.deletereview(conn, num);
			conn.commit();
		} catch (SQLException | NamingException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		} finally {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return result;
	} // end deleteService method

	/*
	 * // memberListService public List<MemberDTO> memberListService(MemberDTO dto)
	 * {
	 * 
	 * Connection conn = null; List<MemberDTO> list = null;
	 * 
	 * try { DBConn db = DBConn.getdb(); conn = db.getConnection(); MypageDAO dao =
	 * MypageDAO.getDAO(); list = dao.getMemberList(conn, dto);
	 * 
	 * } catch (SQLException | NamingException e) {
	 * System.out.println(e.getMessage()); } finally { if (conn != null) { try {
	 * conn.close(); } catch (SQLException e) { System.out.println(e.getMessage());
	 * } } } return list; } // end memberListService method
	 */
	
} // end MypageService class
