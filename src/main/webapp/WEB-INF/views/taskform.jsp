<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>${ title }</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" />
<!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<main class="container">
		<h1>${ title }</h1>
		<form method="post">
			<div class="form-group">
			    <label for="name">Description</label>
			    <input class="form-control" type="text" id="description" name="description" value="${task.description}" required minlength="2" autocomplete="off">
			</div>
			<div class="form-group">
			    <label for="category">Due Date</label>
			    <input class="form-control" type ="date" id="duedate" name="duedate" value="${task.duedate}" required>
			</div>
			<div class="form-group">
			    <label for="complete">Complete</label>
			    <input class="form-control" type ="text" id="complete" name="complete" value="${task.complete?'yes':'no'}" >
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="/tasks" class="btn btn-danger">Cancel</a>
		</form>
	</main>
</body>
</html>