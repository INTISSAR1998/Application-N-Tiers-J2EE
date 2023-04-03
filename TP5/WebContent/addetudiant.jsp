<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<%@page import="com.project.dao.StudentDao"%>
	<jsp:useBean id="s" class="com.project.bean.Student"></jsp:useBean>
	<jsp:setProperty property="*" name="s"/>
	<%   
	int i=StudentDao.save(s);   
	if(i>0){  
		response.sendRedirect("adduser-success-etu.jsp");  
		}else{  
			response.sendRedirect("adduser-error_etu.jsp"); 
			}  
	%> 
</body>
</html>