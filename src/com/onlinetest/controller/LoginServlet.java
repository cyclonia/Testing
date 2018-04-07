package com.onlinetest.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinetest.dao.LoginCheckDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String userEmail;
	String userPass;
	String userPassFromDb;
	HttpSession session;
	String userName;
	RequestDispatcher requestDispatcher;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		userEmail=request.getParameter("userEmail");
		userPass=request.getParameter("password");
		userPassFromDb=LoginCheckDAO.getPass(userEmail);
		
		if(userPass.equals(userPassFromDb)){
			
			session=request.getSession(true);
			userName=LoginCheckDAO.getName(userEmail);
			session.setAttribute("userEmail",userEmail);
			request.setAttribute("userName",userName);
			requestDispatcher=request.getRequestDispatcher("UserHomePage.jsp");
			requestDispatcher.forward(request, response);
		}
			
		else{
			requestDispatcher=request.getRequestDispatcher("UserLoginWrongPass.jsp");
			requestDispatcher.include(request, response);
		}
		
	}

}
