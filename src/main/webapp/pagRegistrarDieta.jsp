<%-- 
    Document   : pagRegistrarCliente
    Created on : 2 oct. 2022, 18:32:21
    Author     : ricardo
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="Conexion.MySQLConexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/Recursos.jsp" %>
        <title>.:: Registrar Dieta ::.</title>
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
            <form class="form-signin-heading" action="ControlDieta" method="post">
                <h3 class="p-3 bg-warning text-white" align="center">Registrar Nueva Dieta</h3>
                <h6 align="right"><i>(*) Campos obligatorios</i></h6>
                <input type="hidden" name="accion" value="RegistrarDietaNueva">
                <div>
                    <label for="nombre">Nombre de la Dieta (*)</label>
                    <input type="text" class="form-control" name="nombreDieta" placeholder="" required="" autofocus=""/>
                </div>
                <div>
                    <label for="apellidos">Tipo de Dieta (*)</label>
                    <select class="form-control" name="tipoDieta">
                        <%
                            Connection cn=MySQLConexion.getConexion();
                            try {
                                String cad="select * from mg_tipo_dieta";
                                PreparedStatement st=cn.prepareStatement(cad);
                                ResultSet rs=st.executeQuery();
                                while(rs.next()){
                                    out.print("<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</option>");
                                }
                            } catch (Exception ex) {
                                out.print(ex.toString());
                            }
                        %>
                    </select>
                </div>
                <div>
                    <label for="apellidos">Horario de la Dieta (*)</label>
                    <select class="form-control" name="horaDieta">
                        <%
                            try {
                                String cad="select * from mg_dieta_diaria";
                                PreparedStatement st=cn.prepareStatement(cad);
                                ResultSet rs=st.executeQuery();
                                while(rs.next()){
                                    out.print("<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</option>");
                                }
                            } catch (Exception ex) {
                                out.print(ex.toString());
                            } finally{
                                try {
                                    if (cn!=null) {
                                        cn.close();
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        %>
                    </select>
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
