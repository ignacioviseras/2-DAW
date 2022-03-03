<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Informacion de Usuario</title><!--aqui utilicamos lo que se creo en el homeconttroller de tal manera-->
	</head>									<!--que si accedemos deste activos el valor se escribira activo-->
	<body>
	<h2>Tu perfil</h2><!-- lo mismo de antes -->
	<!-- se reciben los valores del homeController para que se pueda pintar -->
			<table border="1">
         <tr>
            <th>Nombre de usuario</th>
            <th>Contraseña</th>
            <th>email</th>
            <th>Nombre</th>
            <th>enable</th>
            <th>Fecha de creacion</th>
        </tr>
        <tr>
            <td>${usuarioSes.nombreUsuario}</td>
            <td>${usuarioSes.contraseña}</td>
            <td>${usuarioSes.email} €</td>
            <td>${usuarioSes.nombre}</td>
            <td>${usuarioSes.enable}</td>
            <td>${usuarioSes.fechaLogin}</td>
        </tr>
		</table>

		<br></br>
		<table>
		<tr>
			<td><a href="/">Inicio</a></td>
		</tr>
		</table>
	</body>
</html>