<%@ page import="model.Compte"%>
<%@ page import="model.Etudiant" %>
<%@ page import="dao.Gestiondb" %>
<%@ page import="model.Errors" %>
<%@ page import="java.util.Vector" %>


<%   
	String c = (String)session.getAttribute("compte");

	if(c==null)
	{
		Errors err =  new Errors("notConnected", "vous etes pas  connecter !");
		Vector<Errors> errVect = (Vector<Errors>)session.getAttribute("error");
		errVect.add(err);
		session.setAttribute("error", errVect);
		response.sendRedirect("Authentification.jsp");
	}
	else{
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Gestiondb g = new Gestiondb(); %>
<% %>
<h1>Bonjour Mr <%=(String)session.getAttribute("compte") %></h1>
<form method="post" action="Deconnection">
Deconnection<input type="submit" value="submit">
</form>
<TABLE>
	<TR>
		<TH>Nom</TH> <TH>Prenom</TH> <TH>Tel</TH><TH>Action</TH>
	</TR>
	<%
	Vector<Etudiant> l = g.getAllEtudiants();
for(Etudiant e : l) {%>
	<TR>
		<TD><%= e.getNom()%></TD> <TD><%= e.getPrenom() %></TD> <TD><%= e.getTelephone()%></TD><TD><a href="Supprimer?numero=<%=e.getNumero()%>">supprimer</a></TD>
	</TR>
	<% }%>
</TABLE>	


<form method="post" action="Ajouter">
Numero<input type="number" name="num">
Nom<input type="text" name="nom">
Prenom<input type="text" name="prenom">
Tel<input type="number" name="tel">

Enregistrer<input type="submit" value="submit">

</form>
</body>
</html>
<%  } %>