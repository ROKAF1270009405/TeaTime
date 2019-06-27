package com.teatime.login.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.teatime.member.MemberDTO;

public class LoginDAO {
	private static LoginDAO dao = new LoginDAO();
	public static LoginDAO getDAO() {
		return dao;
	}
	private LoginDAO() {}

	private void rsClose(ResultSet rs) {
		if (rs != null) {try {rs.close();} catch (SQLException e) {}}
	}
	
	public int loginCheck(Connection conn, MemberDTO dto) throws SQLException {
		int result = 0;
		ResultSet rs = null;
		System.out.println("로그인 체크!!");
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) as count from member where id = ? and pwd = ? ");
		try(PreparedStatement pstmt = conn.prepareStatement(sb.toString());){
			System.out.println("로그인 체크 : "+dto.getId()+", "+dto.getPwd());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("count");
			}
			System.out.println("로그인 여부(0/1) : "+result);
		} finally {
			rsClose(rs);
		}
		return result;
	}
	
	public MemberDTO logininfo(Connection conn, String id) throws SQLException {
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		System.out.println("로그인 정보!!");
		sb.append(" select id, nickname, email, authority from member where id = ? ");
		MemberDTO info = new MemberDTO();
		try(PreparedStatement pstmt = conn.prepareStatement(sb.toString());){
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString("id")+", "+rs.getString("nickname")+", "+rs.getString("email")+", "+rs.getInt("authority"));
				info.setId(rs.getString("id"));
				info.setNickname(rs.getString("nickname"));
				info.setMail(rs.getString("email"));
				info.setAuthority(rs.getInt("authority"));
			}
		} finally {
			rsClose(rs);
		}
		return info;
	}
	
	public int SignUp(Connection conn, MemberDTO dto) throws SQLException {
		int result = 0;
		StringBuilder sb = new StringBuilder();
		sb.append(" insert into member(id, pwd, nickname, email) values(?, ?, ?, ?) ");
		try(PreparedStatement pstmt = conn.prepareStatement(sb.toString());){
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getNickname());
			pstmt.setString(4, dto.getMail());
			result = pstmt.executeUpdate();
		}
		return result;
	}
	public int idCheck(Connection conn, String id) throws SQLException {
		int result = 0;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) as count from member where id = ? ");
		try(PreparedStatement pstmt = conn.prepareStatement(sb.toString());){
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("count");
			}
		} finally {
			rsClose(rs);
		}
		return result;
	}
	
}
