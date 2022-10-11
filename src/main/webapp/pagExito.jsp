<%-- 
    Document   : pagError
    Created on : 18 set. 2022, 21:06:24
    Author     : ricardo
--%>

<%@page import="Modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/Recursos.jsp" %>
        <title>.:: Suceso ::.</title>
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
            <form class="form-signin">
                <br><!-- espacio -->
                <br><!-- espacio adicional -->
                <center>
                    <h4 style="color: #0275d8">
                        <span style="color:green" class="fa fa-user-plus" ></span>
                        <br><!-- uno mas por siacaso -->
                        <%
                            out.println(request.getSession().getAttribute("mensaje"));
                            //HttpSession objetoSesion =request.getSession();
                            //Usuario usu=(Usuario)objetoSesion.getAttribute("usuario");
                            //out.println("Datos de sesión: "+usu.toString());
                        %>
                    </h4>
                    <a href="<%=request.getSession().getAttribute("paginadestino")%>" class="btn btn-success btn-lg btn-block">
                        Regresar
                    </a>
                </center>
            </form>
        </div>
    </body>
</html>
