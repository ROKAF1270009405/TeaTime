package com.teatime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teatime.dto.ShopDTO;

public class ShopDAO {

	private static ShopDAO dao = new ShopDAO();
	public static ShopDAO getDAO() {
		return dao;
	}
	
	private ShopDAO() {}
	
	public List<ShopDTO> boardlist(Connection conn) throws SQLException {
		List<ShopDTO> result = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select shopno, name, content, addr, workingtime, date ");
		sql.append(" from shop                  ");
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				ShopDTO dto = new ShopDTO();
				dto.setShopno(rs.getInt("shopno"));
				dto.setName(rs.getString("name"));
				dto.setContent(rs.getString("content"));
				dto.setAddr(rs.getString("addr"));
				dto.setWorkingtime(rs.getString("workingtime"));
				dto.setDate(rs.getDate("date"));
				result.add(dto);
			}
		} catch (SQLException e) {
			throw e;
		}
		return result;
	}
}
