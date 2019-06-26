package com.teatime.cs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceDAO {

	private static CustomerServiceDAO dao = new CustomerServiceDAO();

	public static CustomerServiceDAO getDAO() {

		return dao;
	}

	private CustomerServiceDAO() {

	}

	public List<CustomerServiceDTO> getListData(Connection conn, int startrow, int pagepercount) throws SQLException {

		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		List<CustomerServiceDTO> list = null;

		sql.append(" select qnano, title, state ");
		sql.append(" from customerservice ");
		sql.append(" limit ?, ? ");

		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setInt(1, startrow);
			pstmt.setInt(2, pagepercount);

			rs = pstmt.executeQuery();
			list = new ArrayList<>();

			while (rs.next()) {
				CustomerServiceDTO dto = new CustomerServiceDTO();
				dto.setQnano(rs.getInt("qnano"));
				dto.setTitle(rs.getString("title"));
				dto.setState(rs.getInt("state"));

				list.add(dto);
			}

		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println(e);
				}
		}
		return list;
	}

	public int getCount(Connection conn) throws SQLException { // 전체 자료수 가져오는 메소드

		StringBuilder sql = new StringBuilder();
		sql.append(" select count(*) ");
		sql.append(" from customerservice ");

		int datacount = 0;

		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString()); ResultSet rs = pstmt.executeQuery();) {
			if (rs.next()) {
				datacount = rs.getInt(1);
			}
		}
		return datacount;
	}

	public void addData(Connection conn, CustomerServiceDTO dto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into customerservice(title, content, id, hp) ");
		sql.append(" values(?, ?, 'cy',?)                            ");

		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getHp());

			pstmt.executeUpdate();
		}
	}

	public CustomerServiceDTO detailData(Connection conn, int boardnum) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		CustomerServiceDTO data = new CustomerServiceDTO();
		
		sql.append(" select qnano, title, content, hp, regidate ");
		sql.append(" from customerservice         ");
		sql.append(" where qnano=?                ");
		
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, boardnum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				data.setQnano(rs.getInt("qnano"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setHp(rs.getString("hp"));
				data.setRegidate(rs.getString("regidate"));
			}
		} finally {
			rsClose(rs);
			pstmtClose(pstmt);
		}
		return data;
	}

	private void pstmtClose(PreparedStatement pstmt) {
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
	}

	private void rsClose(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
			}
	}

}
