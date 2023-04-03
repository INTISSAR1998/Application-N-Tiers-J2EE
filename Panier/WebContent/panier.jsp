<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ taglib uri="CJSTL" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Panier</title>
</head>
<body>
	<a href="AddFruit?fruit=Banane">Ajouter banane</a><br>
	<a href="AddFruit?fruit=Fraise">Ajouter fraise</a><br>
	<a href="AddFruit?fruit=Orange">Ajouter orange</a><br>
	<br/>
	
	<c:if test="${empty sessionScope}">
		<h3>Pas de fruit dans le panier !</h3>
	</c:if>
	
	<c:if test="${not empty sessionScope}">
		<c:forEach var="fruit" varStatus="status" items="${sessionScope}" >
			<c:if test="${status.first }">
				<table border="1">
					<thead>
						<tr>
							<td style="font-weight:bold">Fruit</td>
							<td style="font-weight:bold">Montant</td>
						</tr>
					</thead>
				<tbody>
			</c:if>
			<tr>
				<td>${fruit.key}</td>
				<td>${fruit.value}</td>
			</tr>
			<c:if test="${status.last}">
				</tbody>
				</table>
			</c:if>
		</c:forEach>
	</c:if>
</body>
</html>