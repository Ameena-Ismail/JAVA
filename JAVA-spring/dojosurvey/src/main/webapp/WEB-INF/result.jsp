<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey result</title>
</head>
<body>
	<div class="container">
		<h1>Submmitted Info</h1>
		<h3>Name: <c:out value="${myName}" /></h3>
		<h3>Dojo Location: <c:out value="${myDojo}"/></h3>
		<h3>Favorite Language: <c:out value="${myLang}"/></h3>
		<h3>Comment: <c:out value="${myComment}"/></h3>
		
		<a href="/">Go Back</a>
	</div>
</body>
</html>