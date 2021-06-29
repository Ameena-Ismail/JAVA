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
				Welcome,
				<c:out value="${user.name}" />
			</h1>
			<a href="/logout">Logout</a>
		</div>
		<p class="subtitle">Here are some of the events in your state.</p>
		<!-- table event in your state -->
		<table class="table is-fullwidth is-bordered">
		<thead>
			<tr>
				<td>Name</td>
				<td>Date</td>
				<td>Location</td>
				<td>Host</td>
				<td>Action/Status</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Cooking Lesson</td>
				<td>November 1, 2018</td>
				<td>Seattle</td>
				<td>John</td>
				<td><a href="#">Edit</a>   <a href="#">delete</a></td>
			</tr>		
			<tr>
				<td>Picnix</td>
				<td>December 21, 2018</td>
				<td>Seattle</td>
				<td>Kevin</td>
				<td><a href="#">Join</a>   <a href="#">Cancel</a></td>
			</tr>		
		</tbody>
		</table>


		<p class="subtitle">Here are some of the events in other states.</p>
		<!-- table event in other states -->
		<table class="table is-fullwidth is-bordered">
		<thead>
			<tr>
				<td>Name</td>
				<td>Date</td>
				<td>Location</td>
				<td>Host</td>
				<td>State</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><a href="#">Spanish Lesson</a></td>
				<td>November 10, 2018</td>
				<td>Burbank</td>
				<td>CA</td>
				<td>Kim</td>
				<td><a href="#">Edit</a>   <a href="#">delete</a></td>
			</tr>		
			<tr>
				<td>Hiking</td>
				<td>October 1, 2018</td>
				<td>Las Vegas</td>
				<td>NV</td>
				<td>Joe</td>
				<td><a href="#">Join</a></td>
			</tr>		
		</tbody>
		</table>



		<h1 class="subtitle">Create an Event</h1>

		<%-- <form:form method="POST" action="/create/event" modelAttribute="event">
			<form:label path="eventName">Name:</form:label>
			<form:input path="eventName" class="input" />
			<form:label path="eventDate">Date:</form:label>
			<form:input path="eventDate" type="date" class="input"/>
			<form:label path="city">Location:</form:label>
			<form:input path="city" class="input" />
			<form:select path="state" class="select is-one-third">
				<form:option value="WA">WA</form:option>
				<form:option value="CA">CA</form:option>
				<form:option value="NY">NY</form:option>
				<form:option value="MA">MA</form:option>
				<form:option value="TX">TX</form:option>
			</form:select>
			<input type="submit" value="Create" class="button" />
		</form:form> --%>
	</div>
</body>
</html>