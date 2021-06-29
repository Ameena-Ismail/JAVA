<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create New Ideas</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
</head>
<body>
	<div class="container">
		<div class="myheader">
			<p class="title">Create a new idea</p>
			<a href="/ideas">Dashboard</a> | <a href="/logout">Logout</a>
		</div>
		
		<section>
			<div class="columns">
				<div class="column">

					<form:form method="POST" action="/ideas/createnew" modelAttribute="newidea">
						<%-- <form:input path="id" type="hidden"/> --%>
						<%-- <form:input path="users" type="hidden"/> --%>
						<table>
							<tr>
								<td><form:label path="content">Name:</form:label></td>
								<td><form:input path="content" class="input" /></td>
								<td><form:errors path="content" /></td>
							</tr>
						</table>
						<div class="buttons has-addons">
							<input type="submit" value="Create" class="button is-dark" /> 
						</div>
					</form:form>
					<%-- <p>
						<form:errors path="theidea.*"></form:errors>
					</p> --%> 
					<%-- <p><c:out value="${errors}"/></p> --%>

				</div>
				<div class="column"></div>
			</div>

		</section>
	</div>
</body>
</html>