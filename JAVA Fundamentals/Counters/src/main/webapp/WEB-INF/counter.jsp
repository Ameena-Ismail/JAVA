<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>





<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>You Have Visited <a href="/">http:/Your_welcomePage  </a><c:out value="${count}"/> Times</p>
<c:out value="${count}"/>
</body>
</html>