<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Languages Assignment</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
</head>
<body>
	<section>
		<div class="container">
  			<div class="notification">
    			JAVA Spring Data I - <strong>Languages</strong> assignment.
  			</div>
  			
  			<table class="table is-fullwidth is-striped">
  			<thead>
  				<tr class="notification">
  					<td>Name</td>
  					<td>Creator</td>
  					<td>Version</td>
  					<td>Action</td>
  				</tr>
  			</thead>
  			<tbody>	
  				<c:forEach items="${languages}" var="language">
  				<tr>
  					<td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
  					<td><c:out value="${language.creator}"/></td>
  					<td><c:out value="${language.version}"/></td>
  					<td><a href="/languages/delete/${language.id}">delete</a> <a href="/languages/edit/${language.id}">edit</a></td>
  				</tr>
  				</c:forEach>
  			</tbody>	
  			</table>
  			
  			<div class="notification">
    			Create a <strong>Languages</strong> into database.
  			</div>
  			
			<div class="columns">
					<div class="column">
			    		
			    		<h1 class="subtitle is-5">Name</h1>
			    		<h1 class="subtitle is-5">Language</h1>
			    		<h1 class="subtitle is-5">Version</h1>
			    		
			  		</div>
			  		<div class="column">
			    		<form:form action="/create" method="post" modelAttribute="language">
			    		<div class="field">
  							<div class="control">
    						<form:input class="input" type="text" path="name"/>
    						<form:errors path="name"/>
  							</div>
						</div>
			  			<div class="field">
  							<div class="control">
    						<form:input class="input" type="text" path="creator"/>
    						<form:errors path="creator"/>
  							</div>
						</div>
						<div class="field">
  							<div class="control">
    						<form:input class="input" type="text" path="version"/>
    						<form:errors path="version"/>
  							</div>
						</div>
						<div class="buttons is-right">
  							<input class="button is-primary is-right" type="submit"/> 	
						</div>
					</form:form>
			  		</div>
			  		
  			</div>
  			
	</div>
	</section>
</body>
</html>