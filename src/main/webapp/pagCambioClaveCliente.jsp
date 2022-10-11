<%-- 
    Document   : pagLogin
    Created on : 18 set. 2022, 21:36:22
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/Recursos.jsp" %>
        <title>.:: Cambio de Clave ::.</title>
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
        <div class="wrapper">
            <form class="form-signin" action="ControlUsuario">
                <h3 align="center">Actualiza la contraseña</h3>
                <input type="text" class="form-control" name="usuregi" value="<%=request.getParameter("nomusu")%>" disabled=""/>
                <input type="password" class="form-control" name="claveActual" placeholder="Contraseña Actual" required="" autofocus=""/>
                <input type="password" class="form-control" name="claveNueva" placeholder="Contraseña Nueva" required=""/>
                <input type="password" class="form-control" name="claveNuevaConf" placeholder="Confirma Contraseña Nueva" required=""/>
                <center>
                    <input type="hidden" name="usuenviar" value="<%=request.getParameter("nomusu")%>">
                    <input type="hidden" name="accion" value="ActualizarClaveAdm">
                    <button type="submit" class="btn btn-warning btn-lg btn-block" name="btnAcceder">Cambiar</button>
                    <button type="button" class="btn btn-warning btn-lg btn-block" name="btnCancelar" onclick="history.go(-1)">Cancelar</button>
                </center>
            </form>
        </div>
    </body>
</html>
