
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Operaciones;

public class ServletAddLibro extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Operaciones op=new Operaciones();
        String titulo=request.getParameter("Titulo");
        String autor=request.getParameter("Autor");
        double precio=Double.parseDouble(request.getParameter("Precio"));
        int tema=Integer.parseInt(request.getParameter("temas"));        
        op.addLibro(titulo, autor,tema, precio);
        //RequestDispatcher rd=request.getRequestDispatcher("agregado.html");
        //rd.forward(request, response);
        response.sendRedirect("agregado.html");
    }
}
