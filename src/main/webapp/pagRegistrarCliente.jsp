<%-- 
    Document   : pagRegistrarCliente
    Created on : 2 oct. 2022, 18:32:21
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/Recursos.jsp" %>
        <title>.:: Registrar Cliente ::.</title>
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
        <div class="container" id="advanced-search-form">
            <form class="form-signin-heading" action="ControlCliente" method="post">
                <h3 class="p-3 bg-warning text-white" align="center">Registrar Nuevo Cliente</h3>
                <h6 align="right"><i>(*) Campos obligatorios</i></h6>
                <input type="hidden" name="accion" value="RegistrarUsuarioNuevo">
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
                <br>
                <div>
                    <label for="acceso">Nivel de Acceso (*)</label><br>
                    <input type="radio" name="accesoCliente" value="1" checked/>  Usuario Cliente<br>
                    <input type="radio" name="accesoCliente" value="2"/>  Usuario Administrador
                </div><br>
                <div>
                    <label for="clave1">Contraseña (*)</label>
                    <input type="password" class="form-control" name="clave" placeholder="" required=""/>
                </div>
                <div>
                    <label for="clave2">Confirmar Contraseña (*)</label>
                    <input type="password" class="form-control" name="claveConf" placeholder="" required=""/>
                </div>
                <div>
                <button type="submit" class="btn btn-primary btn-lg" name="btnAcceder">Registrar</button>
                <button type="reset" class="btn btn-primary btn-lg " name="btnReset" onclick="">Limpiar</button>
                <button type="button" class="btn btn-primary btn-lg " name="btnRegresar" onclick="history.go(-1)">Cancelar</button>
                </div>
            </form>
        </div>
    </body>
</html>
