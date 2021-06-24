<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>License assignment</title>

</head>
<body>
	<section>
		<div class="container">

			<h1>New Person</h1>

			<form:form action="/create/person" method="post"
				modelAttribute="person">
				<p>
					<form:label path="firstName">First Name: </form:label>
					<form:errors path="firstName" />
					<form:input path="firstName" type="text" />
				</p>
				<p>
					<form:label path="lastName">Last Name</form:label>
					<form:errors path="lastName" />
					<form:input path="lastName" type="text" />
				</p>
				<input type="submit" value="Create" />
			</form:form>
		</div>
	</section>
</body>
</html>