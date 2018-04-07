package com.onlinetest.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.onlinetest.beans.RegistrationBean;
import com.onlinetest.dao.RegistrationDAO;


@WebServlet("/ShowIndividualDetailsToAdmin")
public class ShowIndividualDetailsToAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String studentRegNumber;
	//List<RegistrationBean> studentDetail;
	RegistrationBean studentDetail;
	RequestDispatcher requestDispatcher;
	HttpSession session;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		studentRegNumber=(request.getParameter("student_registration_no"));
		
		session=request.getSession(false);

		if (session == null || session.getAttribute("adminName") == null) {
			requestDispatcher=request.getRequestDispatcher("AdminLogin2.jsp");
			requestDispatcher.include(request, response);
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0);
            
		}
		else{
		studentDetail=RegistrationDAO.selectByRegNumber(studentRegNumber);
		request.setAttribute("StudentDetailByRegNo", studentDetail);
		requestDispatcher=request.getRequestDispatcher("ShowIndividualToAdmin.jsp");
		requestDispatcher.forward(request, response);
		
		}
		
	}

}
