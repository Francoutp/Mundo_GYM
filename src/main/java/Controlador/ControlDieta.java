package Controlador;

import Dao.DietaDao;
import Modelos.Dieta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControlDieta extends HttpServlet {

    DietaDao objetodieta=new DietaDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion=request.getParameter("accion");
        if (accion.equalsIgnoreCase("registrardietanueva")) {
            agregar(request,response);
        }
        if (accion.equalsIgnoreCase("buscadieta")) {
            buscar(request,response);
        }
        if (accion.equalsIgnoreCase("modificardieta")) {
            modificar(request,response);
        }
    }
    
    protected void agregar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Dieta d=new Dieta();
        d.setNombreDieta(request.getParameter("nombreDieta"));
        d.setIdTipoDieta(Integer.parseInt(request.getParameter("tipoDieta")));
        d.setIdHorarioDieta(Integer.parseInt(request.getParameter("horaDieta")));
        objetodieta.AgregarDieta(d);
        request.getSession().setAttribute("paginadestino", "pagListaDietas.jsp");
        request.getSession().setAttribute("mensaje", "Dieta registrada correctamente.");
        request.getRequestDispatcher("pagExito.jsp").forward(request, response);
    }
    
    protected void modificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Dieta d=new Dieta();
        d.setIdDieta(Integer.parseInt(request.getParameter("iddieta")));
        d.setNombreDieta(request.getParameter("nombreDieta"));
        d.setIdTipoDieta(Integer.parseInt(request.getParameter("tipoDieta")));
        d.setIdHorarioDieta(Integer.parseInt(request.getParameter("horaDieta")));
        objetodieta.ModificarDieta(d);
        request.getSession().setAttribute("paginadestino", "pagListaDietas.jsp");
        request.getSession().setAttribute("mensaje", "Dieta actualizada correctamente.");
        request.getRequestDispatcher("pagExito.jsp").forward(request, response);
    }
    
    protected void buscar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int iddie=Integer.parseInt(request.getParameter("iddieta"));
        Dieta dieta=objetodieta.DietaPorId(iddie);
        request.setAttribute("entrega", dieta);
        request.getRequestDispatcher("pagModificarDieta.jsp").forward(request, response);
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
