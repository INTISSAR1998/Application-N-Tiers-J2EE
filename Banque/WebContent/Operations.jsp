<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>authentification réussie</title>
</head>
<body>
  <H1>authentification réussie</H1>
  <form method="post" action="TransactionServlet">
  	<p>Votre compte bancaire contient : 300.0 euro<p/>
  	<div>Vous voulez faire</div>
  	<div>un <input type="radio" id="choice1" name="virement" value="virement" > virement </div>
  	<div>ou un <input type="radio" id="choice2" name="retrait" value="retrait" > retrait</div><br>
  	<div>de <input type="text" name="montant" id="montant"> euro </div>
  	<input type="submit" value="lancer la transaction"/>
    <input type="submit" value="Effacer"/>
   </form>
</body>
</html>