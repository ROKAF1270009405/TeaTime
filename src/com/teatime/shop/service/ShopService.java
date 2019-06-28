package com.teatime.shop.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.teatime.best.model.BestDAO;
import com.teatime.best.model.BestDTO;
import com.teatime.comm.DBConn;
import com.teatime.menu.model.MenuDTO;
import com.teatime.shop.model.ShopDAO;
import com.teatime.shop.model.ShopDTO;

public class ShopService {

	private static ShopService instance= new ShopService();
	public static ShopService getInstance()
	{
		return instance;
	}
	private ShopService() {}
	
	public List<ShopDTO> ListService(int select, String search){
		System.out.println(search);
		Connection conn = null;
		List<ShopDTO> list=new ArrayList<>();
		
		try {
			DBConn db = DBConn.getdb();
			
			conn=db.getConnection();
			conn.setAutoCommit(false);
			ShopDAO dao = new ShopDAO();
			
			list=dao.getList(conn,select,search);
			
			conn.commit();
			
		}catch(SQLException|NamingException e) {
			System.out.println(e);
			try {conn.rollback();}catch(SQLException e1) {}
		}catch(RuntimeException e) {
			try {conn.rollback();}catch(SQLException e1) {}
		}finally {
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}
		return list;
	}
	
	public int insert(ShopDTO dto) {
		int result = 0;
		DBConn db = DBConn.getdb();
		Connection conn = null;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			ShopDAO dao = ShopDAO.getDAO();
			result = dao.boardadd(conn, dto);
			
			System.out.println("shopservice result : " +result);
			
			
			conn.commit();
		} catch(SQLException e) {
			try { conn.rollback(); } catch(SQLException e2) {}
		} catch (NamingException e) {
			System.out.println(e);
		} finally {
			if(conn != null) try {conn.close();} catch(SQLException e) {}
		}
		return result;
	}
	
	
	
	public int getCount() {//자료갯수를 얻어오는 메서드
		DBConn db = DBConn.getdb();
		Connection conn=null;
		int datacount=0;
		try {
			
		conn = db.getConnection();
		ShopDAO dao=ShopDAO.getDAO();
		datacount = dao.getCount(conn);
		}catch(SQLException|NamingException e) {
			System.out.println(e);
		}
			return datacount;
	}
	
	public int shopAddService(ShopDTO dto) {
		DBConn db = DBConn.getdb();
		Connection conn = null;
		int result = 0;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			ShopDAO dao = ShopDAO.getDAO();
			result = dao.shopAdd(conn, dto);
			conn.commit();
		} catch (SQLException | NamingException e) {
			try { conn.rollback(); } catch(SQLException e2) {}
		} finally {	
			if (conn != null) {	try {conn.close();} catch (SQLException e) {}}
		}
		return result;
	}
	
	public int menuAddService(List<MenuDTO> menu) {
		DBConn db = DBConn.getdb();
		Connection conn = null;
		int result = 0;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			ShopDAO dao = ShopDAO.getDAO();
			result = dao.menuAdd(conn, menu);
			conn.commit();
		} catch (SQLException | NamingException e) {
			try { conn.rollback(); } catch(SQLException e2) {}
		} finally {	
			if (conn != null) {	try {conn.close();} catch (SQLException e) {}}
		}
		return result;
	}
	
}
