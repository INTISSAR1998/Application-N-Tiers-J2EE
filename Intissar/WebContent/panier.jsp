<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.Panier" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">  
    <title>Page1</title>  
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">  
</head>
<body>
<% Panier p =(Panier) session.getAttribute("panier"); %>


                        <%for(int i=0;i<p.getListLignePanier().size();i++){ %>
							<tr>
								<th scope="row">1</th>
								<td>
									<img src="images/<%=p.getListLignePanier().get(i).getProduit().getId()%>.jpg" width="10%"> <%=p.getListLignePanier().get(i).getProduit().getDescription()%>
								</td>
								<td> <%=p.getListLignePanier().get(i).getProduit().getPrix()%>Dt</td>
								<td> <%=p.getListLignePanier().get(i).getQuantite()%></td>
								<td><%=p.getListLignePanier().get(i).getQuantite()*p.getListLignePanier().get(i).getProduit().getPrix()%></td>
								<td><a class="btn btn-danger " href="">Suppimer</a></td>
							</tr>
							<% } %>
                    

</body>
</html>
    