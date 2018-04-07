<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Style.css" />
<title>Instructions</title>
</head>

<body>
<div id="container">
<div id="logout"><font face="verdana" color="Cyan" size=3><a href="LogoutServlet">Logout</a></font></div>
	<%
String email=(String)request.getParameter("email");


%>
	
        
      <div id="menu"><table><tr><td>
       <font color="#3C3504" size="6">	HALDIA </font></td><td> <font color="#3C3504" size="6"> INSTITUTE</font></td><td> <font color="#3C3504" size="6">   OF  </font></td><td><font color="#3C3504" size="6">  TECHNOLOGY</font></td></tr></table>
        </div>
        <div id="content">
        
        <font face="times new roman" color="green" size=6 ><b><u><%=session.getAttribute("userEmail") %></u></font><font face="times new roman" color="330033" size=6> <br>-: Important Instructions for the you :-</b></font><br><br>
       <p ><font face="times new roman" color="330033" size=6>
        1. All questions have four options. You have to chose one correct answer.<br>
        2. Each questions contain 1 marks. <br>
        3. No negetive marking.<br>
        4. You have only 10 minutes for the test.<br>
        5. Select subject to start test.<br></font><font face="times new roman" color="green" size=6>
      6. After clicking start button your time will start.<br>
        7. Do not reload page or press back button during test.
        </font>
        </p><br><br>
    <button type="button" onclick="window.location.href='OnlineTest2.jsp?email=<%=email%>'">PROCEED</button>
    
       </div> </div>
       <br><br>
       <font color="green" size="5"> Go To <a href="UserHomePage.jsp">Home</a></font>
       
</body>
</html>