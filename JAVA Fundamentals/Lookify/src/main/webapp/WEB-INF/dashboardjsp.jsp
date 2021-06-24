<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core%22%%3E"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>

<div class="container"></div>

<header style="
display: flex;
flex-direction">

<a href="#">Add New</a>
<a href="#">Top Songs</a>
<div class="search"></div>
<form style="">
<input type="text" placeholder="id="dashSearchBox" name="dashSearchBox">
</div>
</form>


<form style="">
<input type="text" placeholder="" id="dashSearchBox" name="dashSearchBox">
<input type="submit" value="Search Artists">
</form>
</header>
<h1>Songs Lists</h1>
<table>
<thead><th>Title</th><th>Rating</th><th>Action</th></thead>
<tbody>

<c:forEach  items=${songs} var="song">

<tr>
<td><a href="#">Shape of You</a></td>
<td>8</td>
<td><a href="">Delete</a></td>
</tr>
<tr>
<td><a href="#">Ameena</a></td>
<td>7</td>
<td><a href="">Delete</a></td>
</tr>
</tbody>
</table>
</body>
</html>