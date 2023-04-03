<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.project.dao.GroupDao,com.project.bean.Group,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
	<title>Liste des Groupes d'enseignements</title>
</head>
<body>
<%
	List<Group> list=GroupDao.getAllRecords();
	request.setAttribute("list",list);
%>
	<table border="1" width="90%">
		<tr>
			<th>Libéllé Groupe</th>
			<th>Niveau</th>
			<th>Description</th>
			<th>Nombre d'étudients</th>
		</tr>
		<c:forEach items="${list}" var="g">
		<tr>
			<td>${g.libelle}</a></td>
			<td>${g.niveau}</td>
			<td>${g.Description}</td>
			<td>${g.Nombre}</td>
		</tr>
		</c:forEach>
	</table>
<br/><a href="addens.html">Ajouter un Nouveau Groupe d'enseignement</a>
</body>
</html>