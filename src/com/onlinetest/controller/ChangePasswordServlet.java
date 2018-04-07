package com.onlinetest.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.onlinetest.beans.ChangePassBean;
import com.onlinetest.dao.ChangePasswordDAO;



@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static Connection conn=null;
       static ResultSet rs=null;
       HttpSession session;
       RequestDispatcher requestDispatcher;
       String userName;
       ChangePassBean passwordInfoBean;
       int confirmation;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("Text/html");
		
		
		
		//Session
		session=request.getSession(false);
		userName=(String)session.getAttribute("adminName");
		if(userName.equals((String)session.getAttribute("adminName"))){
			
			if (session == null || session.getAttribute("adminName") == null) {
				requestDispatcher=request.getRequestDispatcher("AdminLogin2.jsp");
				requestDispatcher.include(request, response);
		
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
				response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
				response.setDateHeader("Expires", 0);
			}
		
			else{
				passwordInfoBean=new ChangePassBean();
				passwordInfoBean.setOldPass(request.getParameter("old_password"));
				passwordInfoBean.setNewPass(request.getParameter("new_password"));
				passwordInfoBean.setConfirmNewPass(request.getParameter("retype_new_password"));
				passwordInfoBean.setUserName((String)session.getAttribute("adminName"));
				
				
				confirmation=ChangePasswordDAO.changeAdminPass(passwordInfoBean);
			
					if(confirmation>0){
						requestDispatcher=request.getRequestDispatcher("AdminHomeAfterChangePass.jsp");
						requestDispatcher.forward(request, response);
					}
		
			
			}
			
		
		}
		
	}

}
