<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Informacion de Usuario</title>
	</head>									
	<body>
	<h2>Tu perfil</h2>
	<form action="/usuario/login" method="post">
		<table>
			<tr>
				<td>Usuario</td>
				<td>Contraseña</td>
			</tr>
			<tr>
				<td><input type="text" name="usuarioo"></td>
				<td><input type="text" name="contraseñaa"></td>
			</tr>
			<tr>
				<td><input type="submit" value="login"></td>
			</tr>
		</table>
		${NoExist}
	</form>
	</body>
</html>