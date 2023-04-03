<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Espace Authentification Clients de la Banque</title>
</head>
<body>
  <H1>Espace Authentification Clients de la Banque</H1>
  <br>
  <form method="post" action="AuthentificationServlet">
            <label for="login">Login :</label>
            <input type="text" name="login" id="login" /><br/>
            <br><label for="motdepasse">Mot de passe :</label>
            <input type="password" name="motdepasse" id="motdepasse" /><br/>
            <br><input type="submit" value="Envoyer" />
   </form>
</body>
</html>