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
	<table border="1">
		<tr>
			<th>Id de Proyecto</th>
			<th>costesPrevisto</th>
			<th>descripcion</th>
			<th>estado</th>
			<th>Accion</th>
		</tr>
		<tr>
			<td>${proyecto.idProyecto}</td>
            <td>${proyecto.costesPrevisto} €</td>
            <td>${proyecto.descripcion}</td>
            <td>${proyecto.estado}</td>
            <td><a href="/empleados/login">volver</a></td>
		</tr>
		</table>
		
	</body>
</html>