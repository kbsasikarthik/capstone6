<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Login page</title>
</head>
<body>
<h1> Login</h1>
<p class="message">${message}</p>
<form action ="/login" method = "post">
<p><label for="email">User Email:</label><input id="email" name = "email" value="${param.email }" title="Please enter a valid email address"  required minlength="5" /></p>
<p>	<label for="password">Password:</label> <input id="password" type="password" name="password" required minlength="6" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
				title="Must contain at least one number and one uppercase and lowercase letter,
				and at least 8 or more characters" /></p>
<p><button>Login</button></p>

</form>
</body>
</html>