<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="CJSTL" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<c:set var="test1" value="toto" scope="page"></c:set>
	<% pageContext.setAttribute("test2","titi"); %>
	<c:out value="${test1}" default="rien"></c:out>
	<br>
	${test2}
	<br>
	<jsp:useBean id="B1" class="monpackage.MonBean" scope="page"/>
	<c:set target="${B1}" value="Bonjour" property="name"/>
	<c:out value="${B1.name}"/>
</body>
</html>