<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="ma_voiture" class="test.Voiture"></jsp:useBean>
    <%
    ma_voiture.setEstDemmarer(true);
    ma_voiture.setVitesse(25);
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<title>Affichage données Voiture </title>
</head>
<body>
La voiture a-t-elle était démarée? :
<%= ma_voiture.isEstDemmarer()
%>
La vitesse est :
<jsp:getProperty property="vitesse" name="ma_voiture"/>
La puissance est :
<jsp:getProperty property="puissance" name="ma_voiture"/>
</body>
</html>