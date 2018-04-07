<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.onlinetest.beans.SubjectBean" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Questions</title>
</head>

<body>

<div id="container">
<div id="logout"><font face="verdana" color="Cyan" size=3><a href="LogoutServlet">Logout</a></font></div>
		
            
       <br><table><tr><td><h1>HALDIA INSTITUTE OF TECHNOLOGY</h1></td></tr></table>
        
        <div id="menu">
        	<ul>
            	<li class="menuitem"><a href="HomePage.html">Home</a></li>
                <li class="menuitem"><a href="AboutUs.html">About Us</a></li>
                <li class="menuitem"><a href="OnlineTest.html">Online Test</a></li>
                
                <li class="menuitem"><a href="ContactUs.html">Contact Us</a></li>
              <li class="menuitem"><a href="UserLogin.html">Student Login</a></li>
               <li class="menuitem"><a href="UserSignUp.html">Sign Up</a></li>
            </ul>
        </div>
        </div>
        
        

<table  align="center" width="800">
<tr><th>Subject</th><th>QId</th><th>question</th><th>choice A</th><th>choice B</th><th>choice C</th><th>choice D</th><th>Answer</th></tr>


<%
List<SubjectBean> list;

list=(List<SubjectBean>)(request.getAttribute("subList"));
for(SubjectBean s:list){
%>
<tr>
	<td><%=s.subject %></td>
	<td><%=s.questionId %></td>
	<td><%=s.question %></td>
	<td><%=s.choiceA %></td>
	<td><%=s.choiceB %></td>
	<td><%=s.choiceC %></td>
	<td><%=s.choiceD %></td>
	<td><%=s.answer %></td>
</tr>	
		
			
<%
}%>



</table><br>

<table align="center">
<tr>
<td colspan="2">
<button type="button" name="OK" onclick="window.location.href='ShowSubjectsToAdmin.jsp'">&nbsp;<b>BACK</b></button>
</table>

<br><br><br><br><br><br><br><br>
</body>
</html>