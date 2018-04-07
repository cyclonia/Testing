package com.onlinetest.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.onlinetest.beans.ResultBean;
import com.onlinetest.beans.SubjectBean;
import com.onlinetest.dao.ResultDAO;
import com.onlinetest.dao.SubjectDAO2;
import java.util.List;
import java.util.ArrayList;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String userAnswer[];
	List<SubjectBean> subList;
	HttpSession session;
	List<ResultBean> resultList=null;
	ResultBean result=null;
	RequestDispatcher requestDispatcher;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		//String sub=(String)request.getParameter("type");
		try{
		userAnswer=new String[10];
		userAnswer[0]=(String)request.getParameter("1");
		userAnswer[1]=(String)request.getParameter("2");
		userAnswer[2]=(String)request.getParameter("3");
		userAnswer[3]=(String)request.getParameter("4");
		userAnswer[4]=(String)request.getParameter("5");
		userAnswer[5]=(String)request.getParameter("6");
		userAnswer[6]=(String)request.getParameter("7");
		userAnswer[7]=(String)request.getParameter("8");
		userAnswer[8]=(String)request.getParameter("9");
		userAnswer[9]=(String)request.getParameter("10");
		
	
			String subject=request.getParameter("type");
			subList=SubjectDAO2.retrieve(subject);
			int sum=0;
			if(subList!=null){
				
				int i=0;
				for(SubjectBean subBean:subList){
					
					if(userAnswer[i].equals(subBean.answer)){
						sum=sum+1;
						i++;
					}
		
				}
			}
			String sub=subList.get(0).subject;
			
			
			session=request.getSession(false);
			resultList=new ArrayList<ResultBean>();
			result=new ResultBean();
			result.setEmailId((String)session.getAttribute("userEmail"));
			result.setMarksObtained(sum);
			result.setTestSubject(sub);
			resultList.add(result);
			
			int row=ResultDAO.insert(resultList);
			
			if(row>0)
			{
		
			request.setAttribute("score",sum);
			requestDispatcher=request.getRequestDispatcher("ShowResults.jsp");
			requestDispatcher.forward(request, response);
			}
		}
		catch(NullPointerException ex){
			requestDispatcher=request.getRequestDispatcher("ErrorPage.jsp");
			requestDispatcher.forward(request, response);
		}
		catch(IndexOutOfBoundsException ex){
			requestDispatcher=request.getRequestDispatcher("ErrorPage.jsp");
			requestDispatcher.forward(request, response);
		}
			
	}
}
