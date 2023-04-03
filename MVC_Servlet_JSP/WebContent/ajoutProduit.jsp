<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Produit" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Produit prod =(Produit) request.getAttribute("model");
	%>
	<h1>Afficher les informations du produit</h1>
	<table>
		<tr>
			<td>Code produit :</td>
			<td><%= prod.getCodeProduit() %></td>
		</tr>
		
		<tr>
			<td>Désignation :</td>
			<td><%= prod.getDesignation() %></td>
		</tr>
		
		<tr>
			<td>Prix :</td>
			<td><%= prod.getPrix()%></td>
		</tr>
	</table>
</body>
</html>