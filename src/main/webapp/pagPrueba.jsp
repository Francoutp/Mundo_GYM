<%-- 
    Document   : PagPrueba
    Created on : 24 set. 2022, 22:45:38
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page session="true" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession objetoSesion =request.getSession();
            String nom=(String)objetoSesion.getAttribute("nombreUsuarioLogin");
            String niv=(String)objetoSesion.getAttribute("nivel");
            int id=(Integer)objetoSesion.getAttribute("idUsuarioLogin");
            out.print("Datos de sesión: "+nom+", "+niv+" ,"+id);
        %>
    </body>
</html>
