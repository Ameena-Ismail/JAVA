<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Idea Info</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
</head>
<body>

	<div class="container">
		<div class="notification">
			<h1 class="title">
				<c:out value="${idea.content}" />
			</h1>
			<p>Created By: ${idea.getCreator().getName()}</p>
			<a href="/ideas">Dashboard</a> | <a href="/logout">Logout</a>
		</div>
		<h1 class="title">Users who liked your idea: </h1>

		<table class="table is-fullwidth is-bordered">
		<thead>
			<tr>
				<td>Name</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${likeUsers}" var ="myUser">
			<tr>
				<td>${myUser.getName()}</td>
			</tr>
			</c:forEach>				
		</tbody>
		</table>
		<a href="/ideas/${idea.id}/edit" class="button is-dark">Edit</a>
	</div>
</body>
</html>