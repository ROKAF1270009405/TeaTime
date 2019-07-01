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
	
	public DetailDTO details(Connection conn, int shopno) throws SQLException {
		ResultSet rs = null;
		DetailDTO dto = new DetailDTO();
		StringBuilder sql = new StringBuilder();
		sql.append(" select s.shopno, name, s.content, addr, photo, workingtime, s.date, round(ifnull(avg(gpa), 0),1) as gpa, (select count(*) from good g where s.shopno = g.shopno) as good, foodkind ");
		sql.append(" from shop s left outer join review r on s.shopno = r.shopno ");
		sql.append(" where s.shopno = ? ");
		sql.append(" group by shopno ");
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {  
			pstmt.setInt(1, shopno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setShopno(rs.getInt("s.shopno"));
				dto.setName(rs.getString("name"));
				dto.setContent(rs.getString("s.content"));
				dto.setPhoto(rs.getString("photo"));
				dto.setAddr(rs.getString("addr"));
				dto.setWorkingtime(rs.getString("workingtime"));
				dto.setDate(rs.getString("s.date"));
				dto.setGpa(rs.getFloat("gpa"));
				dto.setGood(rs.getInt("good"));
				dto.setFoodkind(rs.getString("foodkind"));
			}
		} catch (SQLException e) {
			throw e;
		}
		return dto;
	}

/*	public int good(Connection conn, int no) {
		int result = 0; 
		StringBuilder sql = new StringBuilder();
		sql.append("  ");
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {  
			
			pstmt.setInt(1, shopno);
			result = pstmt.executeQuery();
			
		} catch (SQLException e) {
			throw e;
		}
		return result;
	}
	*/
}
