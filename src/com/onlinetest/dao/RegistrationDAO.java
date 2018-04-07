package com.onlinetest.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;

import com.onlinetest.beans.RegistrationBean;
import com.onlinetest.beans.ResultBean;
import com.onlinetest.factory.GetConnectionFactory;

//import sunil.SubjectBean;
public class RegistrationDAO {



		static Connection conn=null;
		static ResultBean result;
		static String InsertQuery="insert into student_registration_table values(?,?,?,?,?,?,?,?,?,?)";
		static String selectAllQuery="select * from student_registration_table";
		static String selectByRegQuery="select * from student_registration_table where student_id=?";
		static String selctByEmailQuery="select * from student_registration_table where email=?";
		static int rows;
		static List<RegistrationBean> studentDetails=new ArrayList<RegistrationBean>();
		static List<ResultBean> listResult=new ArrayList<ResultBean>();
		static PreparedStatement preparedStatement;
		static ResultSet RSselectAll;
		static RegistrationBean stuBean;
		

		public static int insert(List<RegistrationBean> regList ){
			
			conn=GetConnectionFactory.getDbConnection();
			try{
				preparedStatement=conn.prepareStatement(InsertQuery);
				preparedStatement.setString(1, regList.get(0).firstName);
				preparedStatement.setString(2, regList.get(0).lastName);
				preparedStatement.setString(3, regList.get(0).email);
				preparedStatement.setString(4, regList.get(0).branch);
				preparedStatement.setString(5, regList.get(0).semester);
				
				preparedStatement.setDate(6, regList.get(0).dob);
				preparedStatement.setString(7, regList.get(0).gender);
				preparedStatement.setString(8, regList.get(0).address);
				preparedStatement.setString(9, regList.get(0).password);
				preparedStatement.setString(10, regList.get(0).studentId);
				
				rows=preparedStatement.executeUpdate();
				GetConnectionFactory.closeConnection(conn);
				preparedStatement.close();
				
				
			}
			catch(NumberFormatException ex){
				System.out.print("nfe");
			}
			
			catch(SQLException sql){
				System.out.print("sql e");
			}
			
			return rows;
		}
		
		public static List<RegistrationBean> selectAll(){
			conn=GetConnectionFactory.getDbConnection();
			try{
			preparedStatement=conn.prepareStatement(selectAllQuery);
			RSselectAll=preparedStatement.executeQuery();
			
			while(RSselectAll.next()){
				stuBean=new RegistrationBean();
				stuBean.setFirstName(RSselectAll.getString(1));
				stuBean.setLastName(RSselectAll.getString(2));
				stuBean.setEmail(RSselectAll.getString(3));
				stuBean.setBranch(RSselectAll.getString(4));
				stuBean.setSemester(RSselectAll.getString(5));
				stuBean.setDob(RSselectAll.getDate(6));
				stuBean.setGender(RSselectAll.getString(7));
				stuBean.setAddress(RSselectAll.getString(8));
				stuBean.setStudentId(RSselectAll.getString(10));
				
				studentDetails.add(stuBean);
				
				
			}
			}
			catch(SQLException sq){
				System.out.print("SQL ERROR");
			}
					
			return studentDetails;
		}
		
		
		public static RegistrationBean selectByRegNumber(String reg){
			
			conn=GetConnectionFactory.getDbConnection();
			try{
			preparedStatement=conn.prepareStatement("select * from student_registration_table where student_id='"+reg+"'");
			//preparedStatement.setString(1,reg.trim());
			RSselectAll=preparedStatement.executeQuery();
			
			while(RSselectAll.next()){
				stuBean=new RegistrationBean();
				stuBean.setFirstName(RSselectAll.getString(1));
				stuBean.setLastName(RSselectAll.getString(2));
				stuBean.setEmail(RSselectAll.getString(3));
				stuBean.setBranch(RSselectAll.getString(4));
				stuBean.setSemester(RSselectAll.getString(5));
				stuBean.setDob(RSselectAll.getDate(6));
				stuBean.setGender(RSselectAll.getString(7));
				stuBean.setAddress(RSselectAll.getString(8));
				
				//studentDetails.add(stuBean);
				
				
			}
			RSselectAll.close();
			}
			catch(SQLException sq){
				System.out.print("SQL ERROR");
			}
			
			GetConnectionFactory.closeConnection(conn);
			return stuBean;
		}
		
		
		
		public static List<RegistrationBean> selectByEmail(String email){
			conn=GetConnectionFactory.getDbConnection();
			//System.out.print(email);
			
			try{
				preparedStatement=conn.prepareStatement(selctByEmailQuery);
				preparedStatement.setString(1,email);
				RSselectAll=preparedStatement.executeQuery();
				while(RSselectAll.next()){
					
					stuBean=new RegistrationBean();
					stuBean.setFirstName(RSselectAll.getString(1));
					stuBean.setLastName(RSselectAll.getString(2));
					stuBean.setEmail(RSselectAll.getString(3));
					stuBean.setBranch(RSselectAll.getString(4));
					stuBean.setSemester(RSselectAll.getString(5));
					stuBean.setDob(RSselectAll.getDate(6));
					stuBean.setGender(RSselectAll.getString(7));
					stuBean.setAddress(RSselectAll.getString(8));
					stuBean.setStudentId(RSselectAll.getString(10));
					
					studentDetails.add(stuBean);
				}
				GetConnectionFactory.closeConnection(conn);
			}
			catch(SQLException ex){
				
			}
			
			return studentDetails;
		}
		
		public static List<ResultBean> selectByEmailFromExamTable(String email){
			conn=GetConnectionFactory.getDbConnection();
			String email2=email;
			try{
				preparedStatement=conn.prepareStatement("select * from student_result_table where email_id=?");
				preparedStatement.setString(1, email2);
				RSselectAll=preparedStatement.executeQuery();
				while(RSselectAll.next()){
					result=new ResultBean();
					result.setEmailId(RSselectAll.getString(1));
					result.setTestSubject(RSselectAll.getString(2));
					result.setMarksObtained(RSselectAll.getInt(3));
					listResult.add(result);
				}
			}
			catch(SQLException ex){
				
			}finally{
				
				
				try{
					if(conn!=null)
					{
						conn.close();
					}
				}catch(SQLException exx)
				{
					
				}
			}
			
			
			return listResult;
		}
		
}