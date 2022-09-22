package Controlador;

import Dao.ClienteDao;
import Dao.UsuarioDao;
import Modelos.Cliente;
import Modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlUsuario extends HttpServlet {

    private ClienteDao cliDao = new ClienteDao();
    private UsuarioDao userDao = new UsuarioDao();
    private final String PagAsignar = "/admin/PagClienteAsignarUsuario.jsp";
    private final String PagEditar = "/admin/PagClienteEditarUsuario.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");

        if (accion.equalsIgnoreCase("asignar_usuario")) {
            AsignarUsuario(request, response);
        } else if (accion.equalsIgnoreCase("registrar_usuario")) {
            RegistrarUsuario(request, response);
        } else if (accion.equalsIgnoreCase("editar_usuario")) {
            EditarUsuario(request, response);
        } else if (accion.equalsIgnoreCase("guardar_edicion")) {
            GuardarEdicion(request, response);
        }
    }

    protected void GuardarEdicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Cliente objCli = new Cliente();
        objCli.setIdUsuario(Integer.parseInt(request.getParameter("id")));
        objCli.setNombreUsuario(request.getParameter("nombreUsuario"));
        objCli.setClaveusuario(request.getParameter("clave"));
        String msg = userDao.EditarUsuario(objCli);

        if (msg.equals("OK")) {
            request.getSession().setAttribute("success", "Los datos del usuario se editaron de forma correcta.");
        } else {
            request.getSession().setAttribute("error", msg);
        }

        response.sendRedirect("ControlCliente?accion=listar");
    }

    protected void EditarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("idCli"));

        request.setAttribute("cliente", cliDao.ObtenerUsuario(id));
        request.getRequestDispatcher(PagEditar).forward(request, response);
    }

    protected void RegistrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Usuario objUsu = new Usuario();
        objUsu.setIdUsuario(Integer.parseInt(userDao.CorrelativoUsuario()));
        objUsu.setNombreUsuario(request.getParameter("nombreUsuario"));
        objUsu.setClaveusuario(request.getParameter("clave"));
        objUsu.setPerfilUsuario(1);
        String msg = userDao.RegistrarUsuario(objUsu);

        if (msg.equals("OK")) {
            Cliente objCli = new Cliente();
            objCli.setIdUsuario(objUsu.getIdUsuario());
            objCli.setIdCliente(Integer.parseInt(request.getParameter("id")));
            msg = cliDao.Update_UsuarioCliente(objCli);

            if (msg.equals("OK")) {
                request.getSession().setAttribute("success", "Los datos del usuario se guardaron de forma correcta.");
            } else {
                request.getSession().setAttribute("error", msg);
            }
        } else {
            request.getSession().setAttribute("error", msg);
        }

        response.sendRedirect("ControlCliente?accion=listar");
    }

    protected void AsignarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("cliente", cliDao.BuscarPorId(id));
        request.getRequestDispatcher(PagAsignar).forward(request, response);
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
