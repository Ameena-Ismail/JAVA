<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<h1 class="title">Question Dashboard</h1>
		</div>
		<table class="table is-bordered is-fullwidth is-striped">
			<thead>
				<tr>
					<td class="is-two-thirds is-dark">Questions</td>
					<td class="is-one-third is-dark">Tags</td>
				</tr>
			</thead>
			<tbody>
					<c:forEach items="${questions}" var="q" varStatus="loop">
					<tr>	
					<td  class="is-two-thirds"><a href="/questions/${q.id}"><c:out value="${q.question}"/></a></td>
							<td class="is-one-third">
							<c:forEach items="${q.tags}" var="tags">
								${tags.subject}
							</c:forEach>
							</td>
					</tr>
					</c:forEach>
			</tbody>
		</table>
		<div class="buttons has-addons is-right">
			<a href="/questions/new">New Question</a>
		</div>
	</div>
</body>
</html>