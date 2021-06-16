<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
window.onload=function(){
    alert('This is the time template!');
}

</script>
<body>

<p style= "color:green"; ><c:out value="${timeNow}"/></p>
</body>
</html>