<%-- 
    Document   : pagInicio
    Created on : 18 set. 2022, 21:17:41
    Author     : ricardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%-- Menu --%>
        <link href="font/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet prefetch" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <%-- Formulario --%>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta charset="UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/styles_frm.css" rel="stylesheet" type="text/css"/>

        <title>.:: Inicio ::.</title>
    </head>
    <body>
        <div class="container">
            <ul id="nav">
                <li><a href="pagInicio.jsp"><i class="fa fa-home" aria-hidden="true"></i> Inicio</a></li>
                <li><a href="#"><i class="fa fa-heartbeat" aria-hidden="true"></i> Dieta</a>
                    <span id="sl"></span>
                    <ul class="subs">
                        <ul>
                            <li><a href="Controlador?id=Dieta"><i class="fa fa-folder-open" aria-hidden="true"></i>  Dieta</a></li>
                            <li><a href="Controlador?id=Ingredientes"><i class="fa fa-folder-open" aria-hidden="true"></i>  Ingredientes</a></li>
                            <li><a href="Controlador?id=Preparacion"><i class="fa fa-folder-open" aria-hidden="true"></i>  Preparación</a></li>
                        </ul>
                    </ul>
                </li>
                <li><a href="#"><i class="fa fa-child" aria-hidden="true"></i> Ejercicios</a>
                    <span id="s1"></span>
                    <ul class="subs">
                        <ul>
                            <li><a href="Controlador?id=Ejercicios"><i class="fa fa-folder-open" aria-hidden="true"></i>  Ejercicios</a></li>
                        </ul>
                    </ul>
                </li>
                <li><a href="#"><i class="fa fa-users" aria-hidden="true"></i> Cliente</a>
                    <ul class="subs">
                        <ul>
                            <li><a href="ControlCliente?accion=listar"><i class="fa fa-folder-open" aria-hidden="true"></i>  Cliente</a></li>
                        </ul>
                        <ul>
                            <li><a href="Controlador?id=Asignacion"><i class="fa fa-folder-open" aria-hidden="true"></i>  Asignación</a></li>
                        </ul>
                        <ul>
                            <li><a href="Controlador?id=ListaCliente"><i class="fa fa-folder-open" aria-hidden="true"></i>  Listado</a></li>
                        </ul>
                    </ul>
                </li>
                <li><a href="pagLogin.jsp"><i class="fa fa-arrow-right" aria-hidden="true"></i> Salir</a></li>
            </ul>
        </div>
    </body>
    <br>
    <div class="container bg-success">
    <h4 class="btn btn-warning btn-block" align="center"><b>UN POCO DE NUESTRO TRABAJO...</b></h4>
    <h5 class="text-success" align="center">Este es tu Aplicativo Web de consejería saludable... </h5>
    <h5 class="text-success" align="center">Creado con la finalidad de brindar orientación y asesoría a los usuarios sobre estilos de vida saludables. Buscando mejorar</h5>
    <h5 class="text-success" align="center">la salud de las personas de todas las edades mediante rutinas de ejercicio y dietas balanceadas adaptadas a tus</h5>
    <h5 class="text-success" align="center">características físicas como peso, talla y edad.</h5>
    <br>
    <h5 class="text-success" align="center">El objetivo de Mundo Gym busca que el usuario pueda llevar un mejor control de su salud y pueda ser orientado sobre qué</h5>
    <h5 class="text-success" align="center">medidas de actividad física y alimentación saludable debe tomar en función a su cuerpo, a fin de obtener una buena salud.</h5>
    <br>
    <h5 class="text-success" align="center">Mundo Gym aplica para fines académicos y que esten dentro de los lineamientos del curso</h5>
    <h5 class="text-success" align="center">de Desarrollo Web Integrado de la Universidad Tecnológica del Perú. Así mismo se busca implementar el uso de las herramientas</h5>
    <h5 class="text-success" align="center">informáticas propias del curso, a fin de poder desarrollar el código fuente que permitirá automatizar las acciones propias de</h5>
    <h5 class="text-success" align="center">los usuarios, en un entorno a nivel usuario final.</h5>
    </div>
</html>
