package com.onlinetest.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;

import com.onlinetest.beans.SubjectBean;
import com.onlinetest.factory.GetConnectionFactory;
public class SubjectDAO {
	
		static Connection conn=null;
		static String query="insert into subject_question_table values(?,?,?,?,?,?,?,?)";
		static int rows;
		static ResultSet resultSet;
		static List<SubjectBean> subList=new ArrayList<SubjectBean>();
		static PreparedStatement preparedStatement;
		
	
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
			
			GetConnectionFactory.closeConnection(conn);
			
			
		}
		catch(SQLException ex){
			System.out.print("Error Took Place");
		}
		return rows;
	}
	
	public static List<SubjectBean> retrieve(){
		conn=GetConnectionFactory.getDbConnection();
		SubjectBean subBean;
				
		
		try{
			preparedStatement=conn.prepareStatement("select * from subject_question_table order by rand()");
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
			subBean.setAnswer((resultSet.getCharacterStream(8)).toString());
			
			subList.add(subBean);
			}
			GetConnectionFactory.closeConnection(conn);
			
		}
		catch(SQLException ex){
			System.out.println("Error");
		}
		
		return subList;
		
	}
}
