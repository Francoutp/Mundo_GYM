

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
    <li><a href="#"><i class="fa fa-user-circle" aria-hidden="true"></i> Cliente</a>
        <span id="sl"></span>
        <ul class="subs">
            <ul>
                <li><a href="#"><i class="fa fa-address-book" aria-hidden="true"></i>  Actualizar tus datos</a></li>
                <li><a href="#"><i class="fa fa-heartbeat" aria-hidden="true"></i>  Dieta Asignada</a></li>
                <li><a href="#"><i class="fa fa-child" aria-hidden="true"></i>  Rutina de Ejercicios</a></li>
            </ul>
        </ul>
    </li>
    <li><a href="https://us04web.zoom.us/j/75116216620?pwd=PAR9QDRU7yeJfpKdwSNbbZUCUAOS7r.1" target="_blank"><i class="fa fa-video-camera" aria-hidden="true"></i> Enlace en vivo</a>
        <span id="s1"></span>
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