package com.onlinetest.dao;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.onlinetest.beans.SubjectBean;
import com.onlinetest.factory.GetConnectionFactory;


public class SubjectDAO2 {
	
		static Connection conn=null;
		static String query="insert into mysubject values(?,?,?,?,?,?,?,?)";
		//static String deleteQuery="delete from subject_question_table where question_id='?'";
		static int rows;
		static int delRow;
		static ResultSet resultSet;
		static List<SubjectBean> subList=new ArrayList<SubjectBean>();
		static RequestDispatcher requestDispatcher;
		static PreparedStatement preparedStatement;
		static PrintWriter out;
		
	
	public static int insert(List<SubjectBean> subjectList ){
		
		conn=GetConnectionFactory.getDbConnection();
		try{
			preparedStatement=conn.prepareStatement(query);
			preparedStatement.setString(1, subjectList.get(0).subject);
			preparedStatement.setString(2, subjectList.get(0).questionId);
			preparedStatement.setString(3, subjectList.get(0).question);
			preparedStatement.setString(4, subjectList.get(0).choiceA);
			preparedStatement.setString(5, subjectList.get(0).choiceB);
			preparedStatement.setString(6, subjectList.get(0).choiceC);
			preparedStatement.setString(7, subjectList.get(0).choiceD);
			preparedStatement.setString(8, subjectList.get(0).answer);
			
			rows=preparedStatement.executeUpdate();
			
			preparedStatement.close();
			GetConnectionFactory.closeConnection(conn);
		}
		catch(SQLException ex){
			System.out.print("Error Took Place");
		}
		
		
		return rows;
	}
	
	
	
	
	public static List<SubjectBean> retrieve(String sub){
		conn=GetConnectionFactory.getDbConnection();
		SubjectBean subBean;
				
		
		try{
			preparedStatement=conn.prepareStatement("select * from subject_question_table where subject_name=?");
			preparedStatement.setString(1, sub);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				subBean=new SubjectBean();
			subBean.setSubject(resultSet.getString(1));
			subBean.setQuestionId(resultSet.getString(2));
			subBean.setQuestion(resultSet.getString(3));
			subBean.setChoiceA(resultSet.getString(4));
			subBean.setChoiceB(resultSet.getString(5));
			subBean.setChoiceC(resultSet.getString(6));
			subBean.setChoiceD(resultSet.getString(7));
			subBean.setAnswer(resultSet.getString(8));
			
			subList.add(subBean);
			
			
			}
			
			GetConnectionFactory.closeConnection(conn);
			
			
		}
		catch(SQLException ex){
			System.out.println("Error");
		}
		
		finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}

			} catch (SQLException e) {
				
			}
			catch(NullPointerException exx){
				out.print("Some ERROR Occured,Try Again later");
			}
		}
		
		return subList;
		
	}
	
	public static int deleteQuestion(String questionId){
		
		conn=GetConnectionFactory.getDbConnection();
		try{
			preparedStatement=conn.prepareStatement("delete from subject_question_table where question_id='"+questionId+"'");
			
			delRow=preparedStatement.executeUpdate();
		}
		catch(SQLException ex){
			System.out.print("SQL ERROR");
		}
		GetConnectionFactory.closeConnection(conn);
		return delRow;
	}
}
