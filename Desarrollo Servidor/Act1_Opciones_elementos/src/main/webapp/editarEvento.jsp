<%@page import="modelo.beans.Evento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
        <h2>Lista de Evento</h2>
        <table border="1">
           <!-- 					le ponemos entre parentesis lo que le vamos a pasar-->
            <% Evento evento = (Evento)request.getAttribute("evento"); %>
            <!--lista de todos los datos del elemento en el que pinchaste-->
            <tr>
                <td>Id</td>
                <td><%=evento.getId() %></td>
            </tr>
            <tr>
            	<td>Nombre</td>
            	<td><%=evento.getNombre() %></td>
            </tr>
            <tr>
                <td>Precio</td>
            	<td><%=evento.getPrecio() %></td>
            </tr>
            <tr>
            	<td>Descripcion</td>
            	<td><%=evento.getDescripcion() %></td>
            </tr>
            <tr>
            	<td>Fecha inicio</td>
            	<td><%=evento.getFechaInicio() %></td>
            </tr>
            <tr>
            	<td>Duracion</td>
            	<td><%=evento.getDuracion_dias() %></td>
            </tr>
            <tr>
            	<td>Estado</td>
            	<td><%=evento.getEstado() %></td>
            </tr>
            <tr>
            	<td>Destacado</td>
            	<td><%=evento.getDestacado() %></td>
            </tr>
            <tr>
            	<td>Maximo Aforo</td>
            	<td><%=evento.getMaxAforo() %></td>
            </tr>
            <tr>
				<td>Minimo Aforo</td>
                <td><%=evento.getMinAforo() %></td>
            </tr>
            <tr>
				<td>ID Tipo</td>
                <td><%=evento.getIdTipo().getID() %></td>
            </tr>
              <tr>
				<td>Descripcion Tipo</td>
                <td><%=evento.getIdTipo().getDescripcion() %></td>
            </tr>
        	</table>
        	 <a href="index.jsp">Volver</a><!-- boton para volver al inicio -->
	</body>
</html>