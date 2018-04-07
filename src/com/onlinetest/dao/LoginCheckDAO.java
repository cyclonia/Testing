package com.onlinetest.dao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlinetest.factory.GetConnectionFactory;
public class LoginCheckDAO {
	static Connection conn=null;
	static ResultSet resultSet;
	static String pass;
	static String email;
	static String name;
	static PreparedStatement preparedStatement;
	static String firstName;
	static String lastName;
	
	public static String getPass(String userEmail){
		conn=GetConnectionFactory.getDbConnection();
		email=userEmail;
		try{
			preparedStatement=conn.prepareStatement("select password from student_registration_table where email=?");
			preparedStatement.setString(1, email);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()){
				pass=resultSet.getString("password");
			}
			preparedStatement.close();
			resultSet.close();
			
		}
		catch(SQLException sql){
			
		}
		GetConnectionFactory.closeConnection(conn);
		return pass;
	}
	
	public static String getName(String userEmail){
		
		conn=GetConnectionFactory.getDbConnection();
		email=userEmail;
		try{
			preparedStatement=conn.prepareStatement("select first_name,last_name from student_registration_table where email=?");
			preparedStatement.setString(1, email);
			resultSet=preparedStatement.executeQuery();
				
				while(resultSet.next()){
					firstName=resultSet.getString("first_name");
					lastName=resultSet.getString("last_name");
				}
				name=firstName.concat(" "+lastName);
				preparedStatement.close();
				resultSet.close();
			
		}
		catch(SQLException ex){
			System.out.println("SQL error");
		}
		GetConnectionFactory.closeConnection(conn);
		return name;
	}

}
