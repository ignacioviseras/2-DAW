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
	<form action="/empleados/gestion/altaProyecto" method="post">
	<table>
			<tr>
				<td>idProyecto</td>
				<td>costesPrevisto:</td>
				<td>descripcion</td>
			</tr>
			<tr>
				<td><input type="text" name="idProyecto"></td>
				<td><input type="text" name="costesPrevisto"></td>
				<td><input type="text" name="descripcion"></td>
				
				<td><select name="jefee">
				<c:forEach var="e" items="${empleado}">
					<option value="${e.idEmpl}">${e.nombre}</option>
					</c:forEach>
				</select></td>
	
				<td><select name="clientee">
				<c:forEach var="c" items="${cliente}">
					<option value="${c.cif}">${c.nombre}</option>
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
		
	</body>
</html>