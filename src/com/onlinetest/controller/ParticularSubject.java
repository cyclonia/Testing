package com.onlinetest.controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.onlinetest.beans.SubjectBean;
import com.onlinetest.dao.SubjectDAO2;


@WebServlet("/ParticularSubject")
public class ParticularSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession session;
	RequestDispatcher requestDispatcher;
	List<SubjectBean> subList=null;
	String subject;

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		//Session
				session=request.getSession(false);
			
				if (session == null || session.getAttribute("userEmail") == null) {
					requestDispatcher=request.getRequestDispatcher("UserLogin2.jsp");
					requestDispatcher.include(request, response);
					
					response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
					response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
					response.setDateHeader("Expires", 0);
	
				}
				else{
					session.getAttribute("userName");
					subject=request.getParameter("type");
					subList=SubjectDAO2.retrieve(subject);
					if(subList!=null){
					request.setAttribute("subList",subList);
					requestDispatcher=request.getRequestDispatcher("DisplayQuestion.jsp");
					requestDispatcher.forward(request, response);
					}
				}
		
	}


}
