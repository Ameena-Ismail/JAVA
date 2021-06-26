<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
</head>
<body>
	<div class="container">
		<div class="notification">
			<h1 class="title">${myquestion.question}</h1>
		<p>
		Tag: <c:forEach items="${myTags}" var="tag" varStatus="loop">
		<span class="tag is-dark"><c:out value="${tag.subject},"/></span>
		</c:forEach>
		
		</p>
		</div>
		<div class="columns">
			<div class="column">
				<table class="table is-bordered is-fullwidth is-striped">
					<thead>
						<tr><td class="is-dark">Answers</td></tr>
					</thead>
					<tbody>
						<c:forEach items="${answers}" var="answer" varStatus="loop">
						<tr><td>
							<c:out value="${answer.answer}"/>
						</td></tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="column">
				<h2 class="title">Add your answer:</h2>
				<form:form action="/questions" method="post" modelAttribute="ans">
					<p>
						<form:label path="answer">Answer:</form:label>
						<form:errors path="answer" />
						<form:textarea path="answer" class="textarea"/>
						<input type="hidden" name="question" value="${myquestion.id}">
					</p><br>
					<div class="buttons has-addons is-right">
						<input type="submit" class="button is-dark" value="Answer it!"/>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>