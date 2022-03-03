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
	<form action="/login" method="post">
	<table>
			<tr>
				<td>Numero de Cuenta:</td>
				<td><input type="text" name="cuenta"></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
		${Eror}<!-- este mensaje saltara si el Nº de cuenta esta mal -->
		
	</body>
</html>