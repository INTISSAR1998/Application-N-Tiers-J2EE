<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un Etudiant</title>
</head>
<body>
	<form method="post" action="procces.jsp">
		<table>
			<tr>
				<td>Numéro Inscription :</td>
				<td><input type="text" name="num_insc"></td>
			</tr>
			
			<tr>
				<td>Nom et Prénom :</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td>Date Naissance :</td>
				<td><input type="text" name="date_birth"></td>
			</tr>
			
			<tr>
				<td>Email :</td>
				<td><input type="text" name="email"></td>
			</tr>
			
			<tr>
				<td colspan="2"><center><input type="submit" value="Ajouter"></center></td>
			</tr>
		</table>
	</form>
</body>
</html>