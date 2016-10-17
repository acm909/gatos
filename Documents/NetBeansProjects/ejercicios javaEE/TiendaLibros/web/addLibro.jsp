<%@page import="java.util.ArrayList"%>
<%@page import="beans.Tema"%>
<%@page import="modelo.Operaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%Operaciones op=new Operaciones();
        ArrayList<Tema> t=op.listarTemas();%>
        <center>
            <form action="ServletAddLibro" method="post">            
                <input placeholder="Titulo" type="text" name="Titulo" required><br/>
                <input placeholder="Autor" type="text" name="Autor" required><br/>
                <input placeholder="Precio" type="text" name="Precio" required><br/>
                <select name="temas">
                    <%for(Tema tem:t){%>
                    <option value="<%=tem.getIdtema()%>"><%=tem.getTema()%></option>
                    <%}%>                
                </select>
                <!-- recorremos los temas y mostramos el nombre del tema y añadimos como valor el id del tema-->
                <input type="submit" value="Agregar libro">                
            </form>
        </center>
    <br/><br/>
    <a href="acciones.html">Volver a menú principal</a>
    </body>
</html>
