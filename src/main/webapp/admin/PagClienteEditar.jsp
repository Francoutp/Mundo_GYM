<%@page import="Modelos.Cliente"%>
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
        
        <%
        Cliente obj = (Cliente) request.getAttribute("cliente");
        %>

        <div class="container" id="advanced-search-form">
            <center><h2>Edición de Clientes</h2></center> 
            <form action="ControlCliente" method="post">
                <div class="row">
                    <label for="first-name">Nombres</label>
                    <input value="<%=obj.getNombreCliente() %>" type="text" class="form-control" placeholder="" name="nombreCliente" id="nombreCliente" required="" autofocus="">
                </div>
                <div class="row">
                    <label for="last-name">Apellidos</label>
                    <input value="<%=obj.getApellidoCliente()%>"  type="text" class="form-control" placeholder="" name="apellidoCliente" id="apellidoCliente" required="">
                </div>
                <div class="row">
                    <label for="country">Documento de Identidad</label>
                    <input value="<%=obj.getDNI()%>"  type="text" class="form-control" placeholder="" name="DNI" id="DNI" required="" maxlength="8">
                </div>
                <div class="row">
                    <label for="number">Dirección</label>
                    <input value="<%=obj.getDireccion()%>"  type="text" class="form-control" placeholder="" name="Direccion" id="Direccion" required="">
                </div>
                <div class="row">
                    <label for="age">Peso Kg</label>
                    <input value="<%=obj.getPeso_inicial()%>"  type="text" class="form-control" placeholder="Ejemplo 68" name="Peso" id="Peso" required="">
                </div>
                <div class="row">
                    <label for="email">Talla</label>
                    <input value="<%=obj.getTalla()%>"  type="text" class="form-control" placeholder="Ejemplo 1.70" name="Talla" id="Talla" required="">
                </div>
                <div class="row">
                    <label for="education">Nro. de Móvil</label>
                    <input value="<%=obj.getCelular()%>"  type="text" class="form-control" placeholder="" name="Celular" id="apellidoCliente" required="" maxlength="9">
                </div>

                <div class="clearfix"></div>
                <div class="row">
                    <br>
                     <input type="hidden" name="id" value="<%=obj.getIdCliente() %>">
                    <input type="hidden" name="accion" value="guardar_edicion">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Editar</button>
                   
                </div>
            </form>
        </div>
    </body>
</html>