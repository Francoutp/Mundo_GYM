<%-- 
    Document   : pagLogin
    Created on : 18 set. 2022, 21:36:22
    Author     : ricardo
--%>

<%@page import="Modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet prefetch" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>.:: Cambio de Clave ::.</title>
        <%
            HttpSession objetoSesion =request.getSession();
            Usuario usu=(Usuario)objetoSesion.getAttribute("usuario");
            out.print("Datos de sesión: "+usu.toString());
        %>
    </head>
    <body>
        <div class="wrapper">
            <form class="form-signin" action="ControlUsuario">
                <center>
                    <span>
                        <img src="imagenes/logomundogym2.jpg" height="200">
                    </span>
                </center>
                <h3 align="center">Actualiza tu contraseña</h3>
                <input type="text" class="form-control" name="usuario" placeholder="<%=usu.getNombreUsuario()%>" disabled=""/>
                <input type="password" class="form-control" name="claveActual" placeholder="Contraseña Actual" required="" autofocus=""/>
                <input type="password" class="form-control" name="claveNueva" placeholder="Contraseña Nueva" required=""/>
                <input type="password" class="form-control" name="claveNuevaConf" placeholder="Confirma Contraseña Nueva" required=""/>
                <center>
                    <input type="hidden" name="accion" value="ActualizarClave">
                    <button type="submit" class="btn btn-warning btn-lg " name="btnAcceder">Cambiar</button>
                    <button type="button" class="btn btn-warning btn-lg " name="btnCancelar" onclick="history.go(-1)">Cancelar</button>
                </center>
            </form>
        </div>
    </body>
</html>
