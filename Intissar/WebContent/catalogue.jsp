<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="dao.CategorieDao,bean.Categorie,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Afficher liste de produits</title>
</head>
<body>

    <%@page import="dao.CategorieDao,bean.Categorie,java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Produits List</h1>

<%
List<Categorie> list=CategorieDao.getAllRecords();
request.setAttribute("list",list);
%>

<table border="1" width="90%">
<tr><th>Id</th><th>Libellé</th><th>Prix</th><th><input type="submit" value="Ajouter produit"/></th></tr>
<c:forEach items="${list}" var="p">
<tr><td>${p.id}</td><td>${p.libellé}</td><td>${p.prix}</td> </tr>
</c:forEach>
</table>
<br/><input type="submit" value="Ajouter produit"/></td>

</body>
</html>