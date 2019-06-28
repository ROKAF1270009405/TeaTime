package com.teatime.review.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewDAO {

	private static ReviewDAO dao = new ReviewDAO();

	public static ReviewDAO getDAO() {
		return dao;
	}

	private ReviewDAO() {
	}

	public List<ReviewDTO> getList(Connection conn, int shopno) throws SQLException {
		ArrayList<ReviewDTO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select reviewno, r.content, r.date,  gpa, r.shopno, r.id, s.name			");
		sql.append("from review r, shop s													");
		sql.append("where r.shopno = ? and r.shopno = s.shopno								");
		// sql.append("limit ?,? ");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, shopno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setReviewno(rs.getInt("reviewno"));
				dto.setContent(rs.getString("content"));
				dto.setDate(rs.getDate("date") + "");
//				dto.setPhoto(rs.getString("photo"));
				dto.setGpa(rs.getFloat("gpa"));
				dto.setShopno(rs.getInt("shopno"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				System.out.println(">>>>>>>>>>>>>>>>>>"+rs.getString("name"));

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

	public List<String> getPhotoList(Connection conn, int reviewno) throws SQLException{
		ArrayList<String> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select photo				");
		sql.append("from reviewphoto			");
		sql.append("where reviewno = ? 			");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, reviewno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString("photo"));
			}
			System.out.println("list: "+list.size());
		} finally {
			if(pstmt!=null) {
				pstmt.close();
			}
		}
		return list;
	}
	
	
	public int addReview(Connection conn, ReviewDTO dto) throws SQLException, ParseException {
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("insert into review(content, date, gpa, shopno, id)	");
		sql.append("			values(	?, ?, ?, ?, ?				)	");
		// sql.append("limit ?,? ");
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getContent());
			long d = System.currentTimeMillis();
			Date date = new Date(d);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			String date1 = formatter.format(date);
//			System.out.println("aaa" + java.sql.Date.valueOf(date1));
			pstmt.setDate(2, new java.sql.Date(d));

//			pstmt.setString(3, dto.getPhoto());
			pstmt.setFloat(3, dto.getGpa());
			pstmt.setInt(4, dto.getShopno());
			pstmt.setString(5, dto.getId());
			System.out.println("dto.getid : " + dto.getContent());
			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
		}

		return result;
	}
	
	public int addImage(Connection conn, int reviewno, String img) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into reviewphoto(photo, reviewno)		");
		sql.append("			values(?, ?)						");
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, img);
			pstmt.setInt(2, reviewno);
			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
		}
		return result;
	}
	
	public int getReviewNo(Connection conn, ReviewDTO dto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select reviewno 														");
		sql.append("from review																");
		sql.append("where content = ? and date like ? and gpa=? and shopno=? and id=?		");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int id = 0;
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getContent());
			long d = System.currentTimeMillis();
			Date date = new Date(d);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			pstmt.setString(2, new java.sql.Date(d)+"%");
//			pstmt.setString(3, dto.getPhoto());
			pstmt.setFloat(3, dto.getGpa());
			pstmt.setInt(4, dto.getShopno());
			pstmt.setString(5, dto.getId());
			rs = pstmt.executeQuery();
			if(rs!=null) {
				rs.next();
				id = rs.getInt(1);
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
		}
		return id;
	}
}
