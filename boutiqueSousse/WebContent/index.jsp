<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="bootstrap/css/bootstrap.min.css"  rel="stylesheet" >
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
                
                		<c:forEach var="i" items = "${categories}">
                
                <a href="IndexServlet?id=${i.id}" class="list-group-item">${i.description}</a>
                </c:forEach>

            </div>
        </div>
		
        <div class="col-md-9">
		<c:forEach var="i" items = "${produits}">
            <div class="col-md-4">
                <div class="thumbnail">
                    <img src="images/${i.id}.jpg" >
                    <div class="caption">
                        <h3>${i.description}</h3>
                        <p><a href="PanierServlet?id=${i.id}" class="btn btn-primary" >Ajouter Panier</a>
                            <a href="#" class="btn btn-danger" >${i.prix}DT</a>
                        </p>
                    </div>
                </div>
            </div>   
     </c:forEach>    
          
        </div>

    </div>

</div>


</body>
</html>