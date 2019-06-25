package com.teatime.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewDAO {
		private static ReviewDAO dao = new ReviewDAO();
		public static ReviewDAO getDAO() {
			return dao;
		}
		private ReviewDAO() {}

		private void rsClose(ResultSet rs) {
			if (rs != null) {try {rs.close();} catch (SQLException e) {}}
		}
			
		
}

