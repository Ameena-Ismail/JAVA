<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Belt exam</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<script defer
	src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
</head>
<body>
	<div class="container">
		<div class="notification">
			<p class="title">Welcome</p>
		</div>

		<!-- left and right -->
		<section>
			<div class="columns">

				<!-- registration -->
				<div class="column">
					<div class="buttons has-addons is-centered">
						<h1 class="title">Register</h1>
					</div>
					

					<!-- left column -->


					<form:form method="POST" action="/registration"
						modelAttribute="user">
						<table class="mytable">

							<tr>
								<td class="is-one-thrid"><form:label path="name">Name:</form:label></td>
								<td class="is-two-thrids"><form:input path="name"
										class="input" /></td>
							</tr>
							<tr>
								<td class="is-one-thrid"><form:label path="email">Email:</form:label></td>
								<td class="is-two-thrids"><form:input path="email"
										class="input" /></td>
							</tr>

							<tr>
								<td class="is-one-thrid"><form:label path="password">password:</form:label></td>
								<td class="is-two-thrids"><form:input path="password"
										type="password" class="input" /></td>
							</tr>
							<tr>
								<td class="is-one-thrid"><form:label
										path="passwordConfirmation">password Confirmation:</form:label></td>
								<td class="is-two-thrids"><form:input
										path="passwordConfirmation" type="password" class="input" /></td>
							</tr>
						</table>
						<div class="buttons has-addons is-right">
							<input type="submit" value="Register!" class="button" />
						</div>
					</form:form>
					
					<p class="subtitle is-danger">
						<form:errors path="user.*" />
					</p>
				</div>



				<!-- login -->
				<div class="column">
					<div class="buttons has-addons is-centered">
						<h1 class="title">Login</h1>
					</div>

					<form method="post" action="/login">
						<table class="mytable">
							<tr>
								<td class="is-one-thrid"><label for="email">Email</label></td>
								<td class="is-two-thrids"><input type="text" id="email"
									name="email" class="input" /></td>
							</tr>
							<tr>
								<td class="is-one-thrid"><label for="password">Password</label></td>
								<td class="is-two-thrids"><input type="password"
									id="password" name="password" class="input" /></td>
							</tr>
						</table>
						<div class="buttons has-addons is-right">
							<input type="submit" value="Login" class="button" />
						</div>
					</form>
					<p class="subtitle">
						<c:out value="${error}" />
					</p>
				</div>
			</div>
		</section>
	</div>
</body>
</html>