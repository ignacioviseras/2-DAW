<%@page import="modelo.beans.Evento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listado de Eventos</title>
	</head>
	<body>
		<table border="1">
         <tr>
            <th>Tipos</th>
            <th>Eventos</th>
            <th>Usuarios</th>
            <th>Eventos/Tipo</th>
            <th>Login</th>
            <th>Registro</th>
            <th>Salir</th>
        </tr>
        </table>
        <h2><a href="altaEvento.jsp">Alta evento</a></h2>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th colspan="3">Opciones</th>
            </tr>
            <!-- 						a esto de abajo se le llama castear -->
            <% List<Evento> evento = (List<Evento>)request.getSession().getAttribute("listaeventos"); %>
            <%for(Evento ele: evento){ %><!-- esto es un bucle que generara cada linea de datos -->
            	 <% if(ele.getEstado().equals("activo")){%><!-- Control para que salga solo los eventos que estan activos -->
		            <tr>
		                <td><%=ele.getId() %></td>
		                <td><%=ele.getNombre() %></td>
		                <td><%=ele.getPrecio()+ " €" %></td>
		                <td><a href="eventos?opcion=editar&id=<%=ele.getId() %>">Editar</a></td>
		                <td><a href="eventos?opcion=Borrar&id=<%=ele.getId() %>">Eliminar</a></td>
		                <td><a href="eventos?opcion=Cancelar&id=<%=ele.getId() %>">Cancelar</a></td>
		            </tr>
         		<%}%>
        	<%} %>
		</table>
	</body>
</html>