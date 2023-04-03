<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Panier" %>
    <%@page import="model.LignePanier" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">  
    <title>Page1</title>  
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">  
</head>
<body>


<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">          
            <a class="navbar-brand" href="#">E-Boutique</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="">Home</a></li>
                <li><a href='#'>login</a></li>
		<li><a href='#'>signup</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">                
                <li><a href="#"> Mon Panier() </a>   </li>
            </ul>
        </div>
    </div>
</nav>


<div class="container">

    <div class="row" style="margin-top: 80px;">
        <div class="col-md-3">
            <div class="list-group">
                <a href="#" class="list-group-item active"> Tous les Produits </a>
                <a href="#" class="list-group-item">PC-Protable</a>            
            </div>
        </div>


        <div class="col-md-9">
            <div class="panel panel-info">
                <div class="panel-heading">Mon panier </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
							<tr> <th>#</th>
								<th>D&eacute;signation de vos articles</th>
								<th>Prix UT</th>
								<th>Quantit&eacute;</th>
								<th>Total</th>
								<th></th>
							</tr>
                        </thead>
                        <tbody>
                        <% Panier panier = (Panier)session.getAttribute("panier"); %>
                        <% for(LignePanier lp : panier.getLignepanier()){ %>
							<tr>
				
								<th scope="row"><%=lp.getProduit().getId() %></th>
								<td>
									<img src="images/<%=lp.getProduit().getId() %>.jpg" width="10%"> <%=lp.getProduit().getDescription() %>
								</td>
								<td> <%=lp.getProduit().getPrix() %> Dt</td>
								<td><%=lp.getQuantite() %></td>
								<td><%=lp.getProduit().getPrix() * lp.getQuantite()%></td>
								<td><a class="btn btn-danger " href="DeletePanier?id=<%=lp.getProduit().getId()%>">Suppimer </a></td>
							</tr>
							<%} %>
                        </tbody>						
                    </table>

                </div>
            </div>
        </div>
    </div>


</div>


</body>
</html>
    