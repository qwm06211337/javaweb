package com.admin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	static String url = "jdbc:mysql:///project_db";
	static String name = "root";
	static String pwd = "123456";
	//加载驱动
	static {
		try {//com.mysql.jdbc.Driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//链接数据库
	public static Connection getConn() {
		try {
			return DriverManager.getConnection(url,name,pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//关闭数据库链接
	public static void closeConn(Connection conn,ResultSet rs,PreparedStatement smt) {
		try {
			if(conn!=null) {
				conn.close();
			}
			if(rs!=null) {
				rs.close();
			}
			if(smt!=null) {
				smt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		System.out.println(DBUtils.getConn());
	}
}
