package Controlador;

import Dao.ClienteDao;
import Dao.UsuarioDao;
import Modelos.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlCliente extends HttpServlet {

    private ClienteDao cliDao = new ClienteDao();
    private UsuarioDao userDao = new UsuarioDao();
    private final String PagListar = "/admin/PagClienteListar.jsp";
    private final String PagAgregar = "/admin/PagClienteAgregar.jsp";
    private final String PagEditar = "/admin/PagClienteEditar.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        if (accion.equalsIgnoreCase("listar")) {
            Listar(request, response);
        } else if (accion.equalsIgnoreCase("registrar")) {
            Agregar(request, response);
        } else if (accion.equalsIgnoreCase("guardar_datos")) {
            GuardarDatos(request, response);
        } else if (accion.equalsIgnoreCase("editar")) {
            Editar(request, response);
        } else if (accion.equalsIgnoreCase("guardar_edicion")) {
            GuardarEdicion(request, response);
        } else if (accion.equalsIgnoreCase("eliminar")) {
            Eliminar(request, response);
        }
    }

    protected void Eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int idCli = Integer.parseInt(request.getParameter("idCliente"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String msg;

        msg = cliDao.EliminarCliente(idCli);
        if (msg.equals("OK")) {
            if (idUsuario != 0) {
                msg = userDao.EliminarUsuario(idUsuario);
                if (msg.equals("OK")) {
                    request.getSession().setAttribute("success", "Los datos del cliente se eliminaron de forma correcta.");
                } else {
                    request.getSession().setAttribute("error", msg);
                }
            } else {
                request.getSession().setAttribute("success", "Los datos del cliente se eliminaron de forma correcta.");
            }
        } else {
            request.getSession().setAttribute("error", msg);
        }

        response.sendRedirect("ControlCliente?accion=listar");
    }

    protected void Editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("cliente", cliDao.BuscarPorId(id));
        request.getRequestDispatcher(PagEditar).forward(request, response);
    }

    protected void GuardarEdicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String msje = "";
        Double IMC;

        Cliente cliente = new Cliente();
        cliente.setIdCliente(Integer.parseInt(request.getParameter("id")));
        cliente.setNombreCliente(request.getParameter("nombreCliente"));
        cliente.setApellidoCliente(request.getParameter("apellidoCliente"));
        cliente.setDNI(request.getParameter("DNI"));
        cliente.setCelular(request.getParameter("Celular"));
        cliente.setDireccion(request.getParameter("Direccion"));
        cliente.setTalla(Double.parseDouble(request.getParameter("Talla")));
        cliente.setPeso_inicial(Double.parseDouble(request.getParameter("Peso")));
        cliente.setPeso_actual(null);
        IMC = (Double.parseDouble(request.getParameter("Peso")) / Math.pow(Double.parseDouble(request.getParameter("Talla")), 2));
        cliente.setIMC(IMC);
        String msg = cliDao.EditarCliente(cliente);

        if (msg.equals("OK")) {
            request.getSession().setAttribute("success", "Los datos del cliente se editaron de forma correcta.");
        } else {
            request.getSession().setAttribute("error", msg);
        }

        response.sendRedirect("ControlCliente?accion=listar");
    }

    protected void GuardarDatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String msje = "";
        Double IMC;
        Cliente cliente = new Cliente();
        cliente.setIdCliente(cliDao.Id_Correlativo_Cliente());
        cliente.setNombreCliente(request.getParameter("nombreCliente"));
        cliente.setApellidoCliente(request.getParameter("apellidoCliente"));
        cliente.setDNI(request.getParameter("DNI"));
        cliente.setCelular(request.getParameter("Celular"));
        cliente.setDireccion(request.getParameter("Direccion"));
        cliente.setTalla(Double.parseDouble(request.getParameter("Talla")));
        cliente.setPeso_inicial(Double.parseDouble(request.getParameter("Peso")));
        cliente.setPeso_actual(null);
        IMC = (Double.parseDouble(request.getParameter("Peso")) / Math.pow(Double.parseDouble(request.getParameter("Talla")), 2));
        cliente.setIMC(IMC);
        String msg = cliDao.RegistrarCliente(cliente);

        if (msg.equals("OK")) {
            request.getSession().setAttribute("success", "Los datos del cliente se registraron de forma correcta.");
        } else {
            request.getSession().setAttribute("error", msg);
        }

        response.sendRedirect("ControlCliente?accion=listar");
    }

    protected void Agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.getRequestDispatcher(PagAgregar).forward(request, response);
    }

    protected void Listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("ListaCliente", cliDao.ListarTodos());
        request.getRequestDispatcher(PagListar).forward(request, response);
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
