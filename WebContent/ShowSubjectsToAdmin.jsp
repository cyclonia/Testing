<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
        
        <div id="menu">
        	<ul>
            	<li class="menuitem"><a href="HomePage.html">Home</a></li>
                <li class="menuitem"><a href="AboutUs.html">About Us</a></li>
                <li class="menuitem"><a href="OnlineTest.jsp">Online Test</a></li>
                
                <li class="menuitem"><a href="ContactUs.html">Contact Us</a></li>
              <li class="menuitem"><a href="UserLogin.html">User Login</a></li>
               <li class="menuitem"><a href="UserSignUp.html">Sign Up</a></li>
            </ul>
        </div>
   </div>

<form method="post" action="ShowSubjectsToAdminServlet">
<table>

<tr><td>
<select name="type">
	<option selected="selected">Choose subject</option>
	<option value="java">java</option>
	<option value="c">c</option>
	<option value="cpp">c++</option>

</select>
</td></tr>

<tr><td><input type="submit" value="Show"></td></tr>

</table>

</form>

</body>
<br>
<font face="verdana" color="blue" size=3>Go To <a href="AdminHomePage.jsp">Admin Home </a></font>
</html>