package com.hospital.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionUtil {
	
	static {
		try {
			Class.forName(DbProperties.getDriver());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static Connection getDbConnection() throws com.hospital.exception.DbConnectionException {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(DbProperties.getDbURL(),DbProperties.getProps());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new com.hospital.exception.DbConnectionException(HexaConstants.CANNOT_OPEN_CONNECTION,e);
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
	
			try {
				if(conn!=null)
				conn.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		
	}
	
}
