<%@page import="Modelos.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>

<html>
    <head>
        <%@include file="../includes/Recursos.jsp" %>
        <title>.::Lista Clientes::.</title>
    </head>
    <body>
        <div class="container">
            <%@include file="../includes/Navegacion.jsp" %>
        </div>

        <div class="container" id="advanced-search-form">
            <center><h2>Lista de Clientes</h2></center> 

            <%@include file="../includes/Mensajes.jsp" %>

            <div class="clearfix"></div>
            <a href="ControlCliente?accion=registrar" class="btn btn-lg btn-primary">Registrar</a>
            <div class="row">
                <br>
                <div class="row">
                    <div class="col-md-12">
                        <table class="table table-hover table-striped table-responsive dataTable">
                            <thead>
                                <tr class="active">
                                    <th scope="col">Id</th>
                                    <th scope="col">Nombres</th>
                                    <th scope="col">DNI</th>
                                    <th scope="col">Talla</th>
                                    <th scope="col">Peso Inicial</th>
                                    <th scope="col">Peso Actual</th>
                                    <th scope="col">IMC</th>
                                    <th scope="col">Observación</th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%                                    List<Cliente> TablaListaCliente = (List<Cliente>) request.getAttribute("ListaCliente");
                                    if (TablaListaCliente != null)
                                        for (Cliente tabla_cliente : TablaListaCliente) {%>
                                <tr class="warning">
                                    <td><%= tabla_cliente.getIdCliente()%></td>
                                    <td><%= tabla_cliente.getNombreCliente() + ',' + tabla_cliente.getApellidoCliente()%></td>
                                    <td><%= tabla_cliente.getDNI()%></td>
                                    <td><%= tabla_cliente.getTalla()%></td>
                                    <td><%= tabla_cliente.getPeso_inicial()%></td>
                                    <td><%= tabla_cliente.getPeso_actual()%></td>
                                    <td><%= tabla_cliente.getIMC()%></td>
                                    <td><%= tabla_cliente.getObservacion()%></td>
                                    <td width="20px" class="p-0">
                                        <ul class="list-inline" style="margin-bottom: 0px;">
                                            <li><a href="ControlCliente?accion=editar&id=<%=tabla_cliente.getIdCliente()%>" title="Editar cliente"><span class="fa fa-pencil" aria-hidden="true"></span></a></li>
                                        </ul>
                                    </td>
                                    <td width="20px" class="p-0">
                                        <ul class="list-inline" style="margin-bottom: 0px;">
                                            <li><a href="ControlCliente?accion=eliminar&idCliente=<%=tabla_cliente.getIdCliente()%>&idUsuario=<%=tabla_cliente.getIdUsuario() %>" title="Eliminar cliente"><span class="fa fa-times" aria-hidden="true"></span></a></li>
                                        </ul>
                                    </td>
                                    <td width="20px" class="p-0">
                                        <% if (tabla_cliente.getIdUsuario() == 0) {%>
                                        <ul class="list-inline" style="margin-bottom: 0px;">
                                            <li><a href="ControlUsuario?accion=asignar_usuario&id=<%= tabla_cliente.getIdCliente()%>" title="Crear usuario-cliente"><span class="fa fa-user-o" aria-hidden="true"></span></a></li>
                                                    <%--<li><a href="Controlador?id=ListaCliente&idCliente="<%= tabla_cliente.getIdCliente()%> title="Editar"><span class="fa fa-pencil" aria-hidden="true"></span></a></li>--%>
                                        </ul>
                                        <%}%>
                                        <% if (tabla_cliente.getIdUsuario() != 0) {%>
                                        <ul class="list-inline" style="margin-bottom: 0px;">
                                            <li><a href="ControlUsuario?accion=editar_usuario&idCli=<%= tabla_cliente.getIdCliente()%>" title="Editar usuario-cliente"><span class="fa fa-user" aria-hidden="true"></span></a></li>
                                                    <%--<li><a href="Controlador?id=ListaCliente&idCliente="<%= tabla_cliente.getIdCliente()%> title="Editar"><span class="fa fa-pencil" aria-hidden="true"></span></a></li>--%>
                                        </ul>
                                        <%}%>
                                    </td>

                                </tr>
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
    </body>
</html>
