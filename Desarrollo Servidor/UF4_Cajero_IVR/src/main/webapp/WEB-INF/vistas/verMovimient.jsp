<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!-- libreria para darle formato a las fechas del timstamp -->
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
	<h2>Cuenta Nº ${cuenta.idCuenta}</h2>
	<h2>Saldo: ${cuenta.saldo}</h2>	
	
	<table>
			<tr>
				<th>Cantidad</th>
				<th>Fecha</th>
				<th>Tipo</th>
			</tr>
			<c:forEach var="m" items="${movimiento}">
			<tr>
				<th>${m.cantidad}</th>
				<th><fmt:formatDate pattern="dd-MM-yyyy" value="${m.fecha}"/></th>
				<th>${m.operacion}</th>
			</tr>
			</c:forEach>
	</table>
		<br>
		<input type="submit">
		<a href="/">Volver</a>

	</body>
</html>