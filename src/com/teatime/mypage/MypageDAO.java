package com.teatime.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teatime.dto.MemberDTO;

public class MypageDAO {

	// singleton pattern
	private static MypageDAO dao = new MypageDAO();

	private MypageDAO() {

	}

	public static MypageDAO getDAO() {
		return dao;
	}

	// getMemberList
	public List<MemberDTO> getMemberList(Connection conn) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" select id, pwd, nickname, email       ");
		sql.append(" from member                           ");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberDTO> list = new ArrayList<>();

		try {

			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setNickname(rs.getString("nickname"));
				dto.setMail(rs.getString("mail"));
				list.add(dto);
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

	} // end getMemberList method

} // end mypageDAO class
