/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Operaciones;


public class ServletListadoLibros extends HttpServlet {
    ServletContext sc;
    @Override
    public void init(ServletConfig config) throws ServletException{
        sc=config.getServletContext();
        super.init(config);
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Operaciones op=new Operaciones();
        ArrayList<Libro> lib=op.buscarLibro();
        sc.setAttribute("libros", lib );
        response.sendRedirect("mostrarLibros.jsp");
        }
    }
