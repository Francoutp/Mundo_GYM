package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import Modelos.*;
import java.util.*;
import javax.servlet.http.*;

/**
 * Fecha:24/09/2022 
 * Versión: 1.1
 * @author ricardo
 */
public class ControlAcceso extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion=request.getParameter("accion");
        if (accion.equalsIgnoreCase("login")) {
            login(request,response);
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("nombreUsuario");
        String clave = request.getParameter("clave");
        Usuario usu = new Usuario();
        usu.setNombreUsuario(user);
        //usu.setClaveusuario(clave);
        UsuarioDao objLogin = new UsuarioDao();
        usu=objLogin.BuscarUsuario(usu);
        if (usu.getNombreUsuario()==null) {
            request.getSession().setAttribute("mensaje", "El usuario no existe!");
            response.sendRedirect("pagErrorOut.jsp");
        } else {
            if (!usu.getClaveusuario().equals(clave)) {
                request.getSession().setAttribute("mensaje", "La clave ingresada no es correcta!");
                response.sendRedirect("pagErrorOut2.jsp");
            } else {
                Cliente cli=new Cliente();
                ClienteDao objbusqueda = new ClienteDao();
                cli=objbusqueda.ClientePorIdUsuario(usu.getIdUsuario());
                HttpSession objetoSesion = request.getSession();
                objetoSesion.setAttribute("usuario", usu);
                objetoSesion.setAttribute("cliente", cli);
                response.sendRedirect("pagInicio.jsp");
            }
        }
    }          
        
     

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
