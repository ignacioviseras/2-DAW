<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="eventos?opcion=AltaEvento" method="post">
	    <h2>Rellename</h2>
        <h3>Nombre <input type='text' name='nombre' id='Nombre' placeholder='Nombre'></h3>
        <h3>Precio <input type='number' name='precio' id='Precio' placeholder='Precio'></h3>
        <h3>Descripcion <input type='text' name='descripcion' id='Descripcion' placeholder='Descripcion'></h3>
        <h3>Fecha Inicio <input type='text' name='fechaInicio' id='Fecha_Inicio' placeholder='Fecha Inicio'></h3>
        <h3>Duracion/dias <input type='number' name='duracion_dias' id='Duracion/dias' placeholder='Duracion/dias'></h3>
        <h3>Estado <input type='text' name='estado' id='estado' placeholder='Estado'></h3>
        <h3>Destacado <input type='text' name='destacado' id='Max-Aforo' placeholder='Max-Aforo'></h3>
        <h3>Max-Aforo <input type='number' name='maxAforo' id='Min-Aforo' placeholder='Min-Aforo'></h3>
        <h3>Min-Aforo <input type='number' name='minAforo' id='Min-Aforo' placeholder='Min-Aforo'></h3>
        
        <input type="submit" name="submit" id="submit">
        </form>
</body>
</html>