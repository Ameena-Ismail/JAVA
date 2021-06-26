<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Code</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h2><c:out value="${error}"/></h2>
		<h1>What is the code?</h1>
		<form method="POST" action="/getcode">
			<input type="text" name="textinput"><br>
			<input type="submit" value="Try Code">
		</form>
	</div>
</body>
</html>