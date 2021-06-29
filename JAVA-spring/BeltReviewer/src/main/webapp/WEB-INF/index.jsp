<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Belt Reviewer</title>
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
					<h1 class="subtitle">Register</h1>
					<p>
						<form:errors path="user.*" />
					</p>

					<!-- left column -->


					<form:form method="POST" action="/registration"
						modelAttribute="user">
						<table class="mytable">

							<tr>
								<td class="is-one-thrid"><form:label path="firstName">First Name:</form:label></td>
								<td class="is-two-thrids"><form:input path="firstName"
										class="input" /></td>
							</tr>
							<tr>
								<td class="is-one-thrid"><form:label path="lastName">Last Name:</form:label></td>
								<td class="is-two-thrids"><form:input path="lastName"
										class="input" /></td>
							</tr>
							<tr>
								<td class="is-one-thrid"><form:label path="email">Email:</form:label></td>
								<td class="is-two-thrids"><form:input path="email"
										class="input" /></td>
							</tr>
							<tr>
								<td class="is-one-thrid"><form:label path="city">Location:</form:label></td>
								<td class="is-two-thrids"><form:input path="city"
										class="input" />
									<form:select path="state" class="select is-one-third">
											<form:option value="WA">WA</form:option>
											<form:option value="CA">CA</form:option>
											<form:option value="NY">NY</form:option>
											<form:option value="MA">MA</form:option>
											<form:option value="TX">TX</form:option>
									</form:select></td>
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
							<tr>
								<td><input type="submit" value="Register!" class="button" /></td>
							</tr>

						</table>
					</form:form>
				</div>



				<!-- login -->
				<div class="column">
					<h1 class="subtitle">Login</h1>
					<p>
						<c:out value="${error}" />
					</p>

					<form method="post" action="/login">
						<table class="table is-fullwidth">
							<tr>
								<td class="is-one-thrid"><label type="email" for="email">Email</label></td>
								<td class="is-two-thrids"><input type="text" id="email"
									name="email" class="input" /></td>
							</tr>
							<tr>
								<td class="is-one-thrid"><label for="password">Password</label></td>
								<td class="is-two-thrids"><input type="password"
									id="password" name="password" class="input" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Login!" class="button" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</section>
	</div>
</body>
</html>