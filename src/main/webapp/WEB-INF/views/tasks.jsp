<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<main class="container">
	<h1>Tasks</h1>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th><th>Description</th><th>Due Date</th><th>Is Complete?</th><th>ID</th><th>Description</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="task" items="${ tasks}">
				<tr>
					<td>${task.id }</td>
					<td><a href="/tasks/${task.id }">${task.description }</a></td>
					<td>${task.duedate }</td>
					<td>${task.complete }</td>
					<td>${task.user.email}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href = "/" class = "btn btn-secondary">Home</a>
</body>
</html>