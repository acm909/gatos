/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Libro;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Antonio1
 */
public class ServletEliminar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo=Integer.parseInt(request.getParameter("codigo"));
        HttpSession sesion=request.getSession();
        ArrayList<Libro> libros=(ArrayList<Libro>)sesion.getAttribute("compras");
        libros.remove(codigo);
        sesion.setAttribute("compras", libros);
        RequestDispatcher rd= request.getRequestDispatcher("mostrarCarrito.jsp");
        rd.forward(request, response);
        
        
    }

  

}
