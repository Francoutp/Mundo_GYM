<%-- 
    Document   : pagListaClientes
    Created on : 2 oct. 2022, 20:27:29
    Author     : ricardo
--%>

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
            <h3 class="p-3 bg-warning text-white" align="center">Lista de Clientes</h3>
            <br>
            <%--<left><a class="btn btn-success" href="pagRegistrarCliente.jsp">Registrar Nuevo Cliente</a></left>--%>
            <form id="fr1"action="pagRegistrarCliente.jsp" method="post">
                <left>
                    <button type="submit" class="btn btn-warning" name="btnNuevoCli">
                        <span class="glyphicon glyphicon-user"></span>
                        Nuevo usuario
                    </button>
                </left>
            </form>
            <br>
            <center>
                <table class="table table-striped table-bordered">
                    <tr>
                        <th class="bg-dark text-white" style="text-align: center">Id</th>
                        <th class="bg-dark text-white" style="text-align: center">Nombres y Apellidos</th>
                        <th class="bg-dark text-white" style="text-align: center">DNI</th>
                        <th class="bg-dark text-white" style="text-align: center">Dirección</th>
                        <th class="bg-dark text-white" style="text-align: center">Talla</th>
                        <th class="bg-dark text-white" style="text-align: center">Peso Inicial (Kg)</th>
                        <th class="bg-dark text-white" style="text-align: center">Peso Actual (Kg)</th>
                        <th class="bg-dark text-white" style="text-align: center">IMC</th>
                            <%--<th style="text-align: center">IdUsuario</th>--%>
                        <th class="bg-dark text-white" style="text-align: center">Celular</th>
                        <th class="bg-dark text-white" style="text-align: center">Observación</th>
                        <th class="bg-dark text-white" style="text-align: center">Editar</th>
                        <th class="bg-dark text-white" style="text-align: center">Eliminar</th>
                    </tr>
                    <%                        ClienteDao objeto = new ClienteDao();
                        DecimalFormat df = new DecimalFormat("#,##0.00");
                        for (Cliente x : objeto.ListaTotalClientes()) {
                            out.print("<tr><td style='text-align: center'>" + x.getIdCliente()
                                    + "<td>" + x.getNombreCliente() + " " + x.getApellidoCliente()
                                    + "<td style='text-align: center'>" + x.getDni()
                                    + "<td>" + x.getDireccion()
                                    + "<td style='text-align: right'>" + df.format(x.getTalla())
                                    + "<td style='text-align: right'>" + df.format(x.getPesoInicial())
                                    + "<td style='text-align: right'>" + df.format(x.getPesoActual())
                                    + "<td style='text-align: right'>" + df.format(x.getImc())
                                    //+"<td style='text-align: right'>"+x.getIdUsuario()
                                    + "<td style='text-align: right'>" + x.getCelular()
                                    + "<td style='text-align: center'>" + x.getObservacion());
                    %>
                    <td style="text-align: center">
                        <form id="fr2" action="ControlCliente" method="post">
                            <input type="hidden" name="accion" value="BuscaCliente">
                            <input type="hidden" name="idcliente" value="<%=x.getIdCliente()%>">
                            <button type="submit" class="btn btn-success btn-block" name="btnModificar">
                                <span class="glyphicon glyphicon-edit"></span>
                            </button>
                        </form>

                        <%--<a href="ControlCliente?accion=ModificarCliente&nro=<%=x.getIdCliente()%>">
                            <img src="imagenes/btn_modificar.JPG" height="30" width="30">
                        </a>--%>
                    </td>
                    <td style="text-align: center">
                        <a class="btn btn-danger btn-block" href="ControlCliente?accion=EliminarCliente&idcliente=<%=x.getIdCliente()%>&idusuario=<%=x.getIdUsuario()%>" onclick="return confirm('¿Esta seguro de eliminar el cliente?')">
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
