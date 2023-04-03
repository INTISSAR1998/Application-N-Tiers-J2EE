<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector" %>
<%@ page import="model.*" %>
<%@ page import="dao.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">         
<script src="bootstrap/js/bootstrap.min.js"></script>   

</head>
<body>
<form method="post" action="ServletRecherche">
choisir Nom Medecin  <br>
Rechercher<input type="submit" value="Ajouter">
<select name="idMedecin">
<% Vector<Medecin> ListeMedecin =( Vector<Medecin>) session.getAttribute("ListeMedecin") ;
for(Medecin p : ListeMedecin ){
%>
 <option value=<%=p.getId() %>> <%=p.getNom()%></option>

<%} %>

</select> 
</form>



<% if (request.getAttribute("ListeConsultation2")!=null){ %>
<% GestionCentreImp g = new GestionCentreImp(); %>





<table class="table">
  <thead>
    <tr>
      <th scope="col">Nom Patient</th>
      <th scope="col">Nom Medcin</th>
      <th scope="col">Jour</th>
      <th scope="col">Heure</th>
    </tr>
  </thead>
  <tbody>
  <% Vector<Consultation> ListeConsultation =(Vector<Consultation>) request.getAttribute("ListeConsultation2") ;

	for(Consultation e : ListeConsultation) {%>
    <tr>
      <th scope="row"><%=e.getIdPatient().getNom() %></th>
      <td><%=e.getIdMedecin().getNom() %></td>
      <td><%=e.getJour()%></td>
      <td><%=e.getJour()%></td>
    </tr>
<% }%>
 
  </tbody>
</table>
<%} %>


</body>
</html>