package com.onlinetest.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.onlinetest.beans.RegistrationBean;
import com.onlinetest.dao.RegistrationDAO;


@WebServlet("/ShowDetailsToAdmin")
public class ShowDetailsToAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	RequestDispatcher requestDispatcher;
	List<RegistrationBean> studentDetails=new ArrayList<RegistrationBean>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
			studentDetails=RegistrationDAO.selectAll();
		
			request.setAttribute("sDetails",studentDetails);
			requestDispatcher=request.getRequestDispatcher("ViewScore.jsp");
			requestDispatcher.forward(request, response);
				
		}
	}

}
