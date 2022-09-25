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
        
        if (request.getParameter("btnAcceder") != null) {
            Usuario usu = new Usuario();
            String user = request.getParameter("nombreUsuario");
            String clave = request.getParameter("clave");
            usu.setNombreUsuario(user);
            usu.setClaveusuario(clave);
            UsuarioDao objLogin = new UsuarioDao();
            try {
                List<Usuario> ListUsuario = new ArrayList();
                usu = objLogin.Logueo(usu);
                if (String.valueOf(usu.getPerfilUsuario()) == null) {
                    //USUARIO NO ESTA REGISTRADO
                    response.sendRedirect("pagError.jsp");
                } else {
                    switch (String.valueOf(usu.getPerfilUsuario())) {
                        case "2": {
                            //PERFIL DE ADMINISTRADOR
                            HttpSession objetoSesion = request.getSession();
                            objetoSesion.setAttribute("usuario", usu);
                            request.getSession().setAttribute("mensaje", "El usuario y/o la clave son incorrectos!");
                            response.sendRedirect("pagInicio.jsp");
                            break;
                        }
                        case "1": {
                            //PERFIL DE CLIENTE
                            HttpSession objetoSesion = request.getSession();
                            objetoSesion.setAttribute("usuario", usu);
                            response.sendRedirect("pagHome.jsp");
                            break;
                        }
                        default:
                            request.getSession().setAttribute("mensaje", "El usuario y/o la clave son incorrectos!");
                            response.sendRedirect("pagError.jsp");
                            break;
                    }
                }
            } catch (Exception ex) {
                request.getSession().setAttribute("mensaje", "El usuario y/o la clave son incorrectos!");
                response.sendRedirect("pagError.jsp");
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
