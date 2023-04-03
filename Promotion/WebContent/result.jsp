<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage des resultats</title>
</head>
<body>
<%List<String> promoList = (List<String>) request.getAttribute("promo"); 
Iterator it = promoList.iterator();
out.print("<b> Liste des etudiants</b>");
while(it.hasNext()){
	out.print("<br> "+it.next());
}
%>
</body>
</html>