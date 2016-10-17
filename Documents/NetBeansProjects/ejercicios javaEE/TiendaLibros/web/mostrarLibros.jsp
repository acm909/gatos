<%-- 
    Document   : mostrarLibros
    Created on : 10-oct-2016, 14:15:12
    Author     : USUARIO
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="beans.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            #ima{
                width: 80%;
            }
            #car{
                width: 45px;
            }
           
        </style>
    </head>
    <body>
        <% ServletContext sc=request.getServletContext();
        ArrayList<Libro> lib =(ArrayList<Libro>) sc.getAttribute("libros");%>
        <table border="1">
            <tr>
                <td>Titulo</td>
                <td>Autor</td>
                <td>Precio</td>
                <td>Tema</td>
                <td>Añadir</td>
                
                
            </tr>
        <%for (Libro l : lib){%>
        <tr>
            <td><%=l.getTitulo()%></td>
            <td><%=l.getAutor()%></td>
            <td><%=l.getPrecio()%></td>
            <td><%=l.getTema()%></td>
            <td id="car" value="<%=l.getIdlibro()%> "><a href="ServletCarrito?pagina=uno&codigo=<%=l.getIdlibro()%>" ><img id="ima" src="images.jpg"> </a></td>
            
            
        </tr>
            
            
<%}%>
        </table>
        <br/><br/>
        <a href="acciones.html">Volver a menú principal</a>
    </body>
</html>
