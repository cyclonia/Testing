<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.List" %>
    <%@ page import="java.sql.Date" %>
   
    <%@ page import="com.onlinetest.beans.RegistrationBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Style.css" />

<title>Student Details</title>
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
<font color="green" size="5">
<table border="1" width="750">
		<!-- <tr><th>First Name</th><th>Last Name</th><th>Email</th><th>Branch</th><th>Semester</th><th>DOB</th><th>Gender</th><th>Address</th></tr> -->
<%
RegistrationBean detail;
detail=(RegistrationBean)request.getAttribute("StudentDetailByRegNo");


%>

<tr ><td>First Name:</td> <td ><%=detail.firstName %></td></tr>
		
<tr><td>Last name:</td>	<td><%=detail.lastName %></td></tr>
		
<tr><td>Email :</td> <td><%=detail.email %></td></tr>
		
<tr><td>Branch :</td> <td><%=detail.branch %></td></tr>
		
<tr><td>Semester :</td>		<td><%=detail.semester %></td></tr>
		
<tr><td>D.O.B :</td>	<td><%=detail.dob %></td></tr>
		
<tr><td>Gender :</td>	<td><%=detail.gender %></td></tr>
		
<tr><td>Address :</td>		<td><%=detail.address %></td></tr>
			
	
		




<%


%>
</table><br><br>
<font color="green" size="5"> Go To <a href="HomePage.html">Home</a></font><br><br>

</body>
</html>