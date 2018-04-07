package com.onlinetest.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.onlinetest.beans.RegistrationBean;
import com.onlinetest.dao.RegistrationDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	java.util.Date javaDate;
	java.sql.Date sqlDate;
	RegistrationBean regBean=null;
	List<RegistrationBean> registrationList=null;
	String firstName=null;
	String branch=null;
	String day=null;
	String month=null;
	String year=null;
	String dob=null;
	SimpleDateFormat sdfDate;
	String firstNameSubString=null;
	String lastNameSubString=null;
	String dob2=null;
	String regNumber=null;
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		regBean=new RegistrationBean();
		
		
		firstName=request.getParameter("studentFirstName");
		regBean.setFirstName(firstName);
		regBean.setLastName(request.getParameter("studentLastName"));
		regBean.setEmail(request.getParameter("email"));
		branch=(request.getParameter("branch"));
		regBean.setBranch(branch);
		regBean.setSemester(request.getParameter("semester").toString());
		
	//date handling
		day=request.getParameter("dobDay");
		month=request.getParameter("dobMonth");
		year=request.getParameter("dobYear");
		dob=day.concat("/"+month).concat("/"+year).toString();
		sdfDate=new SimpleDateFormat("dd/mm/yyyy");
		try {
			javaDate=sdfDate.parse(dob);
			sqlDate=new java.sql.Date(javaDate.getTime());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		regBean.setDob(sqlDate);
		regBean.setGender(request.getParameter("gender"));
		regBean.setAddress(request.getParameter("studentAddress"));
		regBean.setPassword(request.getParameter("password"));
		
	//Generation of Registration Number
		firstNameSubString=firstName.substring(0,1);
		lastNameSubString=request.getParameter("studentLastName").substring(0,1);
		dob2=day.concat(month).concat(year);
	
		regNumber=firstNameSubString.concat(lastNameSubString).concat(dob2).concat(branch);
		regBean.setStudentId(regNumber);
		
		registrationList=new ArrayList<RegistrationBean>();
		registrationList.add(regBean);
		
		
		int rows=RegistrationDAO.insert(registrationList);
		if(rows>0){
			request.setAttribute("regUser",firstName);
			request.setAttribute("regNumber", regNumber);
			RequestDispatcher rd=request.getRequestDispatcher("UserLoginAfterReg.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
