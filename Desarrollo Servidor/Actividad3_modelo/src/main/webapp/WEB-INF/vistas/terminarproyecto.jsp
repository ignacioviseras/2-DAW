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
	<h2>Login</h2>
	<form action="/empleados/gestion/terminarProyecto/${idProyecto}" method="post">
	<table>
			<tr>
				<td>Coste real:</td>
			</tr>
			<tr>
				<td><input type="text" name="costeReal"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
		
	</body>
</html>