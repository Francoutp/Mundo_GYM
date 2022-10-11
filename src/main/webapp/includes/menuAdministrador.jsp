

<%@page import="Modelos.Cliente"%>
<%@page import="Modelos.Usuario"%>
<%@page import="java.util.*" session="true"%>
<%--
    HttpSession objetoSesion = request.getSession();
    Usuario usu = (Usuario) objetoSesion.getAttribute("usuario");
    Cliente cli = (Cliente) objetoSesion.getAttribute("cliente");
    //out.println("Datos de usuario logueado: "+usu.toString());
    //out.print("Datos de cliente logueado: "+cli.toString());
--%>
<ul id="nav">
    <li><a href="pagInicio.jsp"><i class="fa fa-home" aria-hidden="true"></i> Inicio</a></li>
    <li><a href="#"><i class="fa fa-heartbeat" aria-hidden="true"></i> Dieta</a>
        <span id="sl"></span>
        <ul class="subs">
            <ul>
                <li><a href="pagListaDietas.jsp"><i class="fa fa-heartbeat" aria-hidden="true"></i>  Dieta</a></li>
                <li><a href="Controlador?id=Ingredientes"><i class="fa fa-apple" aria-hidden="true"></i>  Ingredientes</a></li>
                <li><a href="Controlador?id=Preparacion"><i class="fa fa-cutlery" aria-hidden="true"></i>  Preparación</a></li>
            </ul>
        </ul>
    </li>
    <li><a href="#"><i class="fa fa-child" aria-hidden="true"></i> Ejercicios</a>
        <span id="s1"></span>
        <ul class="subs">
            <ul>
                <li><a href="Controlador?id=Ejercicios"><i class="fa fa-bicycle" aria-hidden="true"></i>  Ejercicios</a></li>
            </ul>
        </ul>
    </li>
    <li><a href="#"><i class="fa fa-users" aria-hidden="true"></i> Cliente</a>
        <ul class="subs">
            <ul>
                <li><a href="pagRegistrarCliente.jsp"><i class="fa fa-user" aria-hidden="true"></i>  Registrar Cliente</a></li>
            </ul>
            <ul>
                <li><a href="#"><i class="fa fa-address-book" aria-hidden="true"></i>  Asignación de Actividades</a></li>
            </ul>
            <ul>
                <li><a href="ControlCliente?accion=ListarClientes"><i class="fa fa-bars" aria-hidden="true"></i>  Lista de Clientes</a></li>
            </ul>
        </ul>
    </li>
    <li><a href="#"><i class="fa fa-address-card" aria-hidden="true"></i> <%=cli.getNombreCliente()+" "+cli.getApellidoCliente()%></a>
        <span id="s1"></span>
        <ul class="subs">
            <ul>
                <li><a href="pagCambioClave.jsp"><i class="fa fa-lock" aria-hidden="true"></i>  Actualizar Contraseña</a></li>
                <li><a href="pagLogin.jsp" onclick="return confirm('¿Esta seguro que desea salir?')"><i class="fa fa-arrow-right" aria-hidden="true"></i>  Salir</a></li>
            </ul>
        </ul>
    </li>
</ul>