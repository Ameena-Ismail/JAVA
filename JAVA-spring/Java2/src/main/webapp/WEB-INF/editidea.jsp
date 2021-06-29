<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Idea</title>
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
				<%-- <c:out value="${user.name}" /> --%>
				Edit an idea
			</h1>
		</div>
		<div>
			<a href="/ideas">Dashboard</a> | <a href="/logout">Logout</a>
		</div>
		
		<!-- Form creation -->
		
		<section>
			<div class="columns">
				<div class="column">

					<form:form method="POST" action="/ideas/edit" modelAttribute="idea">
						<form:input path="id" type="hidden"/>
						<%-- <form:input path="users" type="hidden"/> --%>
						<table>
							<tr>
								<td><form:label path="content">Name:</form:label></td>
								<td><form:input path="content" class="input" /></td>
								<td><form:errors path="content" /></td>
							</tr>
						</table>
						<div class="buttons has-addons">
							<input type="submit" value="Update" class="button is-dark" /> 
						</div>
						<a href="/delete/${idea.id}" class="button is-dark">Delete</a>
					</form:form>
					<%-- <p>
						<form:errors path="task.*"></form:errors>
					</p> --%>
					<%-- <p><c:out value="${errors}"/></p> --%>

				</div>
				<div class="column"></div>
			</div>

		</section>
		
		
	</div>
</body>
</html>