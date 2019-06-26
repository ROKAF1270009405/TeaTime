package com.teatime.detail.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.teatime.shop.model.ShopDTO;

public class DetailDAO {
	
	private static DetailDAO dao = new DetailDAO();
	public static DetailDAO getDAO() {
		return dao;
	}
	
	public ShopDTO detail(Connection conn, int shopno) throws SQLException {
		ShopDTO result = new ShopDTO();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select shopno, name, content, photo, addr, workingtime, date ");
		sql.append(" from shop ");
		sql.append(" where shopno = ? ");
		sql.append(" order by shopno desc ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, shopno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("DAO : "+rs.getString("name"));
				result.setShopno(rs.getInt("shopno"));
				result.setName(rs.getString("name"));
				result.setContent(rs.getString("content"));
				result.setPhoto(rs.getString("photo"));
				result.setAddr(rs.getString("addr"));
				result.setWorkingtime(rs.getString("workingtime"));
				result.setDate(rs.getDate("date"));
			}
		} catch (SQLException e) {
			throw e;
		}
		return result;
	}
}
