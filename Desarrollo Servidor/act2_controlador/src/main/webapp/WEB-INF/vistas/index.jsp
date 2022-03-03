<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listado de Eventos</title>
	</head>
	<body>
	<h2>Listado de eventos</h2>
	
			<table border="1">
         <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Fecha inicio</th>
            <th>Duracion</th>
            <th>Direccion</th>
            <th>Estado</th>
            <th>Destacado</th>
            <th>Aforo maximo</th>
            <th>Asistencia minima</th>
        </tr>
        <c:forEach var="ele" items="${listadoEventos}">
        <tr>
            <td>${ele.id}</td>
            <td>${ele.nombre}</td>
            <td>${ele.precio} €</td>
            <td>${ele.descripcion}</td>
            <td>${ele.fechaInicio}</td>
            <td>${ele.duracion_dias}</td>
            <td>${ele.estado}</td>
            <td>${ele.destacado}</td>
            <td>${ele.maxAforo}</td>
            <td>${ele.minAforo}</td>
        </tr>
        </c:forEach>
		</table>
		
		<br></br>
		<table>
		<tr>
			<td><a href="/activos">Ver Activos</a></td>
			<td><a href="/destacados">Ver Destacados</a></td>
			<td><a href="/usuario/detalle">Info Personal</a></td>
		</tr>
		</table>
	</body>
</html>