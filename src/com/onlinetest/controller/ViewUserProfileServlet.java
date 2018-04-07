package com.onlinetest.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import com.onlinetest.beans.FullStudentDetail;
import com.onlinetest.beans.RegistrationBean;
//import com.onlinetest.dao.FullStudentDetailDAO;
import com.onlinetest.dao.RegistrationDAO;
import java.util.List;


@WebServlet("/ViewUserProfileServlet")
public class ViewUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	RequestDispatcher requestDispatcher;
	String email;
	List<RegistrationBean> userDetail;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		//session
		
		session=request.getSession(false);
		if (session == null || session.getAttribute("userEmail") == null) {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("UserLogin2.jsp");
			requestDispatcher.include(request, response);
			
		         response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		         response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		         response.setDateHeader("Expires", 0);
		            
		}
		
		else{
			
			email=(String)session.getAttribute("userEmail");
			userDetail=RegistrationDAO.selectByEmail(email);
			
			request.setAttribute("userDetails",userDetail);
			requestDispatcher=request.getRequestDispatcher("ViewUserProfile.jsp");
			requestDispatcher.forward(request, response);
			
			
		}
				
		
		
		
	}

}
