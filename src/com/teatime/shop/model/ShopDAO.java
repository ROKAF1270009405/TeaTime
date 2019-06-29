package com.teatime.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.teatime.menu.model.MenuDTO;
import com.teatime.shop.model.ShopDTO;

public class ShopDAO {

	private static ShopDAO dao = new ShopDAO();

	public static ShopDAO getDAO() {
		return dao;
	}

	public ShopDAO() {
	}
	
	public int shopAdd(Connection conn, ShopDTO dto) throws SQLException {
		int result = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into shop(name, photo, content, addr, workingtime, foodkind, id) ");
		sb.append(" values(?, ?, ?, ?, ?, ?, ?) ");
		try(PreparedStatement pstmt = conn.prepareStatement(sb.toString());){
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhoto());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getWorkingtime());
			pstmt.setString(6, dto.getFoodkind());
			pstmt.setString(7, dto.getId());
			result = pstmt.executeUpdate();
		}
		return result;
	}
	
	public int menuAdd(Connection conn, List<MenuDTO> menu) throws SQLException {
		int result = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO menu (shopno, name, price) VALUES ");
		for(int i=0; i<menu.size(); i++) {
			if(i < menu.size()-1) {
				sb.append(" ((select max(shopno) from shop), ?, ?), ");
			} else if(i == menu.size()-1) {
				sb.append(" ((select max(shopno) from shop), ?, ?) ");
			}
		}
		int su = 1;
		try(PreparedStatement pstmt = conn.prepareStatement(sb.toString());){
			System.out.println(sb.toString());
			for(int i=0; i<menu.size(); i++) {
				MenuDTO dto = new MenuDTO();
				dto = menu.get(i);
				pstmt.setString(su, dto.getName());
				pstmt.setString(su+1, dto.getPrice());
				su += 2;
			}
			result = pstmt.executeUpdate();
		}
		return result;
	}

	public List<ShopDTO> getList(Connection conn, int filter, String text) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = new StringBuilder();
		ArrayList<ShopDTO> arr = new ArrayList<>();
		sql.append(" select s.shopno, s.name, addr, photo ");
		sql.append(" from shop s join menu m ");
		sql.append(" on s.shopno = m.shopno ");
				
		// 일단 지금은 번호 순서 -> 좋아요 and 각종 필터링 할떄 수정 함녀 될듯
		
		
		if(!(filter==0) && !"".equals(text)){
			if(filter == 1) {
				sql.append(" where s.name like ? ");
			}else if (filter == 2) {
				sql.append(" where addr like ? ");
			}else if (filter == 3) {
				sql.append(" where m.name like ? ");
			}else if (filter == 4) {
				sql.append(" where foodkind like ? ");
			}   
		}
		
		
		sql.append(" group by s.name ");
		sql.append(" order by shopno desc ");

		
		try {
			
			pstmt = conn.prepareStatement(sql.toString());
			
			if (text != null && !text.equals("")) {
				pstmt.setString(1, "%" + text + "%");
			}

			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShopDTO data = new ShopDTO();
				data.setShopno(rs.getInt("shopno"));
				data.setName(rs.getString("name"));
				data.setAddr(rs.getString("addr"));
				data.setPhoto(rs.getString("photo"));				
				arr.add(data);
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
		}
		return arr;
	}
	
	public int boardadd(Connection conn, ShopDTO dto)throws SQLException {
		
		int result = 0 ;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into shop(name, content, photo, addr, workingtime ) ");
		sql.append(" values(?,?,?,?,?) ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, dto.getName());
			System.out.println("getname:"+dto.getName());
			
			pstmt.setString(2, dto.getContent());
			System.out.println("getcontent:"+dto.getContent());
			
			pstmt.setString(3, dto.getPhoto());
			System.out.println("getphoto:"+dto.getPhoto());
			
			pstmt.setString(4, dto.getAddr());
			System.out.println("getaddr:"+dto.getAddr());
			
			pstmt.setString(5, dto.getWorkingtime());
			System.out.println("getwt:"+dto.getWorkingtime());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			throw e;
		}
		return result;
	}
	
	
	//전체자료수를 얻어오는 메서드
		public int getCount(Connection conn) throws SQLException {
			StringBuilder sql=new StringBuilder();
			sql.append(" select count(*) from employees ");
			int datacount=0;
			
			try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					ResultSet rs=pstmt.executeQuery();
					) {
							if(rs.next()) {
								datacount = rs.getInt(1);
							}
			}
			return datacount;
		}//getCount

	
	/*
	 * public List<ShopDTO> SearchData(String text) { Connection conn = null;
	 * PreparedStatement pstmt = null; ResultSet rs = null; List<ShopDTO> result =
	 * new ArrayList<>(); StringBuilder sql = new StringBuilder();
	 * 
	 * sql.append(" select shopno, name, content, photo, addr, workingtime, date ");
	 * sql.append(" from shop ");
	 * 
	 * try { if (text != null && !text.equals("")) {
	 * sql.append(" where name like ? "); } pstmt =
	 * conn.prepareStatement(sql.toString()); if (text != null && !text.equals(""))
	 * { pstmt.setString(1, "%" + text + "%"); } rs = pstmt.executeQuery(); while
	 * (rs.next()) { ShopDTO dto = new ShopDTO();
	 * dto.setShopno(rs.getInt("shopno")); dto.setName(rs.getString("name"));
	 * dto.setContent(rs.getString("content")); dto.setPhoto(rs.getString("photo"));
	 * dto.setAddr(rs.getString("addr"));
	 * dto.setWorkingtime(rs.getString("workingtime"));
	 * dto.setDate(rs.getDate("date")); result.add(dto); } } catch (SQLException e)
	 * { System.out.println(e); } finally {
	 * 
	 * if (rs != null) try { rs.close(); } catch (SQLException e) { } if (pstmt !=
	 * null) try { pstmt.close(); } catch (SQLException e) { } if (conn != null) try
	 * { conn.close(); } catch (SQLException e) { } } return result; }
	 */
	/*
	 * public List<ShopDTO> boardlist(Connection conn) throws SQLException {
	 * List<ShopDTO> result = new ArrayList<>(); StringBuilder sql = new
	 * StringBuilder();
	 * sql.append(" select shopno, name, content, addr, workingtime, date ");
	 * sql.append(" from shop                  "); try(PreparedStatement pstmt =
	 * conn.prepareStatement(sql.toString()); ResultSet rs = pstmt.executeQuery();)
	 * { while (rs.next()) { ShopDTO dto = new ShopDTO();
	 * dto.setShopno(rs.getInt("shopno")); dto.setName(rs.getString("name"));
	 * dto.setContent(rs.getString("content")); dto.setAddr(rs.getString("addr"));
	 * dto.setWorkingtime(rs.getString("workingtime"));
	 * dto.setDate(rs.getDate("date")); result.add(dto); } } catch (SQLException e)
	 * { throw e; } return result; }
	 * 
	 * //전체자료수를 얻어오는 메서드 public int getCount(Connection conn) throws SQLException {
	 * StringBuilder sql=new StringBuilder();
	 * sql.append(" select count(*) from shop "); int datacount=0;
	 * 
	 * try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	 * ResultSet rs=pstmt.executeQuery(); ) { if(rs.next()) { datacount =
	 * rs.getInt(1); } } return datacount; }//getCount
	 * 
	 * 
	 * public List<ShopDTO> getData(Connection conn, int startrow, int endrow)
	 * throws SQLException{ // TODO Auto-generated method stub
	 * 
	 * PreparedStatement pstmt = null; ResultSet rs = null; StringBuilder sql = new
	 * StringBuilder(); sql.append(" 	select shopno 				");
	 * sql.append(" 			,name				");
	 * sql.append(" 			,content			");
	 * sql.append(" 			,photo				");
	 * sql.append(" 			,addr				");
	 * sql.append(" 			,workingtime		");
	 * sql.append(" 			,date				");
	 * sql.append(" 		from shop				");
	 * 
	 * List<ShopDTO> arr=new ArrayList<>(); //이 list가 try 속에 들어 있어서 안됬었음. try {
	 * pstmt=conn.prepareStatement(sql.toString()); pstmt.setInt(1, endrow);
	 * pstmt.setInt(2, startrow); rs = pstmt.executeQuery();
	 * 
	 * while(rs.next()) { ShopDTO dto = new ShopDTO();
	 * dto.setShopno(rs.getInt("shopno")); dto.setName(rs.getString("name"));
	 * dto.setContent(rs.getString("content")); dto.setPhoto(rs.getString("photo"));
	 * dto.setAddr(rs.getString("addr"));
	 * dto.setWorkingtime(rs.getString("workingtime"));
	 * dto.setDate(rs.getDate("date")); arr.add(dto); } }finally { if(rs!=null) try
	 * { rs.close();} catch (SQLException e) {} if(pstmt!=null) try {
	 * pstmt.close();} catch (SQLException e) {} }
	 * 
	 * return arr; //null 이었음. }
	 */

}
