package Controlador;

import Conexion.MySQLConexion;
import Dao.UsuarioDao;
import Modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControlUsuario extends HttpServlet {

    UsuarioDao obj=new UsuarioDao();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion =request.getParameter("accion");
        if (accion.equalsIgnoreCase("actualizarclave")) {
            actualizar(request,response);
        }
        if (accion.equalsIgnoreCase("actualizarclaveadm")) {
            actualizaradm(request,response);
        }
    }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String usu=request.getParameter("usuario");
        String clave1=request.getParameter("claveActual");
        HttpSession objetoSesion =request.getSession();
        Usuario user=(Usuario)objetoSesion.getAttribute("usuario");
        if (!clave1.equals(user.getClaveusuario())) {
            request.getSession().setAttribute("mensaje", "La contraseña actual ingresada es incorrecta");
            request.getRequestDispatcher("/pagError.jsp").forward(request, response);
        }else{
            String clave2=request.getParameter("claveNueva");
            String clave3=request.getParameter("claveNuevaConf");
            if (!clave2.equals(clave3)) {
               request.getSession().setAttribute("mensaje", "Las contraseñas nuevas ingresadas no coinciden");
               request.getRequestDispatcher("/pagError.jsp").forward(request, response);
            } else{
                user.setClaveusuario(clave3);
                objetoSesion.setAttribute("usuario", user);//validar si actualiza objeto de sesion
                obj.actualizar(user);
                request.getSession().setAttribute("paginadestino", "pagLogin.jsp");
                request.getSession().setAttribute("mensaje", "Contraseña Actualizada. Inicie sesion nuevamente");
                request.getRequestDispatcher("/pagExito.jsp").forward(request, response);
            }
        }
    }
    
    protected void actualizaradm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Usuario u=new Usuario();
        u.setNombreUsuario(request.getParameter("usuenviar"));
        String clave1=request.getParameter("claveActual");
        Usuario u2=obj.BuscarUsuario(u);
        if (!clave1.equals(u2.getClaveusuario())) {
            request.getSession().setAttribute("mensaje", "La clave actual ingresada es incorrecta");
            request.getRequestDispatcher("/pagError.jsp").forward(request, response);
        }else{
            String clave2=request.getParameter("claveNueva");
            String clave3=request.getParameter("claveNuevaConf");
            if (!clave2.equals(clave3)) {
               request.getSession().setAttribute("mensaje", "Las contraseñas nuevas ingresadas no coinciden");
               request.getRequestDispatcher("/pagError.jsp").forward(request, response);
            } else{
                u2.setClaveusuario(clave3);
                obj.actualizar(u2);
                request.getSession().setAttribute("paginadestino", "pagListaClientes.jsp");
                request.getSession().setAttribute("mensaje", "Contraseña Actualizada Correctamente");
                request.getRequestDispatcher("/pagExito.jsp").forward(request, response);
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
