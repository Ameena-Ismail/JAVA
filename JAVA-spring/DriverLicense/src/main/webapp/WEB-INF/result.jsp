<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>License Assignment</title>
</head>
<body>
	<h1><c:out value="${person.firstName} ${person.lastName }"/></h1>
	<h3>License number  <c:out value="${person.license.number}"/></h3>
	<h3>State   <c:out value="${person.license.state}" /></h3>
	
	<%-- <h3>Expiration Date   <c:out value="${person.license.expiration_date}" /></h3> --%>
	
	<!-- Convert and format date in JSP compare to above-->
	<!-- include this "<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>" on top of the page -->
	<h3>Expiration Date   <fmt:formatDate value="${person.license.expiration_date}" pattern="MM-dd-yyyy" /></h3>
	
</body>
</html>