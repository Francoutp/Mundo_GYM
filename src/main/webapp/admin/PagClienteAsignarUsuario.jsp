<%@page import="Modelos.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../includes/Recursos.jsp" %>
        <title>.::Usuario::.</title>
    </head>

    <body>
        <div class="container">
            <%@include file="../includes/Navegacion.jsp" %>
        </div>

        <%
            Cliente obj = (Cliente) request.getAttribute("cliente");
        %>
        <div class="wrapper">
            <form class="form-signin" action="ControlUsuario" method="POST">

                <center><span><img src="./imagenes/logofitness3.jpg"></span></center>
                <h2 align="center">Crear usuario </h2>

                <input type="text" class="form-control"  name="nombreUsuario" placeholder="Nombre de Usuario" required=""/>
                <input type="password" class="form-control" name="clave" placeholder="Clave" required="" autofocus=""/>
                <input type="hidden" name="id" value="<%=obj.getIdCliente()%>">
                <input type="hidden" name="accion" value="registrar_usuario">
                <button class="btn btn-lg btn-primary btn-block" type="submit" name="btnRegistrarUsuario">Registrar</button>
            </form>
        </div>
    </body>
</html>
