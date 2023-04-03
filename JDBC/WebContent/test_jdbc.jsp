<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="CJSTL" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Tests JDBC</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>"/>
	</head>
	
	<body>
		<h1>Tests JDBC </h1>
		
		<c:forEach items="${messages}" var="message" varStatus="boucle">
			<p>${boucle.count}.${message}</p>
		</c:forEach>
	</body>
</html>