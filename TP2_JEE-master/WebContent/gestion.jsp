<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector" %>
<%@ page import="model.*" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="bootstrap/js/bootstrap.min.js"></script>   

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">         
<style>
.credit-card-div  span { padding-top:10px; }
.credit-card-div img { padding-top:30px; }
.credit-card-div .small-font { font-size:9px; }
.credit-card-div .pad-adjust { padding-top:10px; }
</style>
</head>
<body>


<form method="post" action="ServletAffecter">
Nom Patient<select name="idPatient">
<%// Vector<Patient> ListePatient =(Vector<Patient>) session.getAttribute("ListePatient") ;
//for(Patient p :ListePatient ){
%>
<c:forEach var="lv" items="${ListePatient}">

 <option value="${lv.id}"> ${lv.nom} </option>

 </c:forEach>

</select>
Nom Medecin<select name="idMedecin">
<% Vector<Medecin> ListeMedecin =( Vector<Medecin>) session.getAttribute("ListeMedecin") ;
for(Medecin p :ListeMedecin ){
%>
 <option value=<%=p.getId() %>> <%=p.getNom()%></option>

<%} %>
</select> 
Jour <input type="number" name="jour">
heure <input type="number" name="heure">
Ajouter<input type="submit" value="Ajouter">

</form>
<p>${error.message}</p>

<%session.removeAttribute("error"); %>
<a href="ServletRecherche">liste des consultation par medecin</a>


</body>
</html>