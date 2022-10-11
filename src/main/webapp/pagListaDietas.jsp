<%-- 
    Document   : pagListaClientes
    Created on : 2 oct. 2022, 20:27:29
    Author     : ricardo
--%>

<%@page import="Modelos.Dieta"%>
<%@page import="Dao.DietaDao"%>
<%@page import="Dao.ClienteDao,Modelos.Cliente,java.util.*,java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/Recursos.jsp" %>
        <title>.:: Lista de Clientes ::.</title>
    </head>
    <body>
        <div class="container">
            <%
                HttpSession objetoSesion = request.getSession();
                Usuario usu = (Usuario) objetoSesion.getAttribute("usuario");
                Cliente cli = (Cliente) objetoSesion.getAttribute("cliente");
                if (usu.getPerfilUsuario()==1) {
                %>
                <%@include file="includes/menuCliente.jsp" %>
                <%
                } else {
                %>
                <%@include file="includes/menuAdministrador.jsp" %>
                <%
                }
            %>
        </div>
        <div class="container">
            <h3 class="p-3 bg-warning text-white" align="center">Lista de Dietas</h3>
            <br>
            <%--<left><a class="btn btn-success" href="pagRegistrarCliente.jsp">Registrar Nuevo Cliente</a></left>--%>
            <form id="fr1"action="pagRegistrarDieta.jsp" method="post">
                <left>
                    <button type="submit" class="btn btn-warning" name="btnNuevoCli">
                        <span class="fa fa-heartbeat"></span>
                        Nueva Dieta
                    </button>
                </left>
            </form>
            <br>
            <center>
                <table class="table table-striped table-bordered">
                    <tr>
                        <th class="bg-dark text-white" style="text-align: center">Id</th>
                        <th class="bg-dark text-white" style="text-align: center">Nombres de la Dieta</th>
                        <th class="bg-dark text-white" style="text-align: center">Tipo de Dieta</th>
                        <th class="bg-dark text-white" style="text-align: center">Horario de Dieta</th>
                        <th class="bg-dark text-white" style="text-align: center">Editar</th>
                        <th class="bg-dark text-white" style="text-align: center">Eliminar</th>
                    </tr>
                    <%                        
                        DietaDao objeto = new DietaDao();
                        DecimalFormat df = new DecimalFormat("#,##0.00");
                        for (Dieta x : objeto.ListaTotalDietas()) {
                            out.print("<tr><td style='text-align: center'>" + x.getIdDieta()
                                    + "<td>" + x.getNombreDieta()
                                    + "<td style='text-align: center'>" + objeto.BuscarTipoDietaPorID(x.getIdTipoDieta())
                                    + "<td style='text-align: center'>" + objeto.BuscarHorarioPorID(x.getIdHorarioDieta()));
                    %>
                    <td style="text-align: center">
                        <form id="fr2" action="ControlDieta" method="post">
                            <input type="hidden" name="accion" value="BuscaDieta">
                            <input type="hidden" name="iddieta" value="<%=x.getIdDieta()%>">
                            <button type="submit" class="btn btn-success btn-block" name="btnModificar">
                                <span class="glyphicon glyphicon-edit"></span>
                            </button>
                        </form>

                        <%--<a href="ControlCliente?accion=ModificarCliente&nro=<%=x.getIdCliente()%>">
                            <img src="imagenes/btn_modificar.JPG" height="30" width="30">
                        </a>--%>
                    </td>
                    <td style="text-align: center">
                        <a class="btn btn-danger btn-block" href="ControlDieta?accion=EliminarDieta&iddieta=<%=x.getIdDieta()%>" onclick="return confirm('¿Esta seguro de eliminar la dieta?')">
                            <span class="glyphicon glyphicon-erase"></span>
                        </a>
                        <%--<form id="fr3" name="form3" action="ControlCliente" method="get">
                            <input type="hidden" name="accion" value="EliminarCliente">
                            <input type="hidden" name="idcliente" value="<%=x.getIdCliente()%>">
                            <input type="hidden" name="idusuario" value="<%=x.getIdUsuario()%>">
                            <button type="button" class="btn btn-danger btn-block" onclick="ConfirmaEliminar()" name="btnEliminar">
                                <span class="glyphicon glyphicon-erase"></span>
                            </button>
                        </form>--%>
                        <%--<a href="ControlCliente?accion=EliminarCliente&nro=<%=x.getIdCliente()%>">
                            <img src="imagenes/btn_elimina.JPG" height="30" width="30">
                        </a>--%>
                    </td>
                    <%
                        }
                    %>
                </table>
            </center>
        </div>
    </body>
</html>
