<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listado reserva</title><!--aqui utilicamos lo que se creo en el homeconttroller de tal manera-->
	</head>									<!--que si accedemos deste activos el valor se escribira activo-->
	<body>
	<h2>Listado reserva</h2><!-- lo mismo de antes -->
	<!-- se reciben los valores del homeController para que se pueda pintar -->
			<table border="1">
         <tr>
            <th>idReserva</th>
            <th>idEvento</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Observaciones</th>

        </tr>
        <c:forEach var="ele" items="${reserva}">
        <tr>
            <td>${ele.idReserva}</td>
            <td>${ele.idEvento}</td>
            <td>${ele.precio} €</td>
            <td>${ele.cantidad}</td>
            <td>${ele.observaciones}</td>
        </tr>
        </c:forEach>
		</table>
		
		<br></br>
		<table>
		<tr>
			<td><a href="/">Inicio</a></td>
			<td><a href="/activos">Ver Activos</a></td>
			<td><a href="/destacados">Ver Destacados</a></td>
		</tr>
		</table>
	</body>
</html>