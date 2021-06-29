<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
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
				Welcome, <c:out value="${user.name}" />
			</h1>
			<a href="/logout">Logout</a>
		</div>
		<p class="subtitle">Idea   <a href="lowhigh">Low Likes</a> | <a href="#">High Likes</a></p> 

		<table class="table is-fullwidth is-bordered">
		<thead>
			<tr>
				<td>Idea</td>
				<td>Created By:</td>
				<td>Likes</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ideas}" var ="idea">
			<tr>
				<td><a href="/ideas/${idea.id}">${idea.content}</a></td>
				<td>${idea.getCreator().getName()}</td>
				<td>${idea.getLiked_byusers().size() }</td>
				<td>
				<c:choose>
				<c:when test="${idea.getLiked_byusers().indexOf(user)!= -1}">
				<a href="/unlike/${idea.id}">UnLike</a>
				</c:when>
				<c:otherwise>
					<a href="/like/${idea.id}">Like</a>
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
			</c:forEach>				
		</tbody>
		</table>
		<a href="/ideas/new" class="button is-dark">Create Idea</a>
	</div>
</body>
</html>