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

public class ControlCliente extends HttpServlet {
    
    UsuarioDao userobj=new UsuarioDao();
    ClienteDao clieobj=new ClienteDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion =request.getParameter("accion");
        if (accion.equalsIgnoreCase("registrarusuarionuevoout")) {
            registrarfuera(request,response);
        }
        if (accion.equalsIgnoreCase("registrarusuarionuevo")) {
            registrardentro(request,response);
        }
        if (accion.equalsIgnoreCase("listarclientes")) {
            listaclientes(request,response);
        }
        if (accion.equalsIgnoreCase("buscacliente")) {
            buscacliente(request,response);
        }
        if (accion.equalsIgnoreCase("modificarcliente")){
            modificacliente(request,response);
        }
        if (accion.equalsIgnoreCase("eliminarcliente")){
            eliminacliente(request,response); 
        }
    }
    
    protected void registrardentro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Usuario user=new Usuario();
        Cliente clie=new Cliente();
        user.setNombreUsuario(request.getParameter("nombreUsuario"));
        user=userobj.BuscarUsuario(user);
        if (user.getNombreUsuario()!=null) {
            request.getSession().setAttribute("mensaje", "El usuario seleccionado ya existe!");
            request.getRequestDispatcher("pagError.jsp").forward(request, response);
        } else {
            user.setNombreUsuario(request.getParameter("nombreUsuario")); //cargar usuario en variable
            if (!request.getParameter("clave").equals(request.getParameter("claveConf"))) {
                request.getSession().setAttribute("mensaje", "Las contraseñas ingresadas no coinciden!");
                request.getRequestDispatcher("pagError.jsp").forward(request, response);
            } else {
                user.setClaveusuario(request.getParameter("clave")); //cargar clave en variable
                user.setPerfilUsuario(Integer.parseInt(request.getParameter("accesoCliente"))); //cargar perfil de cliente en variable
                user.setIdUsuario(userobj.CorrelativoUsuario());//obtener correlativo de IdUsuario
                userobj.AgregarUsuario(user);//grabar usuario
                clie.setNombreCliente(request.getParameter("nombreCliente"));
                clie.setApellidoCliente(request.getParameter("apellidoCliente"));
                clie.setDni(request.getParameter("dniCliente"));
                clie.setDireccion(request.getParameter("direccionCliente"));
                clie.setTalla(Double.parseDouble(request.getParameter("tallaCliente")));
                clie.setPesoInicial(Double.parseDouble(request.getParameter("pesoCliente")));
                clie.setPesoActual(Double.parseDouble(request.getParameter("pesoCliente")));
                clie.setImc();
                clie.setIdUsuario(user.getIdUsuario());
                clie.setCelular(request.getParameter("celularCliente"));
                clieobj.AgregarCliente(clie);
                request.getSession().setAttribute("paginadestino", "pagInicio.jsp");
                request.getSession().setAttribute("mensaje", "Usuario registrado correctamente.");
                request.getRequestDispatcher("pagExito.jsp").forward(request, response);
            }
        }
    }
    
    protected void registrarfuera(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Usuario user=new Usuario();
        Cliente clie=new Cliente();
        user.setNombreUsuario(request.getParameter("nombreUsuario"));
        user=userobj.BuscarUsuario(user);
        if (user.getNombreUsuario()!=null) {
            request.getSession().setAttribute("mensaje", "El usuario seleccionado ya existe!");
            request.getRequestDispatcher("pagErrorOut2.jsp").forward(request, response);
        } else {
            user.setNombreUsuario(request.getParameter("nombreUsuario")); //cargar usuario en variable
            if (!request.getParameter("clave").equals(request.getParameter("claveConf"))) {
                request.getSession().setAttribute("mensaje", "Las contraseñas ingresadas no coinciden!");
                request.getRequestDispatcher("pagErrorOut2.jsp").forward(request, response);
            } else {
                user.setClaveusuario(request.getParameter("clave")); //cargar clave en variable
                user.setPerfilUsuario(1); //cargar perfil de cliente en variable
                user.setIdUsuario(userobj.CorrelativoUsuario());//obtener correlativo de IdUsuario
                userobj.AgregarUsuario(user);//grabar usuario
                clie.setNombreCliente(request.getParameter("nombreCliente"));
                clie.setApellidoCliente(request.getParameter("apellidoCliente"));
                clie.setDni(request.getParameter("dniCliente"));
                clie.setDireccion(request.getParameter("direccionCliente"));
                clie.setTalla(Double.parseDouble(request.getParameter("tallaCliente")));
                clie.setPesoInicial(Double.parseDouble(request.getParameter("pesoCliente")));
                clie.setPesoActual(Double.parseDouble(request.getParameter("pesoCliente")));
                clie.setImc();
                clie.setIdUsuario(user.getIdUsuario());
                clie.setCelular(request.getParameter("celularCliente"));
                clieobj.AgregarCliente(clie);
                request.getSession().setAttribute("paginadestino", "pagLogin.jsp");
                request.getSession().setAttribute("mensaje", "Usuario registrado correctamente. Inicie sesion");
                request.getRequestDispatcher("pagExitoOut.jsp").forward(request, response);
            }
        }
    }
    
    protected void listaclientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("pagListaClientes.jsp").forward(request, response);
    }
    
    protected void buscacliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int idcli=Integer.parseInt(request.getParameter("idcliente"));
        Cliente cli=clieobj.ClientePorId(idcli);
        Usuario user=userobj.BuscarUsuarioporID(cli.getIdUsuario());
        request.setAttribute("entrega", cli);
        request.setAttribute(("entrega2"), user);
        request.getRequestDispatcher("pagModificarCliente.jsp").forward(request, response);
    }
    
    protected void modificacliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Cliente cli=new Cliente();
        cli.setIdCliente(Integer.parseInt(request.getParameter("idcliente")));
        cli.setNombreCliente(request.getParameter("nombreCliente"));
        cli.setApellidoCliente(request.getParameter("apellidoCliente"));
        cli.setDni(request.getParameter("dniCliente"));
        cli.setDireccion(request.getParameter("direccionCliente"));
        cli.setTalla(Double.parseDouble(request.getParameter("tallaCliente")));
        cli.setPesoInicial(Double.parseDouble(request.getParameter("pesoInicial")));
        cli.setPesoActual(Double.parseDouble(request.getParameter("pesoActual")));
        cli.setImc();
        cli.setIdUsuario(Integer.parseInt(request.getParameter("idusuario")));
        cli.setCelular(request.getParameter("celularCliente"));
        clieobj.ModificarCliente(cli);
        Usuario usu=new Usuario();
        usu.setIdUsuario(Integer.parseInt(request.getParameter("idusuario")));
        usu.setPerfilUsuario(Integer.parseInt(request.getParameter("accesoCliente")));
        userobj.ActualizaNivelAcceso(usu);
        request.getSession().setAttribute("paginadestino", "pagListaClientes.jsp");
        request.getSession().setAttribute("mensaje", "Cliente actualizado correctamente");
        request.getRequestDispatcher("pagExito.jsp").forward(request, response);
    }
    
    protected void eliminacliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int idcli=Integer.parseInt(request.getParameter("idcliente"));
        int idusu=Integer.parseInt(request.getParameter("idusuario"));
        clieobj.EliminarCliente(idcli, idusu);
        request.getRequestDispatcher("pagListaClientes.jsp").forward(request, response);
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
