package com.onlinetest.factory;
import java.sql.*;
public class GetConnectionFactory {
	static Connection conn=null;
	static String url="jdbc:mysql://localhost:3306/online_test";
	static String userName="root";
	static String password="sunil";
	
	public static Connection getDbConnection(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url,userName,password);
		}
		catch(Exception ex){
			ex.getStackTrace();
		}
		return conn;
	}
	
	public static void closeConnection(Connection conn1){
		if(conn1!=null){
			try{
				conn1.close();
			}
			catch(SQLException ex2){
				ex2.printStackTrace();
			}
		}
	}

}
