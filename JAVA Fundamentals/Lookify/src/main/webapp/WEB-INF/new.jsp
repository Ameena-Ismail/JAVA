<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css" />
<title>Lookify App</title>
</head>
<body>
<header>
<div>
<a href="#"></a></div>
<div class="dummy">
<a href="#">Dashboard</a>
</div>
</header>
	<div class="container">
		<h2>Add a new Song</h2>
		<hr />
		<form:form action="/songs/new" method="POST" modelAttribute="song">
			<div class="form-group">
		        <form:label path="name">Song Title</form:label>
		        <form:errors path="name"/>
		        <form:input class="form-control" path="name"/>
		    </div>
		    <div class="form-group">
		        <form:label path="artist">Artist</form:label>
		        <form:errors path="artist"/>
		        <form:input class="form-control" path="artist"/>
		    </div>
		    <div class="form-group">
		        <form:label path="rating">Rating</form:label>
		        <form:errors path="rating"/>
		        <form:input type="number" class="form-control" path="rating"/>
		    </div>
		    <button>Add Song</button>
		</form:form>
	</div>
</body>
</html>