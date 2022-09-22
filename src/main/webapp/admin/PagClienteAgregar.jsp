<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@page import="java.util.List"%>
<!DOCTYPE html>

<html>
    <head>
        <%@include file="../includes/Recursos.jsp" %>
        <title>.::Cliente::.</title>
    </head>
    <body>
        <div class="container">
            <%@include file="../includes/Navegacion.jsp" %>
        </div>

        <div class="container" id="advanced-search-form">
            <center><h2>Registro de Clientes</h2></center> 
            <form action="ControlCliente" method="post">
                <div class="row">
                    <label for="first-name">Nombres</label>
                    <input type="text" class="form-control" placeholder="" name="nombreCliente" id="nombreCliente" required="" autofocus="">
                </div>
                <div class="row">
                    <label for="last-name">Apellidos</label>
                    <input type="text" class="form-control" placeholder="" name="apellidoCliente" id="apellidoCliente" required="">
                </div>
                <div class="row">
                    <label for="country">Documento de Identidad</label>
                    <input type="text" class="form-control" placeholder="" name="DNI" id="DNI" required="" maxlength="8">
                </div>
                <div class="row">
                    <label for="number">Dirección</label>
                    <input type="text" class="form-control" placeholder="" name="Direccion" id="Direccion" required="">
                </div>
                <div class="row">
                    <label for="age">Peso Kg</label>
                    <input type="text" class="form-control" placeholder="Ejemplo 68" name="Peso" id="Peso" required="">
                </div>
                <div class="row">
                    <label for="email">Talla</label>
                    <input type="text" class="form-control" placeholder="Ejemplo 1.70" name="Talla" id="Talla" required="">
                </div>
                <div class="row">
                    <label for="education">Nro. de Móvil</label>
                    <input type="text" class="form-control" placeholder="" name="Celular" id="apellidoCliente" required="" maxlength="9">
                </div>

                <div class="clearfix"></div>
                <div class="row">
                    <br>
                    <input type="hidden" name="accion" value="guardar_datos">
                    <button class="btn btn-lg btn-primary btn-block" type="submit" name="btnRegistrarCliente">Registrar</button>
                   
                </div>
            </form>
        </div>
    </body>
</html>