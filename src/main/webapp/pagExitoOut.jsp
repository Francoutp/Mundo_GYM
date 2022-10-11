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
        </div>
        <div class="wrapper">
            <form class="form-signin">
                <br><!-- espacio -->
                <br><!-- espacio adicional -->
                <center>
                    <h1 style="color: #0275d8">
                        <span style="color:green" class="fa fa-user-plus" ></span>
                    </h1>
                        <br><!-- uno mas por siacaso -->
                    <h4 style="color: #0275d8">
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
