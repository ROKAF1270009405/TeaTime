package com.teatime.dao;

import java.sql.Connection;
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
		
		public List<ShopDTO> bestList(Connection conn, String kind, String startday, String endday) {
			ResultSet rs = null;
			StringBuilder sb = new StringBuilder();
			List<ShopDTO> bestlist = new ArrayList<>();
			//좋아요 갯수기준
			sb.append(" select shopno, count(*) from good group by shopno ");
			return null;
		}
		
		
}

