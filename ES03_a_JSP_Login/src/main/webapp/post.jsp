<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		String user = request.getParameter("user");
		String psw = request.getParameter("password");
		
		if(user.equals("libertino") && psw.equals("ciao")){
			out.print("Benvenuto "+ user);
		}else{
			out.print("Credenziali errate!!!!");
	%>	
			<br>Torna a <a href="login.jsp">login</a>
	<%
		}
	%>
</body>
</html>