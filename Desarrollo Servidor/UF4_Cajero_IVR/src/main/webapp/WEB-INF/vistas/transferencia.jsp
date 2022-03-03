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
	<h2>Transferencia</h2>
	<form action="/acciones/transferencia" method="post">
	<table>
			<tr>
				<td>Numero de Cuenta:</td>
				<td><input type="text" name="cuentaTransfern"></td>
			</tr>
			<tr>
				<td>Cantidad:</td>
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