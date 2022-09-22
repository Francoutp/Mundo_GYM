<%-- 
    Document   : pagLogin
    Created on : 18 set. 2022, 21:36:22
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
        <title>.:: Login ::.</title>
    </head>
    <body>
        <div class="wrapper">
            <form class="form-signin" action="ControlAcceso" method="post">
                <center>
                    <span>
                        <img src="imagenes/logomundogym2.jpg" height="200">
                    </span>
                </center>
                <h2 align="center">Acceso al Sistema</h2>
                <input type="text" class="form-control" name="nombreUsuario" placeholder="Nombre de Usuario" required="" autofocus=""/>
                <input type="password" class="form-control" name="clave" placeholder="Contraseña" required=""/>
                <button type="submit" class="btn btn-warning btn-lg btn-block" name="btnAcceder">Ingresar</button>
            </form>
        </div>
    </body>
</html>
