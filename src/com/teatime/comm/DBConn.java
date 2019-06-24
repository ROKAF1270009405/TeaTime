package com.teatime.comm;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConn {
	private static DBConn dbconn = new DBConn();

	private DBConn() {

	}

	public static DBConn getdb() {
		return dbconn;
	}

	public Connection getConnection() throws SQLException, NamingException {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/teatime");
		Connection conn = ds.getConnection();
		return conn;
	}
}
