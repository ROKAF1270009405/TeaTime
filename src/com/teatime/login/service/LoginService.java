package com.teatime.login.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import com.teatime.best.model.BestDAO;
import com.teatime.best.model.BestDTO;
import com.teatime.comm.DBConn;
import com.teatime.login.model.LoginDAO;
import com.teatime.member.MemberDTO;

public class LoginService {
	private static LoginService instance = new LoginService();

	public static LoginService getInstance() {
		return instance;
	}

	private LoginService() {
	}

	public int loginCheckService(MemberDTO dto) {
		int result = 0;
		DBConn db = DBConn.getdb();
		Connection conn = null;
		try {
			conn = db.getConnection();
			LoginDAO dao = LoginDAO.getDAO();
			result = dao.loginCheck(conn, dto);
		} catch (SQLException | NamingException e) {
			System.out.println(e);
		} finally {	
			if (conn != null) {	try {conn.close();} catch (SQLException e) {}}
		}
		return result;
	}

	public MemberDTO loginInfoService(String id) {
		MemberDTO dto = null;
		DBConn db = DBConn.getdb();
		Connection conn = null;
		try {
			conn = db.getConnection();
			LoginDAO dao = LoginDAO.getDAO();
			dto = dao.logininfo(conn, id);
		} catch (SQLException | NamingException e) {
			System.out.println(e);
		} finally {	
			if (conn != null) {	try {conn.close();} catch (SQLException e) {}}
		}
		return dto;
	}

	public int signUpService(MemberDTO dto) {
		int result = 0; 
		DBConn db = DBConn.getdb();
		Connection conn = null;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			LoginDAO dao = LoginDAO.getDAO();
			result = dao.SignUp(conn, dto);
			conn.commit();
		} catch (SQLException | NamingException e) {
			System.out.println(e);
		} finally {	
			if (conn != null) {	try {conn.close();} catch (SQLException e) {}}
		}
		return result;
	}


}
