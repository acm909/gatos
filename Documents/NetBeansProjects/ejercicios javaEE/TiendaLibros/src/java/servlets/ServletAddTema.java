
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Operaciones;

public class ServletAddTema extends HttpServlet {
  
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Operaciones op=new Operaciones();
        String tematica=request.getParameter("tematica");
        op.addTema(tematica);
        RequestDispatcher rd=request.getRequestDispatcher("agregado.html");//traemos los datos de agregado.html. Por otro lado, response.sendRedirect te manda a dicha url
        rd.forward(request, response);
    }
}
