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
<c:set var="rs" value="resources" />
<c:set var="cxt" value="${pageContext.request.contextPath }" />
<link  href="${cxt}/${rs}/files/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="haut.jsp" %>

<div class="container">
 
    <div class="row" style="margin-top: 80px;">
	<%@ include file="gauche.jsp" %>
       
		
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
							<c:forEach items="${sessionScope.monpanier.lignes}" var="li">
							<tr>
								<th scope="row">1</th>
								<td>
									<img src="${cxt }/${rs }/files/images/${li.prod.id}.jpg" width="10%">${li.prod.description}
								</td>
								<td> ${li.prod.prix } DT</td>
								<td> ${li.quantite }</td>
								<td></td>
								<td><a class="btn btn-danger " href="">Suppimer </a></td>
							</tr>
							</c:forEach>
                        </tbody>						
                    </table>

                </div>
				<div class="panel-footer">					
						<a href="#" class="btn btn-warning">POURSUIVRE VOS ACHATS</a>
						<a href="#" class="btn btn-info">FINALISER VOTRE COMMANDE</a>				
				</class>
            </div>
        </div>
        </div>

    </div>

</div>

</body>
</html>