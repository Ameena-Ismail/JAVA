<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coding Language</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
</head>
<body>
	
	<section>
		<div class="container">
  			<div class="notification">
    			JAVA Spring Data I - <strong>Languages</strong> assignment.
  			</div>
  			<h1><c:out value="${lang.name}"/></h1>
			<h1><c:out value="${lang.creator}"/></h1>
			<h1><c:out value="${lang.version}"/> </h1>
			<a href="">Edit</a><br>
			<a href="/languages/delete/<c:out value="${lang.id}"/>">Delete</a><br>
			<a href="/languages">DashBoard</a><br>
  			
		</div>
	</section>
</body>
</html>