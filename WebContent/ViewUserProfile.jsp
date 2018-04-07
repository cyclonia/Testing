<%@page import="com.onlinetest.beans.RegistrationBean"%>
<%@page import="com.onlinetest.beans.FullStudentDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.onlinetest.beans.FullStudentDetail" %>
    <%@ page import="java.sql.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Style.css" />

<title>User Profile</title>
</head>
<script type="text/javascript" src="sliderman.1.3.6.js"></script>
<body>
<div id="container">
<div id="logout"><font face="verdana" color="Cyan" size=3><a href="LogoutServlet">Logout</a></font></div>
		<div class="slider">
                    <div id="SliderName_2" class="SliderName_2">		

					<img src="1.jpg" width="740" height="300" title="Demo2 first" usemap="#img1map" />
					<img src="2.jpg" width="740" height="300"  title="Demo2 second" />
					<img src="3.jpg" width="740" height="300"  title="Demo2 third" />
					<img src="4.jpg" width="740" height="300"  title="Demo2 fourth" />
					 <img src="5.jpg" width="740" height="300" title="Demo2 fifth" />	
				
					</div>
				<div class="c"></div>
				 <div id="SliderNameNavigation_2"></div> 
				<div class="c"></div>
				<script type="text/javascript">
					 effectsDemo2 = 'rain,stairs,fade'; 
					 var demoSlider_2 = Sliderman.slider({container: 'SliderName_2', width: 740, height: 275, effects: effectsDemo2,
						display: {
									autoplay: 3000,
									loading: {background: '#000000', opacity: 0.5, image: 'img/loading.gif'},
									buttons: {hide: true, opacity: 1, prev: {className: 'SliderNamePrev_2', label: ''}, next: {className: 'SliderNameNext_2'}},
									description: {hide: true, background: '#000000', opacity: 0.4, height: 20, position: 'bottom'},
									navigation: {container: 'SliderNameNavigation_2'}
								 }
														}); 
				</script>
			

	</div>   
        
      <div id="menu"><table><tr><td>
       <font color="#3C3504" size="6">	HALDIA </font></td><td> <font color="#3C3504" size="6"> INSTITUTE</font></td><td> <font color="#3C3504" size="6">   OF  </font></td><td><font color="#3C3504" size="6">  TECHNOLOGY</font></td></tr></table>
        </div>
        
        </div>
   <div id="content">
<font color="green" size="5">Hello <b><%=session.getAttribute("userEmail") %></b><br></font><font color="purple" size="5"><br>Your Profile :<br>
   </div>     
<table border="1" width="750">
<%
List<RegistrationBean> userDetails;
userDetails=(List<RegistrationBean>)request.getAttribute("userDetails");


if(!userDetails.isEmpty()){

for(RegistrationBean detail:userDetails){
%>

<tr ><td>First Name:</td> <td ><%=detail.firstName %></td></tr>
		
<tr><td>Last name:</td>	<td><%=detail.lastName %></td></tr>
		
<tr><td>Email :</td> <td><%=detail.email %></td></tr>
		
<tr><td>Branch :</td> <td><%=detail.branch %></td></tr>
		
<tr><td>Semester :</td>		<td><%=detail.semester %></td></tr>
		
<tr><td>D.O.B :</td>	<td><%=detail.dob %></td></tr>
		
<tr><td>Gender :</td>	<td><%=detail.gender %></td></tr>
		
<tr><td>Address :</td>		<td><%=detail.address %></td></tr>

<tr><td>Registration Number :</td><td><%=detail.studentId %></td></tr>


<%
}
}

%>
</table>
<font color="green" size="5"> Go To <a href="UserHomePage.jsp">Home</a></font><br><br>
</body>
</html>