package com.teatime.review.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

	private static ReviewDAO dao = new ReviewDAO();

	public static ReviewDAO getDAO() {
		return dao;
	}

	private ReviewDAO() {
	}

	public List<ReviewDTO> getList(Connection conn) throws SQLException {
		ArrayList<ReviewDTO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select reviewno, title, content, date, photo, gpa, shopno, id 	");
		sql.append("from review														");
		// sql.append("limit ?,? ");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setReviewno(rs.getInt("reviewno"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setDate(rs.getDate("date"));
				dto.setPhoto(rs.getString("photo"));
				dto.setGpa(rs.getFloat("gpa"));
				dto.setShopno(rs.getInt("shopno"));
				dto.setId(rs.getString("id"));
				list.add(dto);
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
		}
		// 검색하고 싶을 대
		// select * from (select rownum as rnum, e.*
		// from( select * from employees where title = ? order by desc) where
		// rownum<=?)where rnum>=?;
		return list;
	}

}
