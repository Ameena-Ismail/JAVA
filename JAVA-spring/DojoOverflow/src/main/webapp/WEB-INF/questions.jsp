<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question Dashboard</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
</head>
<body>
	<div class="container">
		<div class="notification">
			<h1 class="title">What is your question?</h1>
		</div>

		<form:form action="/questions/new" method="post" modelAttribute="addQuestion">
		<div class="columns">
			<div class="column is-one-thrid">Question:</div>
			<div class="column is-two-thirds">
				<form:textarea path="question" class="textarea"/> 
				<form:errors path="question" />
			</div>
		</div>
		<div class="columns">
			<div class="column is-one-thrid">Tags:</div>
			<div class="column is-two-thirds">
				<input name="myTag" class="input"/>
				<c:out value="${errors}"></c:out> 
			</div>
		</div>
		<div class="buttons has-addons is-right">
			<input type="submit" class="button is-dark" value="Submit" />
		</div>
		</form:form>
	</div>
</body>
</html>