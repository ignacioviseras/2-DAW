<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Reserva</title><!--aqui utilicamos lo que se creo en el homeconttroller de tal manera-->
	</head>									<!--que si accedemos deste activos el valor se escribira activo-->
	<body>
	<h2>Reserva</h2><!-- lo mismo de antes -->
	<!-- se reciben los valores del homeController para que se pueda pintar -->
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
        <tr>
            <td>${evento.id}</td>
            <td>${evento.nombre}</td>
            <td>${evento.precio} €</td>
            <td>${evento.descripcion}</td>
            <td>${evento.fechaInicio}</td>
            <td>${evento.duracion_dias}</td>
            <td>${evento.estado}</td>
            <td>${evento.destacado}</td>
            <td>${evento.maxAforo}</td>
            <td>${evento.minAforo}</td>
        </tr>
		</table>
			<h3>Entradas disponibles: ${10 - reservadeUsua.cantidad}</h3>
		<form action="/reservas/verificando/${evento.id}" method="post">
			<p>¿Cuantas entradas quieres?</p><input type="number" name="cantEntradas">
		<br></br>
			<input type="submit" value="Comprar">
		</form>
			${compraEntrads}
		<br></br>
		<table>
		<tr>
			<td><a href="/">Inicio</a></td>
			<td><a href="/activos">Ver Activos</a></td>
			<td><a href="/destacados">Ver Destacados</a></td>
			<td><a href="/reservas/detalles">Ver detalles</a></td>
		</tr>
		</table>
	</body>
</html>