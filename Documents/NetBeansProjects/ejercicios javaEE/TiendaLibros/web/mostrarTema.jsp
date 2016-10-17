<%-- 
    Document   : mostrarTema
    Created on : 11-oct-2016, 8:50:37
    Author     : AntonioCaballero®CopyRight //Quienes reproduzcan y/o distribuyan publicamente dicho contenido, ya veremos lo que pasa.
--%>

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
        <form action="mostrarTemaBuscado.jsp" method="post">
            <select name="temas">
                <%for(Tema tem:t){%>
                <option value="<%=tem.getIdtema()%>"><%=tem.getTema()%></option>
                <%}%>                
            </select>
            <input type="submit" value="Buscar">                    
        </form>
        <br/><br/>
        <a href="acciones.html">Volver a menú principal</a>
    </body>
</html>
