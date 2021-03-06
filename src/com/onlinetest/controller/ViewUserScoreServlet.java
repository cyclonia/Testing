package com.onlinetest.controller;
import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import com.onlinetest.beans.RegistrationBean;
import com.onlinetest.beans.ResultBean;
import com.onlinetest.dao.RegistrationDAO;


@WebServlet("/ViewUserScoreServlet")
public class ViewUserScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	RequestDispatcher requestDispatcher;
	String email;
	List<ResultBean> userDetail;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		
		session=request.getSession(false);
		if (session == null || session.getAttribute("userEmail") == null) {
			requestDispatcher=request.getRequestDispatcher("UserLogin2.jsp");
			requestDispatcher.include(request, response);
			
		         response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		         response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		         response.setDateHeader("Expires", 0);
		            
		}
		
		else{
			
			
			email=(String)session.getAttribute("userEmail");
			userDetail=RegistrationDAO.selectByEmailFromExamTable(email);
			request.setAttribute("userDetails",userDetail);
			requestDispatcher=request.getRequestDispatcher("ViewUserScore.jsp");
			requestDispatcher.forward(request, response);
			/*for(ResultBean r:userDetail){
				out.print("values ="+r.emailId+"<br>"+r.marksObtained);
			}*/
			
			
		}
				
		
		
	
		
		
	}

}
