package com.bitcamp.cs.model;

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

	public List<CustomerServiceDTO> getListData(Connection conn, int startrow, int endrow) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		ResultSet rs = null;
		List<CustomerServiceDTO> list = null;

		sql.append(" select employee_id, last_name, email, salary                      ");
		sql.append(" from (select rownum as rnum, employee_id, last_name, email, salary ");
		sql.append("       from employees e                                            ");
		sql.append("       where rownum<=?)                                              ");
		sql.append(" where rnum>=?                                                     ");
		try (PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setInt(1, endrow);
			pstmt.setInt(2, startrow);

			rs = pstmt.executeQuery();
			list = new ArrayList<>();

			while (rs.next()) {

				CustomerServiceDTO dto = new CustomerServiceDTO();

				
				
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

}
