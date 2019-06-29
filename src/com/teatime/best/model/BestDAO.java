package com.teatime.best.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BestDAO {
	private static BestDAO dao = new BestDAO();
	public static BestDAO getDAO() {
		return dao;
	}
	private BestDAO() {}

	private void rsClose(ResultSet rs) {
		if (rs != null) {try {rs.close();} catch (SQLException e) {}}
	}
	
	public List<BestDTO> bestList(Connection conn, String kind, String startday, String endday) throws SQLException {
		//System.out.println("베스트 BAO 진입");
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		List<BestDTO> bestlist = new ArrayList<>();
		sb.append(" select s.shopno, s.name, s.addr, s.photo, avg(gpa) as gpa, (select count(*) from good g where g.shopno = s.shopno) as good ");
		sb.append(" from shop s left outer join review r on s.shopno = r.shopno ");
		//System.out.println("kind : "+kind);
		//System.out.println("startday : "+startday);
		//System.out.println("endday : "+endday);
		//날짜 기준
		if(startday!=null && !("".equals(startday))) {
			sb.append(" where r.date between ? and ");
			if("none".equals(endday)) {
				System.out.println("하나 선택했네"+startday);
				sb.append(" current_date()+1 "); //오늘날까지.
			}
			else {
				System.out.println("두개 선택했네 "+startday+", "+endday);
				sb.append(" ? "); //사용자 지정날까지.
				//sb.append(" 23:59:59  ");
			}
		}
		
		if("good".equals(kind))
			sb.append(" group by shopno order by good desc, gpa desc, s.name ");
		else 
			sb.append(" group by shopno order by gpa desc, good desc, s.name ");
		//System.out.println(sb.toString());
		try(PreparedStatement pstmt = conn.prepareStatement(sb.toString());){
			System.out.println(sb.toString());
			if(startday!=null && !("".equals(startday))) {
				pstmt.setString(1, startday);
				if(!("none".equals(endday))) {
					System.out.println("end day 가 있다");
					pstmt.setString(2, endday);
					System.out.println(endday);
				} 
			} 
			System.out.println(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BestDTO dto = new BestDTO();
				//System.out.println(rs.getInt("s.shopno")+", "+rs.getString("s.name")+", "+rs.getString("s.addr")+", "+rs.getString("s.photo")+", "+rs.getFloat("gpa")+", "+rs.getInt("good"));
				dto.setShopno(rs.getInt("s.shopno"));
				dto.setName(rs.getString("s.name"));
				dto.setAddr(rs.getString("s.addr"));
				/*String photo = rs.getString("s.photo");
				dto.setPhoto(photo.equals(null) ? photo : "empty" );*/
				dto.setPhoto(rs.getString("s.photo"));
				dto.setGpa(rs.getFloat("gpa"));
				dto.setCount(rs.getInt("good"));
				bestlist.add(dto);
			}
		} finally {
			rsClose(rs);
		}
		return bestlist;
	}
}
