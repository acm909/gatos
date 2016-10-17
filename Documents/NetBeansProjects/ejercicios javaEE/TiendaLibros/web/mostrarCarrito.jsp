<%-- 
    Document   : mostrarCarrito
    Created on : 11-oct-2016, 12:41:11
    Author     : USUARIO
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="beans.Libro"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de la compra</title>
    </head>
    <body>
        <%! double total=0;
        int cont=0;%>
        <% if (request.getSession().getAttribute("compras")==null){%>
            <h1>No hay productos en el carrito</h1>
        <%}else{%>
        
        
        <% HttpSession sesion = request.getSession();
            
            ArrayList<Libro> libros;
            libros = (ArrayList<Libro>) sesion.getAttribute("compras");%><!-- casting para usar un objeto como necesitamos (en este caso, un ArrayList)-->
        <h1>Carrito</h1>
        <table border="1">
            <tr>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Eliminar</th>
                <th>Precio</th>
               

            </tr>
            
               <% for (Libro l : libros) {
                   total+=l.getPrecio();%>
            <tr>
                <td><%=l.getTitulo()%></td>
                <td><%=l.getAutor()%></td>
                <td><a href="ServletEliminar?codigo=<%=cont%>">Eliminar</a></td>
                <td><%=l.getPrecio()%></td>
                
                
            </tr>
            <%cont++;%>
            <%}%>
            <tr>
                <td colspan="3">El precio total del pedido es: </td>
                <td><%=total%></td>
            </tr>
        </table>
            
        <%}%>
        <%total=0;cont=0;%>
        <a href="acciones.jsp">Volver al menú</a>
        
    </body>
</html>
