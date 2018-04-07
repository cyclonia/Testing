<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Style.css" />
<title>Admin Home</title>
</head>
<script type="text/javascript" src="sliderman.1.3.6.js"></script>

<body>
<div id="container">
<div id="logout"><a href="LogoutServlet"><h2>Logout</h2></a><br>
<a href="ChangePassword.jsp"><h2>Change<br>Password</h2></a>
</div>
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
		
		<table><tr><td><font face="verdana" color="red" size=5>Welcome  <%=(String)session.getAttribute("adminName") %> </font></td></tr></table>
 		</div>
    
<%-- <table width="750" align="center"><tr><h2>Welcome   :<%=(String)session.getAttribute("adminName") %></h2></tr></table> --%> 
<table width="750" ><tr><th><h2>Know About Registered Students</h2></th></tr>
<table border="1" width="750">

<tr><!-- <td><a href="ViewStudentDetailForm.jsp"><img src="StudentScore.png"></a></td> -->

<td colspan=2><a href="ShowDetailsToAdmin"><img src="RegisteredStudentsDetails.png"></a></td></tr>

</table>
<br>
<br>
<table width="750"><tr><th><h2>Test Related Operations</h2></th></tr></table>
<table border="1" width="750">

<tr><td><a href="AddQuestions.jsp"><img src="AddQuestions.png"></a></td>

<td><a href="DeleteQuestionForm.jsp"><img src="DeleteQuestions.png"></a></td></tr>
<tr><td><a href="ShowSubjectsToAdmin.jsp"><img src="ViewSubjects.png"></a></td><td></td></tr>
<tr><td colspan=2></td></tr>
</table>
<br>

<font face="verdana" color="blue" size=3>Go To <a href="HomePage.html"> Home Page</a></font><br><br>
</body>
</html>