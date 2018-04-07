<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Style.css" />
<title>Change Password</title>
<script type="text/javascript"> 
function check()
{

	if(document.change_password.new_password.value!=document.change_password.retype_new_password.value)
		
	{
	alert("Password not matched");
	return false;
	
	}
else 
	return true;
}
</script>
</head>
<script type="text/javascript" src="sliderman.1.3.6.js"></script>

<body>
<%
session.getAttribute("adminName");
%>
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
        <br>
   <form action="ChangePasswordServlet" method="post" onsubmit="return check()" name="change_password">

<table>
<tr><td colspan=2 ><font face="tahoma" size="5"><u>Change Password :<%=session.getAttribute("adminName") %></u></font></td></tr>
</table><br>
<table>
<tr><td><b><font face="Verdana">Old Password : </font></b></td><td><input type="password" name="old_password" required="required"></td></tr>
<tr><td><b><font face="Verdana">New Password : </font></b></td><td><input type="password" name="new_password" required="required"></td></tr>
<tr><td><b><font face="Verdana">Retype New Password : </font></b></td><td><input type="password" name="retype_new_password" required="required"></td></tr>

</table>
<br>
<table>
<tr><td><input type="submit" name="change" value="Change Password"></td><td><input type="reset" name="reset" value="Reset"></td></tr>


</table>

</form><br><br>
<font face="verdana" color="blue" size=3>Go To <a href="AdminHomePage.jsp">Admin Home </a></font>
</body>
</html>