<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Boutique</title>
<spring:url value="/resources/files/bootstrap" var="bt" />
<link rel="stylesheet" href="${bt}/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">          
            <a class="navbar-brand" href="#">E-Boutique ESSAT</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="">Home</a></li>
                <li><a href='#'>Promotions</a></li>
                <li><a href='#'>Ventes Flash</a></li>
            </ul>
			 <ul class="nav navbar-nav navbar-right">                
                <li>
					<a href="#"> Mon Panier 
						<span class="badge"> 0 </span>
					</a>   
				</li>              
                <li>
	                 <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	                     Ali Ben Salah <span class="caret"></span></a>
	                     
			          <ul class="dropdown-menu">
			            <li><a href="#">Mes Commandes</a></li>
			            <li><a href="#">Déconnexion</a></li>		            
			          </ul>
	            </li>
              
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

            <div class="col-md-4">
                <div class="thumbnail">
                    <img src="images/1.jpg" >
                    <div class="caption">
                        <h3>PC DELL Latitude E5530</h3>
                        <p><a href="#" class="btn btn-primary" >Ajouter Panier</a>
                            <a href="#" class="btn btn-danger" >1520DT</a>
                        </p>
                    </div>
                </div>
            </div>       
          
        </div>

    </div>

</div>

</body>
</html>