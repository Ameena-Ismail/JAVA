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
	<div class="container">
		<h1>Top Ten Songs</h1>
		<a class="float-right" href="/songs">Dashboard</a>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Rating</th>
					<th>Title</th>
					<th>Artist</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ songs }" var="song">
				<tr>
					<td>${ song.rating }</td>
					<td><a href="/songs/${ song.id }">${ song.name }</a></td>
					<td>${ song.artist}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>