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
	<form action="/empleados/login" method="post">
	<table>
			<tr>
				<td>Numero identificacion:</td>
				<td>Correo:</td>
				<td>Contraseña:</td>
			</tr>
			<tr>
				<td><input type="text" name="id"></td>
				<td><input type="text" name="correo"></td>
				<td><input type="text" name="contraseña"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
		
	</body>
</html>