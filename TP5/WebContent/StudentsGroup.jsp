<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.project.dao.StudentDao,com.project.bean.Student,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
	<title>Liste des Etudiants</title>
</head>
<body>
	
	<%
	List<Student> list=StudentDao.getAllRecords();
	request.setAttribute("list",list);
	%>
		<table border="1" width="90%">
		
			<tr>
				<th>Numéro Inscription</th>
				<th>Nom et Prénom</th>
				<th>Date Naissance</th>
				<th>Email</th>
			</tr>
			
			<c:forEach items="${list}" var="s">
				<tr>
					<td>${s.numeroInscrption}</td>
					<td>${s.nom};${s.prenom}</td>
					<td>${s.datenaissance}</td>
					<td>${s.email}</td>
				</tr>
			</c:forEach>
			
		</table>
	
	<br/><a href="addetud.html">Ajouter un nouvel Etudiant à ce groupe</a>

</body>
</html>