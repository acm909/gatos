package servlets;

import beans.Libro;
import java.io.IOException;

import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Operaciones;

public class ServletCarrito extends HttpServlet {

    ArrayList<Libro> libros;
    Operaciones op = new Operaciones();

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        if (sesion.getAttribute("compras") != null) {
            libros = (ArrayList<Libro>) sesion.getAttribute("compras");
        } else {

            libros = new ArrayList<>();
        }
        String idlibro = request.getParameter("codigo");
        libros.add(op.buscarId(idlibro));

        sesion.setAttribute("compras", libros);
        String pagina = request.getParameter("pagina");
        if (pagina.equals("uno")) {
            RequestDispatcher rd = request.getRequestDispatcher("mostrarLibros.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("mostrarTema.jsp");
            rd.forward(request, response);

        }

    }
}
