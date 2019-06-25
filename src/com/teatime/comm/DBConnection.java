package com.teatime.comm;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	private static DBConnection db = new DBConnection();

	public static DBConnection getDB() {
		return db;
	}

	private DBConnection() {

	}

	public Connection getConnection() throws NamingException, SQLException {
		InitialContext initContext = new InitialContext();
		DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/bitcamp");
		Connection conn = ds.getConnection();
		return conn;
	}
}
