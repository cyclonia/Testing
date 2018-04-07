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

<script type="text/javascript">
function noBack(){window.history.forward();}
noBack();
window.onload=noBack;
window.onpageshow=function(evt){if(evt.persisted)noBack();}
window.onunload=function(){void(0);}
</script>


<script type="text/JavaScript">

minutesToCount = 10;

function startclock() {

  if (minutesToCount!=0) {
    finalTime = new Date();
    minutesEnd = finalTime.getMinutes() + minutesToCount;
    finalTime.setMinutes(minutesEnd, finalTime.getSeconds(), finalTime.getMilliseconds());
    minutesToCount = 0;
  }

currentTime = new Date();
  milliSecLeft = finalTime.getTime() - currentTime.getTime();
  currentTime.setTime(milliSecLeft);

  //Calculate and format the time elements
  minutes = currentTime.getMinutes();
  if (minutes < 10) { minutes = '0' + minutes; }
  seconds = currentTime.getSeconds();
  if (seconds < 10) { seconds = '0' + seconds; }
  //milliseconds = currentTime.getMilliseconds();

  //Display the time left
  timeLeftText = minutes + ':' + seconds;
  document.getElementById('timeLeft').innerHTML = timeLeftText;

  //Recall the function if there is time left - or display end time
 if (milliSecLeft > 0) {
    setTimeout("startclock()",10);
  } else {
    document.getElementById('timeLeft').innerHTML = '00:00';
	alert("Time Out");
	var t=setTimeout("document.myform.submit();",0);
	//or you can use
	//document.myform.submit.click();

  }
}


</script>


</head>

<body onload="startclock()">

<div id="container">
<div id="logout"><font face="verdana" color="Cyan" size=3><a href="LogoutServlet">Logout</a></font></div>
		
            
      
        <div id="menu">
        	<table><tr><td>
       <font color="#3C3504" size="6">	HALDIA </font></td><td> <font color="#3C3504" size="6"> INSTITUTE</font></td><td> <font color="#3C3504" size="6">   OF  </font></td><td><font color="#3C3504" size="6">  TECHNOLOGY</font></td></tr></table>
    
        </div>
        </div>
        <div id="content">
       <font face="verdana" color="green" size=5> <%="User Id  :" +(String)session.getAttribute("userEmail") %></font>
        </div>
       <font face="verdana" color="red" size="6"> Time Left : <span id="timeLeft"></span></font>
        
        
<form action="ResultServlet" method="get" name="myform">
<table bgcolor="#C0C0C0" align="center" width="800">
<font face="verdana" size="6">

<%

String type=(String)request.getAttribute("type2");
request.setAttribute("type",type);





List<SubjectBean> list;
int index=1;
int i=1;
list=(List<SubjectBean>)(request.getAttribute("subList"));
List<SubjectBean> copyList=list;






for(SubjectBean s:list){
%>
	<tr><td><%=index+". .  "+s.question %></td></tr>
			<tr>
				<td>
					<input type="radio" name=<%=i%> value="a"><%="A : "+s.choiceA %>
				</td>
				
				<td><input type="radio" name=<%=i%> value="b"><%="B : "+s.choiceB %>
				</td>
			</tr>
			
			
			<tr>
				<td>
					<input type="radio" name=<%=i%> value="c"><%="C : "+s.choiceC %>
				</td>
				
				<td><input type="radio" name=<%=i%> value="d"><%="D : "+s.choiceD %>
				</td>
			</tr>
			<tr><td colspan="2"><hr></td></tr>
			
		
			
<%
index++;
i++;


}%>
</font>
</table><br>

<table align="center">
<tr>
<td colspan="2">
<!-- <input type="submit" value="SUBMIT"> --><button type="submit" class="get" onclick="window.location.href='ResultServlet'"><b>&nbsp;&nbsp;&nbsp;SUBMIT</b></button>
</td><td><button type="button" onclick="window.location.href='\HomePage.html'"><b>&nbsp;&nbsp;&nbsp;&nbsp;ABORT</b></button></td></tr>
</table>




</form>




<br><br><br><br><br><br><br><br>
</body>
</html>