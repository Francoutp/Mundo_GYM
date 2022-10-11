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
            String nomdieta=request.getParameter("nombreDieta");
            int idtipo=Integer.parseInt(request.getParameter("tipoDieta"));
            int idhorario=Integer.parseInt(request.getParameter("horaDieta"));
            out.print("Datos de recibidos "+nomdieta+", "+idtipo+" ,"+idhorario);
        %>
    </body>
</html>
