
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="Style.css" />
<title>Welcome to Haldia Institute of Technology</title>
</head>

<script type="text/javascript" src="sliderman.1.3.6.js"></script>
<body>

<div id="container">
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
		<div id="content">
		
		<font face="verdana" color="red" size=5>User Name or Password is Wrong !!!</font>
		</div>
<br><form action="LoginServlet" method="post">

<table>
<tr><td colspan=2 ><font face="tahoma" size="5"><u>Student Login</u></font></td></tr>
</table><br>
<table>
<tr><td><b><font face="Verdana">User Id : </font></b></td><td><input type="text" name="userEmail" required="required"></td></tr>
<tr><td><b><font face="Verdana">Password : </font></b></td><td><input type="password" name="password" required="required"></td></tr>
</table>
<br>
<table>
<tr><td><button type="submit" name="submit" class="post">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>LOGIN</b></button></td><td><button type="button" name="cancel" onclick="window.location.href='\HomePage.html'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>CANCEL</b></button></td><td><button type="reset">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>RESET</b></button></td></tr>

</table>

</form>
<br>
 <font face="Verdana">New User Please <a href="UserSignUp.html">Sign Up</a> First !  </font>
 <br><br><br><br><br>
            
</body>
</html>
