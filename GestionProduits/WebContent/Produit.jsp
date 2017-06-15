<%@page import="metier.Produit" %>
<%@page import="java.util.Iterator" %>
<%@page import="web.ProduitBeans" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Application JAVA EE</title>
</head>
<body>

<%
    ProduitBeans produits=null;

    if(request.getAttribute("modele")==null)
    {
    	produits=new ProduitBeans();	
    }
    else
    {
    	produits =(ProduitBeans) request.getAttribute("modele");
    }

    
%>

<h4>Ajouter Un Produit :</h4><br>
<form  action="prodserv" method="post">
<table>
    <tr>
       <td>Nom :</td>
       <td><input type="text" name="nom"></td>
    </tr>
    
    <tr>
      <td>Description :</td>
      <td><input type="text" name="desc"></td>
    </tr>
    
    
    <tr>
      <td>Prix :</td>
      <td><input type="text" name="prix"></td>
    </tr>
     
    
    <tr>
      <td>Etat :</td>
      <td><input type="text" name="etat"></td>
    </tr>
    
    <tr>
      <td colspan="2"> <input type="submit" value="valider" name="valider"></td>
    </tr>
    
   </table> 

</form>

<table border="1" width="60%">
  <tr>
     <th>Id</th>
     <th>Nom</th>
     <th>Description</th>
     <th>Prix</th>
     <th>Etat</th>
     <th>Option</th>
  </tr>
  <% 
  Iterator<Produit> list = produits.getListe().iterator();
  while(list.hasNext())
  {
	  Produit p = list.next();

 %>
  
  <tr>
     <td><%= p.getId() %></td>
     <td><%= p.getNom() %></td>
     <td><%= p.getDesc() %></td>
     <td><%= p.getPrix() %></td>
     <td><%= p.getEtat() %></td>
     <td>
       <form action="prodserv" method="post">
        <input type="hidden" name="id" value="<%=p.getId() %>">
        <input type="hidden" name="action" value="supprimer">
        <input type="submit" name="supprimer" value="supprimer">
       </form>
     </td>
     
    <%} %> 
  </tr>
</table>
</body>
</html>