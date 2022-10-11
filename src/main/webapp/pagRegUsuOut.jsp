<%-- 
    Document   : pagRegUsuOut
    Created on : 1 oct. 2022, 22:36:56
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
        <title>.:: Registrar Cliente ::.</title>
    </head>
    <body>
        <div class="wrapper">
            <form class="form-signin" action="ControlCliente" method="post">
                <center>
                    <span>
                        <img src="imagenes/logomundogym2.jpg" height="200">
                    </span>
                </center>
                <h3 class="btn btn-primary btn-lg btn-block" align="center">Registrar Nuevo Usuario</h3>
                <h6 align="right"><i>(*) Campos obligatorios</i></h6>
                <input type="hidden" name="accion" value="RegistrarUsuarioNuevoOut">
                <div>
                    <center><label for="subtit1">-- Datos del Cliente --</label></center>
                    <label for="nombre">Nombres (*)</label>
                    <input type="text" class="form-control" name="nombreCliente" placeholder="" required="" autofocus=""/>
                </div>
                <div>
                    <label for="apellidos">Apellidos (*)</label>
                    <input type="text" class="form-control" name="apellidoCliente" placeholder="" required=""/>
                </div>
                <div>
                    <label for="dni">DNI  (*)</label>
                    <input type="text" class="form-control" name="dniCliente" placeholder="" required=""/>
                </div>
                <div>
                    <label for="direccion">Dirección</label>
                    <input type="text" class="form-control" name="direccionCliente" placeholder=""/>
                </div>
                <div>
                    <label for="talla">Talla  (*)</label>
                    <input type="text" class="form-control" name="tallaCliente" placeholder="Ejemplo: 1.70" required=""/>
                </div>
                <div>
                    <label for="peso">Peso Kg  (*)</label>
                    <input type="text" class="form-control" name="pesoCliente" placeholder="Ejemplo: 65" required=""/>
                </div>
                <div>
                    <label for="celular">Nro de Celular</label>
                    <input type="text" class="form-control" name="celularCliente" placeholder=""/>
                </div>
                <br>
                <div>
                    <center><label for="subtit2">-- Datos del Inicio de Sesión --</label></center>
                    <label for="usuario">Usuario (*)</label>
                    <input type="text" class="form-control" name="nombreUsuario" placeholder="" required=""/>
                </div>
                <div>
                    <label for="clave1">Contraseña (*)</label>
                    <input type="password" class="form-control" name="clave" placeholder="" required=""/>
                </div>
                <div>
                    <label for="clave2">Confirmar Contraseña (*)</label>
                    <input type="password" class="form-control" name="claveConf" placeholder="" required=""/>
                </div>
                <button type="submit" class="btn btn-warning btn-lg btn-block" name="btnAcceder">Registrar</button>
                <button type="reset" class="btn btn-warning btn-lg btn-block" name="btnReset" onclick="">Limpiar</button>
                <a href="pagLogin.jsp" class="btn btn-warning btn-lg btn-block">Cancelar</a>
            </form>
        </div>
    </body>
</html>
