<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
	<h2>${select} dinero</h2>
	<form action="/acciones/${select}" method="post">
	<table>
			<tr>
				<td>Introduce cantidad:</td>
				<td><input type="text" name="cantidad"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
				<td><a href="/">Volver</a></td>
			</tr>
		</table>
	</form>
	</body>
</html>