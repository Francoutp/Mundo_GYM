<%-- 
    Document   : pagRegistrarCliente
    Created on : 2 oct. 2022, 18:32:21
    Author     : ricardo
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/Recursos.jsp" %>
        <title>.:: Editar
            Cliente ::.</title>
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
        <div class="container" id="advanced-search-form">
            <form name="form1" class="form-signin-heading" action="ControlCliente" method="post">
                <%
                    Cliente c=(Cliente)request.getAttribute("entrega");
                    Usuario u=(Usuario)request.getAttribute("entrega2");
                    DecimalFormat df=new DecimalFormat("#,##0.00");
                %>
                <h3 class="p-3 bg-warning text-white" align="center">Editar Cliente</h3>
                <h6 align="right"><i>(*) Campos obligatorios</i></h6>
                <input type="hidden" name="accion" value="ModificarCliente">
                <input type="hidden" name="idcliente" value="<%=c.getIdCliente()%>">
                <input type="hidden" name="idusuario" value="<%=u.getIdUsuario()%>">
                <left>
                    <a href="pagCambioClaveCliente.jsp?nomusu=<%=u.getNombreUsuario()%>" class="btn btn-primary btn-sm">
                        <span class="glyphicon glyphicon-lock"></span>
                        Restablecer contraseña
                    </a>
                </left><br>
                <div>
                    <center><label for="subtit1">-- Datos del Cliente --</label></center>
                    <label for="nombre">Nombres (*)</label>
                    <input type="text" class="form-control" name="nombreCliente" required=""
                           value="<%=c.getNombreCliente()%>" autofocus>
                </div>
                <div>
                    <label for="apellidos">Apellidos (*)</label>
                    <input type="text" class="form-control" name="apellidoCliente" required=""
                           value="<%=c.getApellidoCliente()%>">
                </div>
                <div>
                    <label for="dni">DNI  (*)</label>
                    <input type="text" class="form-control" name="dniCliente" required=""
                           value="<%=c.getDni()%>">
                </div>
                <div>
                    <label for="direccion">Dirección</label>
                    <input type="text" class="form-control" name="direccionCliente"
                           value="<%=c.getDireccion()%>">
                </div>
                <div>
                    <label for="talla">Talla  (*)</label>
                    <input type="text" class="form-control" name="tallaCliente" required=""
                           value="<%=c.getTalla()%>">
                </div>
                <div>
                    <label for="pesoi">Peso Inicial Kg  (*)</label>
                    <input type="text" class="form-control" name="pesoInicial" required=""
                           value="<%=c.getPesoInicial()%>">
                </div>
                <div>
                    <label for="pesoa">Peso Actual Kg  (*)</label>
                    <input type="text" class="form-control" name="pesoActual" required=""
                           value="<%=c.getPesoActual()%>">
                </div>
                <div>
                    <label for="imc">Indice de Masa Corporal - IMC</label>
                    <input type="text" class="form-control" name="indice" disabled=""
                           value="<%=df.format(c.getImc())%>">
                </div>
                <div>
                    <label for="celular">Nro de Celular</label>
                    <input type="text" class="form-control" name="celularCliente" 
                           value="<%=c.getCelular()%>"/>
                </div>
                <br>
                <div>
                    <%
                        if (u.getPerfilUsuario()==1) {
                            %>
                            <label for="acceso">Nivel de Acceso (*)</label><br>
                            <input type="radio" name="accesoCliente" value="1" checked/>  Usuario Cliente<br>
                            <input type="radio" name="accesoCliente" value="2"/>  Usuario Administrador
                            <%
                        } else {
                            %>
                            <label for="acceso">Nivel de Acceso (*)</label><br>
                            <input type="radio" name="accesoCliente" value="1"/>  Usuario Cliente<br>
                            <input type="radio" name="accesoCliente" value="2" checked/>  Usuario Administrador
                            <%
                        }
                    %>
                </div><br>
                <div>
                    <button type="submit" class="btn btn-primary btn-lg" name="btnGrabar">Grabar Cambios</button>
                <button type="button" class="btn btn-primary btn-lg " name="btnCancelar" onclick="history.go(-1)">Cancelar</button>
                </div>
            </form>
        </div>
    </body>
</html>
