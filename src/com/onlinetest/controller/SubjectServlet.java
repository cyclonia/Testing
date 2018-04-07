package com.onlinetest.controller;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.onlinetest.beans.SubjectBean;
import com.onlinetest.dao.SubjectDAO;



@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher requestDispatcher;
	SubjectBean subject=new SubjectBean();
	List<SubjectBean> subList=new ArrayList<SubjectBean>();
	HttpSession session;
	int rows;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//Session
		session=request.getSession(false);
	
	if (session == null || session.getAttribute("adminName") == null) {
		
		requestDispatcher=request.getRequestDispatcher("AdminLogin2.jsp");
		requestDispatcher.include(request, response);
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0);

	}
				
	else{
		
		subject.setSubject(request.getParameter("subject"));
		subject.setQuestionId(request.getParameter("questionId"));
		subject.setQuestion(request.getParameter("question"));
		subject.setChoiceA(request.getParameter("choiceA"));
		subject.setChoiceB(request.getParameter("choiceB"));
		subject.setChoiceC(request.getParameter("choiceC"));
		subject.setChoiceD(request.getParameter("choiceD"));
		subject.setAnswer(request.getParameter("answer"));
		
		subList.add(subject);
		
		rows=SubjectDAO.insert(subList);
		
		if(rows>0){
			
			requestDispatcher=request.getRequestDispatcher("AddQuestions.jsp");
			requestDispatcher.include(request, response);
			out.println("<table><tr><td><h1>Data Inserted</h1></td></tr>");
		}
		
	}
		
	}

}
