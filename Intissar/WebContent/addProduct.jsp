<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter Produits</title>
</head>
<body>
	<form method="post" action="ajout">
	<table>   
			<tr>
				<td>Libellé :</td>
				<td><input type="text" name="name"/></td>
			</tr>   
     		<tr>
     			<td>Prix :</td>
     			<td><input type="password" name="password"/></td>
     		</tr>   
            <tr>
            	<td colspan="2"><input type="submit" value="Ajouter les données"/></td>
            </tr>   
        </table>   
	</form>
</body>
</html>