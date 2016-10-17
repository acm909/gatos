
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <% 
            HttpSession sesion=request.getSession();
            if (sesion.getAttribute("nombre")==null){%>
                <h1>Todavia no te has logeado o tu sesion ha caducado</h1>
            <%} else{
        String nombre= sesion.getAttribute("nombre").toString();%>
        <h1>bienvenido  <%=nombre%> </h1>
        <a href="ServletCerrarSesion">Cerrar sesion</a>
        <center>
            <a href="ServletListadoLibros">Listado de todos los libros</a></br></br>
            <a href="mostrarTema.jsp">Buscar libro por tema</a></br></br>
            <a href="addLibro.jsp">Añadir libro</a></br></br>
            <a href="addTema.html">Añadir tema</a></br></br>
            <a href="mostrarCarrito.jsp">Ver el carro que me robaron</a>
        </center>
    <%}%>
    <a href="index.html">Vover al login</a>
    </body>
</html>

