<%-- 
    Document   : pagError
    Created on : 18 set. 2022, 21:06:24
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/Recursos.jsp" %>
        <title>.:: Error ::.</title>
    </head>
    <body>
        <div class="container">
        </div>
        <div class="wrapper">
            <form class="form-signin" action="pagRegUsuOut.jsp">
                <br><!-- espacio -->
                <br><!-- espacio adicional -->
                <center>
                    <h4 style="color: #0275d8">
                        <span style="color:red" class="fa fa-user-times" ></span>
                        <br><!-- uno mas por siacaso -->
                        <%
                            out.print(request.getSession().getAttribute("mensaje"));
                        %>
                    </h4>
                    <button type="button" class="btn btn-warning btn-lg btn-block" name="btnRegresar" onclick="history.go(-1)">Regresar</button>
                    <button type="submit" class="btn btn-warning btn-lg btn-block" name="btnRegistrar">Registrarse</button>
                </center>
            </form>
        </div>
    </body>
</html>
