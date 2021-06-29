<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Task</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
</head>
<body>
	<div class="container">
		<div class="myheader">
			<p class="title">Edit a task</p>
		</div>

		<!-- left and right -->
		<section>
			<div class="columns">
				<div class="column">

					<form:form method="POST" action="/tasks/${id}/edit"
						modelAttribute="edittask">
						<!-- <input type="hidden" name="_method" value="put" /> -->
						<form:input type="hidden" path="id"></form:input> 
						<table class="mytable">
							<tr>
								<td><form:label path="taskName">Task:</form:label></td>
								<td><form:input path="taskName" class="input"/></td>
								<td><form:errors path="taskName"/></td>
							</tr>
							<tr>
							<!-- preload assignee in dropdown menu -->
								<td><form:label path="assignee">Assignee:</form:label></td>
								<td><form:select path="assignee" class="select">
										<form:option value="${edittask.assignee}">
										${edittask.assignee.getName()}</form:option>
										
										<!-- List all users from user table -->
										<c:forEach items="${users}" var="user"> 
										
										<!-- List all users except a current selected assignee and a task creator-->
										<!-- check if user name isn't a current selected assignee  -->
											<c:if test="${user.name != edittask.assignee.getName()}"> 
												
												<!-- check if user name isn't a task creator name -->
												<c:if test="${user.name!=creator.name}">
													
													<form:option value="${user}">
														<c:out value="${user.name}" />
													</form:option>
												</c:if>
											</c:if> 
										</c:forEach> 
									</form:select></td>
								<td><form:errors path="assignee" /></td>
							</tr>
							<tr>
								<td><form:label path="priority">Priority:</form:label></td>
								<td><form:select path="priority" class="select">
										<form:option value="1">Low</form:option>
										<form:option value="2">Medium</form:option>
										<form:option value="3">High</form:option>
									</form:select></td>
								<td><form:errors path="priority" /></td>
						</table>
						<!-- creator need to be specify when update a task -->
						<form:input type="hidden" path="creator" value="${creator.id}"/>
						<div class="buttons has-addons is-right">
							<input type="submit" value="Edit" class="button" />
						</div>
					</form:form>
				</div>
				<div class="column"></div>
			</div>

		</section>
	</div>
</body>
</html>