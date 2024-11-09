package com.jee.dao;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
  
	private static Connection cnx;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/gestag", "root", "root");
		} catch(Exception e) {
			System.out.println("Erreur de connection : " + e.getMessage());
		}
	}

	public static Connection getConnection() {
		return cnx;
	}

}