package com.gymmgmt.resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbResource {
	
	private static Connection con;
	static {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gymmgmt", "root", "AV@12345nura");
		} catch (Exception e) {
			System.err.println("Db Connection error "+e.toString());
		}
	}
	public static Connection getDbConnection() {
		try {
		return con;
		}catch(Exception e) {
			System.err.println("Error getting connection "+e.toString());
			return null;
		}
	}
	
	public static void closeConnection() {
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
