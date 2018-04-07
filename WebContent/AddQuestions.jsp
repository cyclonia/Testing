<html>
<head><title>Add Questions</title>
<link rel="stylesheet" type="text/css" href="Style.css" />

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




<form action="SubjectServlet" method="post">

<center><table>
<tr><td colspan="2"><h1>Add Questions</h1></td></tr>
<tr><td>Subject : </td><td><input type="text" name="subject" required="required"></td></tr>
<tr><td>Question Id : </td><td><input type="text" name="questionId" required="required"></td></tr>
<tr><td>Question : </td><td><input type="text" name="question" size="50" required="required"></td></tr>
<tr><td>Choice A : </td><td><input type="text" name="choiceA" required="required"></td></tr>
<tr><td>Choice B : </td><td><input type="text" name="choiceB" required="required"></td></tr>
<tr><td>Choice C : </td><td><input type="text" name="choiceC" required="required"></td></tr>
<tr><td>Choice D : </td><td><input type="text" name="choiceD" required="required"></td></tr>
<tr><td>Answer :  </td><td><input type="text" name="answer" required="required"></td></tr>
<tr><td colspan="1"><input type="submit" value="Submit" name="submit"> </td><td colspan="1"><input type="reset" value="Reset"></tr>


</table>
</center>
</form>
<br>
<font face="verdana" color="blue" size=3>Go To <a href="AdminHomePage.jsp">Admin Home </a></font><br><br>
</body>
</html>