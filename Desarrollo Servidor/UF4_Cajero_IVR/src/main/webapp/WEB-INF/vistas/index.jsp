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
	<h2>inicio</h2>
	<form action="/empleados/login" method="post">
	<table>
			<tr>
				<td><a href="/operaciones/1">Ingresar</a></td>
			</tr>
			<tr>			
				<td><a href="/operaciones/2">Extraer</a></td>
			</tr>
			<tr>			
				<td><a href="/operaciones/3">Ver movimientos</a></td>
			</tr>
			<tr>			
				<td><a href="/operaciones/4">Transferencia</a></td>
			</tr>
			<tr>			
				<td><a href="/logout">Cerrar Sesion</a></td><!-- boton para q podamos cerrar la session -->
			</tr>
		</table>
	</form>
		
	</body>
</html>