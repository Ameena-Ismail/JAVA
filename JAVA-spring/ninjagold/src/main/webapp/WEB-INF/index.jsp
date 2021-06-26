<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.1/css/bulma.min.css">
<link rel="stylesheet" href="style.css">
<script defer src="https://use.fontawesome.com/releases/v5.1.0/js/all.js"></script>
</head>
<body>
	<section>
		<div class="myContainer">
		
		<div class="field">
  		<div class="control">
    			Your Gold: <input class="input is-info" type="text" name="myGold" placeholder="<c:out value="${gold}"/>">
  			</div>
		</div>
		<div class="columns">
  			<div class="column">
    			<h1>Farm</h1>
    			<p>Earn 10-20 gold</p>
    			<form action="/findgold" method="POST"><input class="button is-warning" type="submit" value="Find Gold!"><input type="hidden" name="place" value="farm"></form>
  			</div>
  			<div class="column">
    			<h1>Cave</h1>
    			<p>Earn 5-10 gold</p>
    			<form action="/findgold" method="POST"><input class="button is-warning" type="submit" value="Find Gold!"><input type="hidden" name="place" value="cave"></form>
  			</div>
  			<div class="column">
    			<h1>House</h1>
    			<p>Earn 2-5 gold</p>
    			<form action="/findgold" method="POST"><input class="button is-warning" type="submit" value="Find Gold!"><input type="hidden" name="place" value="house"></form>
  			</div>
  			<div class="column">
    			<h1>Casino!</h1>
    			<p>Earn 0-50 gold</p>
    			<form action="/findgold" method="POST"><input class="button is-danger" type="submit" value="Find Gold!"><input type="hidden" name="place" value="casino"></form>
  			</div>
		</div>
		
		
				<div class="field">
  					<div class="control activities">
    					
    					<% ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");%>
    					<% Collections.reverse(activities); %>
    					<% for(String activity : activities) {%>
    					<p><%= activity %></p>
    					<% }%>
    					
  					</div>
				</div>
			
	</div>
	</section>
</body>
</html>