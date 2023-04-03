<%@ page import="java.util.Vector" %>
<%@ page import="model.Errors" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="Verification">
Login<input type="text" name="login">
Password<input type="password" name="password">
connecter<input type="submit" value="submit">
</form>

<%
if(session.getAttribute("error")!=null)
{

	
	
for(Errors s :(Vector<Errors>)session.getAttribute("error"))	
{
	if(s.getType()=="notExist")
	{
		out.print(s.getMsg());

	}
	else if(s.getType()=="notConnected")
	{
		out.print(s.getMsg());

	}	
}
}

%>


</body>
</html>