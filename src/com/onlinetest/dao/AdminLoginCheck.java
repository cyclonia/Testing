package com.onlinetest.dao;
import java.sql.*;

import com.onlinetest.factory.GetConnectionFactory;
public class AdminLoginCheck {
	static Connection conn=null;
	static ResultSet resultSet;
	static String pass;
	static String admin;
	static PreparedStatement preparedStatement;
	
	
	public static String getPass(String adminId){
		conn=GetConnectionFactory.getDbConnection();
		admin=adminId;
		try{
			preparedStatement=conn.prepareStatement("select password from admin_login where user_name=?");
			preparedStatement.setString(1, admin);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()){
				pass=resultSet.getString("password");
			}
			
		}
		catch(SQLException sql){
			
		}
		
		return pass;
	}

}
