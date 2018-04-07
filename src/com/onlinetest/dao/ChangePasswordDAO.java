package com.onlinetest.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.onlinetest.beans.ChangePassBean;
import com.onlinetest.factory.GetConnectionFactory;


public class ChangePasswordDAO {
	static int confirm;
	static Connection conn=null;
    static ResultSet resultSet=null;
    static String password;
    static PreparedStatement preparedStatement;
    static PreparedStatement preparedStatementUpdate;
    
    
    public static int changeAdminPass(ChangePassBean info){
    	conn=GetConnectionFactory.getDbConnection();
		try{
			
			preparedStatement=conn.prepareStatement("select password from admin_login where user_name=?");
			preparedStatement.setString(1, info.getUserName().trim());
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()){
				password=resultSet.getString("password");
			}
	
			preparedStatementUpdate=conn.prepareStatement("update admin_login set password=? where user_name=?");
			preparedStatementUpdate.setString(1,info.getNewPass());
			preparedStatementUpdate.setString(2,info.getUserName());
			confirm=preparedStatementUpdate.executeUpdate();
		
	}
		catch(SQLException c){
		
		}
		
		finally{
			try{
				if(conn!=null)
				{
					conn.close();
				}
			}
			
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return confirm;
	}
    
    
    public static int changeUserPass(ChangePassBean info){
    	conn=GetConnectionFactory.getDbConnection();
		try{
			
			preparedStatement=conn.prepareStatement("select password from student_registration_table where email=?");
			preparedStatement.setString(1, info.getUserName().trim());
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()){
				password=resultSet.getString("password");
			}
	
			preparedStatementUpdate=conn.prepareStatement("update student_registration_table set password=? where email=?");
			preparedStatementUpdate.setString(1,info.getNewPass());
			preparedStatementUpdate.setString(2,info.getUserName());
			confirm=preparedStatementUpdate.executeUpdate();
		
	}
		catch(SQLException c){
		
		}
		
		finally{
			try{
				if(conn!=null)
				{
					conn.close();
				}
			}
			
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return confirm;
	}

}
