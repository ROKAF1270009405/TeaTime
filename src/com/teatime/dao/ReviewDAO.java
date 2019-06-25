package com.teatime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teatime.dto.ShopDTO;

public class ReviewDAO {
		private static ReviewDAO dao = new ReviewDAO();
		public static ReviewDAO getDAO() {
			return dao;
		}
		private ReviewDAO() {}

		private void rsClose(ResultSet rs) {
			if (rs != null) {try {rs.close();} catch (SQLException e) {}}
		}
		
		public List<ShopDTO> bestList(Connection conn, String kind, String startday, String endday) throws SQLException {
			ResultSet rs = null;
			StringBuilder sb = new StringBuilder();
			List<ShopDTO> bestlist = new ArrayList<>();
			
			
			//좋아요 갯수 기준 베스트
			if("good".equals(kind)) {
				sb.append(" select shopno, count(*) as count ");
				sb.append(" from good 						 ");
				kind = "count";
			}
			//평점 기준 베스트
			if("gpa".equals(kind)) {
				sb.append(" select shopno, avg(gpa) as gpa ");
				sb.append(" from review 				   ");
			}
			//날짜 기준
			if(startday!=null && !("".equals(startday))) {
				sb.append(" where date between ? and ");
				//endday가 정해지지 않으면, 오늘날까지.
				if("none".equals(endday))
					sb.append(" current_date()+1 ");
				else 
					sb.append(" ? ");
			}
			
			sb.append(" group by shopno order by ? desc ");
			try(PreparedStatement pstmt = conn.prepareStatement(sb.toString());){
				if() {
				}
				rs = pstmt.executeQuery();
			} finally {
				rsClose(rs);
			}
			return null;
		}
		
		
}

