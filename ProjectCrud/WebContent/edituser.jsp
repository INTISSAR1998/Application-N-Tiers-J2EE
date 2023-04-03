<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
	<title>View Users</title>
</head>
<body>     
    <%@page import="dao.UserDao"%>  
     <jsp:useBean id="u" class="bean.User"></jsp:useBean>
     <jsp:setProperty property="*" name="u"/>  
     
     <%   int i=UserDao.update(u);   
     	  response.sendRedirect("viewusers.jsp");  
     %>
     
	 <%@page import="dao.UserDao,bean.*,java.util.*"%>  
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
	     
	 <h1>Users List</h1>     
	 
	 <%   List<User> list=UserDao.getAllRecords();   
	 	  request.setAttribute("list",list);  
	 %> 
	     
	  <table border="1" width="90%">  
	  	 <tr>
	  	 	<th>Id</th>
	  	 	<th>Nom</th>
	  	 	<th>Password</th>
	  	 	<th>Email</th>  
	  	    <th>Sex</th>
	  	    <th>Pays</th>
	  	    <th>Editer</th>
	  	    <th>Supprimer</th>
	  	  </tr> 
	  	    
	  	  <c:forEach items="${list}" var="u"> 
	  	    <tr>
	  	    	<td>${u.id}</td>
	  	    	<td>${u.name}</td>
	  	    	<td>${u.password}</td> 
	  	    	<td>${u.email}</td>
	  	    	<td>${u.sex}</td>
	  	    	<td>${u.country}</td>  
	  	        <td><a href="editform.jsp?id=${u.id}">Edit</a></td> 
	  	        <td><a href="deleteuser.jsp?id=${u.id}">Delete</a></td>
	  	     </tr>  
	  	   </c:forEach> 
	  </table>   
	  <br/>
	  <a href="adduserform.jsp">Ajouter nouvel Utilisateur</a>    
</body> 
</html> 
