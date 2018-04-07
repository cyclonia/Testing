package com.onlinetest.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinetest.dao.SubjectDAO2;

@WebServlet("/DeleteQuestionServlet")
public class DeleteQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
	HttpSession session;
	RequestDispatcher requestDispatcher;
	String questionId;
	int row;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		out=response.getWriter();
		
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
		
			questionId=request.getParameter("question_id");
		
			row=SubjectDAO2.deleteQuestion(questionId);
				if(row>0){
					requestDispatcher=request.getRequestDispatcher("DeleteQuestionForm.jsp");
					requestDispatcher.include(request, response);
					out.print("<h1>Question deleted</h1>");
				}
				else{
					requestDispatcher=request.getRequestDispatcher("DeleteQuestionForm.jsp");
					requestDispatcher.include(request, response);
					out.print("<h1>Question Not found</h1>");
				}
		}
		
	}

}
