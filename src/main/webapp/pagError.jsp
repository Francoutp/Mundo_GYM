<%-- 
    Document   : pagError
    Created on : 18 set. 2022, 21:06:24
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet prefetch" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>.:: Error ::.</title>
    </head>
    <body>
        <div class="wrapper">
            <form class="form-signin" action="ControlAcceso" method="post">
                <br><!-- espacio -->
                <br><!-- espacio adicional -->
                <center>
                    <h2 style="color: #0275d8">
                        <span style="color:red" class="fa fa-user-times" ></span>
                        <br><!-- uno mas por siacaso -->
                        El Usuario y/o Clave son incorrectos...
                    </h2>
                    <a href="pagLogin.jsp" class="btn btn-danger btn-sm btn-block">
                        Regresar
                    </a>
                </center>
            </form>
        </div>
    </body>
</html>
