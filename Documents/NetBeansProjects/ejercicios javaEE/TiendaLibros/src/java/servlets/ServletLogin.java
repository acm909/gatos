/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Operaciones;

/**
 *
 * @author USUARIO
 */
public class ServletLogin extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Operaciones op = new Operaciones();
        String nombre = request.getParameter("nombre");
        String clave = request.getParameter("pass");
        if (op.validar(nombre, clave)) {
            if (request.getSession() != null) {
                request.getSession().invalidate();
            }

            HttpSession sesion = request.getSession();

            sesion.setAttribute("nombre", nombre);
            RequestDispatcher rd = request.getRequestDispatcher("acciones.jsp");
            rd.forward(request, response);//response.sendRedirect("url"); 

        } else {
            response.sendRedirect("error.html");
        }
    }
}
