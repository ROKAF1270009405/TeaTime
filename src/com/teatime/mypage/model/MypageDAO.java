package com.teatime.mypage.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teatime.member.MemberDTO;

public class MypageDAO {

	// singleton pattern
	private static MypageDAO dao = new MypageDAO();

	private MypageDAO() {

	}

	public static MypageDAO getDAO() {
		return dao;
	}

	// 내가 쓴 리뷰 가져오기
	public List<MypageDTO> getReview(Connection conn, MemberDTO dto) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" select name, gpa, shop.photo, review.content       ");
		sql.append(" from shop join review                              ");
		sql.append(" on shop.shopno = review.shopno                     ");
		sql.append(" where review.id = ?                                ");

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<MypageDTO> list = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MypageDTO mydto = new MypageDTO();
				mydto.setName(rs.getString("name"));
				mydto.setGpa(rs.getFloat("gpa"));
				mydto.setPhoto(rs.getString("shop.photo"));
				mydto.setContent(rs.getString("review.content"));
				list.add(mydto);
			} // end while

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return list;
	} // end getReview method

	// 리뷰 수정하기
	public int modifyreview(Connection conn, MemberDTO dto) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" update review               ");
		sql.append(" set content = ?, gpa = ?    ");
		sql.append(" where id = ?                ");

		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql.toString());
			MypageDTO mydto = new MypageDTO();
			pstmt.setString(1, mydto.getContent());
			pstmt.setFloat(2, mydto.getGpa());
			pstmt.setString(3, dto.getId());
			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}

		return result;
	} // end modifyreview method

} // end mypageDAO class
