<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Belt Reviewer</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
</head>
<body>
	<div class="container">
		<div class="myheader">
			<p class="noneblock title">
				Task:
				<c:out value="${task.taskName}" />
			</p>
		</div>

		<!-- left and right -->
		<section>
			<div class="columns">
				<div class="column">
					<table class="mytable">
						<tr>
							<td class="subtitle">Creator:</td>
							<td class="subtitle">${task.creator.getName()}</td>
						</tr>
						<tr>
							<td class="subtitle">Assignee:</td>
							<td class="subtitle">${task.assignee.getName()}</td>
						</tr>
						<tr>
							<td class="subtitle">Priority:</td>
							<c:if test="${task.priority==1}">
								<td class="subtitle">Low</td>
							</c:if>
							<c:if test="${task.priority==2}">
								<td class="subtitle">Medium</td>
							</c:if>
							<c:if test="${task.priority==3}">
								<td class="subtitle">High</td>
							</c:if>
						</tr>
					
					<!-- Black belt requirement -->	
					<!-- if current login user is a task creator, then Edit,Delete will be shown -->	
						<c:if test="${task.creator.getId()==currentUserId}">
						<tr>
							<td><a class="button" href="/tasks/${task.id}/edit">Edit</a></td>
							<td><a class="button" href="/tasks/${task.id}/delete">Delete</a></td>
						</tr>
						</c:if>
					</table>
					
					<!-- Black belt requirement -->
					<!-- If current login user is an assignee, then this complete button will be shown -->
					<c:if test="${task.assignee.getId()==currentUserId}">
					<div class="buttons has-addons is-left">
						<a href="/tasks/${task.id}/delete" class="button">Completed</a>
					</div>
					</c:if>
				</div>
				<div class="column"></div>
			</div>

		</section>
	</div>
</body>
</html>