package com.onlinetest.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.SQLException;

import com.onlinetest.beans.ResultBean;
import com.onlinetest.factory.GetConnectionFactory;




public class ResultDAO {
	
	static Connection conn=null;
	static PreparedStatement preparedStatement=null;
	static String insertQuery="insert into student_result_table values(?,?,?)";
	static int row=0;
	
	
	
	public static int insert(List<ResultBean> list){
		
		conn=GetConnectionFactory.getDbConnection();
		try{
			preparedStatement=conn.prepareStatement(insertQuery);
			preparedStatement.setString(1, list.get(0).emailId);
			preparedStatement.setString(2, list.get(0).testSubject);
			preparedStatement.setInt(3, list.get(0).marksObtained);
			
			row=preparedStatement.executeUpdate();
			
			
		}
		catch(SQLException ex){
			
		}
		catch(NumberFormatException e){
			
		}
		catch(NullPointerException n){
			
		}
		
	return row ;
	}
	

}
