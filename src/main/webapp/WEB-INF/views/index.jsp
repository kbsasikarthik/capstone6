<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
	<%@include file="partials/header.jsp" %>
	
	<p class="message">${ message }</p>
	
	<a href="/tasks">Tasks</a>
		

</body>
</html>