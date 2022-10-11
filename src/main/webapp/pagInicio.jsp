<%-- 
    Document   : pagInicio
    Created on : 18 set. 2022, 21:17:41
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/Recursos.jsp" %>
        <title>.:: Inicio ::.</title>
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
        <br>
        <div class="container border border-warning" id="advanced-search-form">
            <center>
                <span>
                    <img src="imagenes/logomundogym2.jpg" height="100">
                </span>
            </center>
            <h4 class="p-3 bg-warning text-white" align="center"><b>UN POCO DE NUESTRO TRABAJO...</b></h4>
            <h5 class="text-dark" align="center">Este es tu Aplicativo Web de consejería saludable... </h5>
            <h5 class="text-dark" align="center">Creado con la finalidad de brindar orientación y 
                asesoría a los usuarios sobre estilos de vida saludables. Buscando mejorar la salud de 
                las personas de todas las edades mediante rutinas de ejercicio y dietas balanceadas 
                adaptadas a tus características físicas como peso, talla y edad.</h5>
            <br>
            <h5 class="text-dark" align="center">El objetivo de Mundo Gym busca que el usuario pueda 
                llevar un mejor control de su salud y pueda ser orientado sobre quémedidas de actividad 
                física y alimentación saludable debe tomar en función a su cuerpo, a fin de obtener una 
                buena salud.</h5>
            <br>
            <h5 class="text-dark" align="center">Mundo Gym aplica para fines académicos y que esten 
                dentro de los lineamientos del curso de Desarrollo Web Integrado de la Universidad 
                Tecnológica del Perú. Así mismo se busca implementar el uso de las herramientas 
                informáticas propias del curso, a fin de poder desarrollar el código fuente que 
                permitirá automatizar las acciones propias de los usuarios, en un entorno a nivel 
                usuario final.</h5>
        </div>
    </body>
</html>
