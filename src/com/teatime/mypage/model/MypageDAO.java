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

	// 리뷰 가져오기
	public List<MypageDTO> getReview(Connection conn, MemberDTO dto) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" select name, gpa, shop.photo       ");
		sql.append(" from shop join review              ");
		sql.append(" on shop.shopno = review.shopno     ");
		sql.append(" where id = ?                       ");

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
				mydto.setGap(rs.getFloat("gpa"));
				mydto.setPhoto(rs.getString("photo"));
				mydto.setShopno(rs.getInt("shopno"));
				mydto.setId(rs.getString("id"));
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

	/*
	 * // getMemberList public List<MemberDTO> getMemberList(Connection conn,
	 * MemberDTO dto) throws SQLException {
	 * 
	 * StringBuilder sql = new StringBuilder();
	 * sql.append(" select id, nickname, email             ");
	 * sql.append(" from member                           ");
	 * 
	 * PreparedStatement pstmt = null; ResultSet rs = null; List<MemberDTO> list =
	 * new ArrayList<>();
	 * 
	 * try { pstmt = conn.prepareStatement(sql.toString()); rs =
	 * pstmt.executeQuery();
	 * 
	 * while (rs.next()) {
	 * 
	 * dto.setId(rs.getString("id")); dto.setNickname(rs.getString("nickname"));
	 * dto.setMail(rs.getString("email")); list.add(dto); } // end while } finally {
	 * if (rs != null) { try { rs.close(); } catch (SQLException e) {
	 * System.out.println(e.getMessage()); } } if (pstmt != null) { try {
	 * pstmt.close(); } catch (SQLException e) { System.out.println(e.getMessage());
	 * } } } return list;
	 * 
	 * } // end getMemberList method
	 */
} // end mypageDAO class
