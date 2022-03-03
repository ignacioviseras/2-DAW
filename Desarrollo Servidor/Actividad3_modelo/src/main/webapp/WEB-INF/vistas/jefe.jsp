<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gestion</title>
	</head>
	<body>
	<h2>Gestion</h2>
	<c:forEach var="e" items="${empleado}">
		<p>${e.nombre}</p>
	</c:forEach>
		<br></br>	
		<table border="1">
			<tr>
				<th>IdPryect</th>
				<th>Estado</th>
				<th>Terminar Ptoryct</th>
			</tr>
			<c:forEach var="p" items="${proyecto}">
			<tr>
				<td>${p.idProyecto}</td>
				<td>${p.estado}</td>
				<td><a href="/empleados/jefe/verDetalel/${p.idProyecto}">ver Mas</a></td>
			</tr>
			</c:forEach>
		</table>
		<a href="/empleados/logout">Cerrar ses</a>

		
	</body>
</html>