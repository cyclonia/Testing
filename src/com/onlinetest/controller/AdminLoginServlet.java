package com.onlinetest.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.onlinetest.dao.AdminLoginCheck;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String adminId;
	String userPass;
	HttpSession session;
	RequestDispatcher requestDispatcher;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		adminId=request.getParameter("admin_id");
		userPass=request.getParameter("admin_password");
	
		String userPassFromDb=AdminLoginCheck.getPass(adminId);
		session=request.getSession(false);
		
		if(userPass.equals(userPassFromDb)){
			
			session=request.getSession(true);
			session.setAttribute("adminName",adminId);
			requestDispatcher=request.getRequestDispatcher("AdminHomePage.jsp");
			requestDispatcher.forward(request, response);
		}
		else{
			requestDispatcher=request.getRequestDispatcher("AdminLoginForWrongPass.jsp");
			requestDispatcher.include(request, response);
			
		}
		
	}

}
