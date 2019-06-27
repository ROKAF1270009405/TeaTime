package com.teatime.review.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.teatime.comm.DBConn;
import com.teatime.review.model.ReviewDAO;
import com.teatime.review.model.ReviewDTO;

public class ReviewService {
	// 싱글톤 패턴 -> 객체 생성하지 안고 바로 객체 가져올 수 있음. 구성요소 ( 생성자, get)
	private static ReviewService instance = new ReviewService();

	public static ReviewService getInstance() {
		return instance;
	}

	private ReviewService() {
	}

	public List<ReviewDTO> getList(int shopno) {
		DBConn db = DBConn.getdb();
		Connection conn = null;
		List<ReviewDTO> list = new ArrayList<>();
		try {
			conn = db.getConnection();
			ReviewDAO dao = ReviewDAO.getDAO();
			list = dao.getList(conn, shopno);
		} catch (NamingException | SQLException e) {
			System.out.println(e);
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return list;
	}

	public int addReview(ReviewDTO dto, List<String> img) {
		DBConn db = DBConn.getdb();
		Connection conn = null;
		int result = 0;
		int imgresult = 0;
		try {
			conn = db.getConnection();
			ReviewDAO dao = ReviewDAO.getDAO();
			result = dao.addReview(conn, dto);
			int reviewno = dao.getReviewNo(conn, dto);
			for (String i : img) {
				imgresult = dao.addImage(conn, reviewno, i);
				System.out.println(i + " - add imge");
			}
			// imgresult = dao.addImage(conn, dto.getReviewno())
			if (imgresult == 0) {
				System.out.println("리뷰 이미지 없음");
			}
		} catch (SQLException | NamingException | ParseException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return result;
	}
}