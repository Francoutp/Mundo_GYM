<%-- 
    Document   : pagRegistrarCliente
    Created on : 2 oct. 2022, 18:32:21
    Author     : ricardo
--%>

<%@page import="Modelos.Dieta"%>
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
                <%
                    Dieta d=(Dieta)request.getAttribute("entrega");
                %>
                <h3 class="p-3 bg-warning text-white" align="center">Editar Dieta</h3>
                <h6 align="right"><i>(*) Campos obligatorios</i></h6>
                <input type="hidden" name="accion" value="ModificarDieta">
                <input type="hidden" name="iddieta" value="<%=d.getIdDieta()%>">
                <div>
                    
                    <label for="nombre">Nombre de la Dieta (*)</label>
                    <input type="text" class="form-control mb-3" name="nombreDieta" value="<%=d.getNombreDieta()%>"/>
                </div>
                <div>
                    <label for="apellidos">Tipo de Dieta (*)</label>
                    <select class="form-control mb-3" id="tipoDieta" name="tipoDieta">
                        <%
                            Connection cn=MySQLConexion.getConexion();
                            try {
                                String cad="select * from mg_tipo_dieta";
                                PreparedStatement st=cn.prepareStatement(cad);
                                ResultSet rs=st.executeQuery();
                                while(rs.next()){
                                    if (d.getIdTipoDieta()==rs.getInt(1)) {
                                        out.print("<option selected value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</option>");
                                    } else {
                                        out.print("<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</option>");
                                    }
                                }
                            } catch (Exception ex) {
                                out.print(ex.toString());
                            } 
                        %>
                    </select>
                </div>
                <div>
                    <label for="apellidos">Horario de la Dieta (*)</label>
                    <select class="form-control mb-3" id="horaDieta "name="horaDieta">
                        <%
                            try {
                                String cad="select * from mg_dieta_diaria";
                                PreparedStatement st=cn.prepareStatement(cad);
                                ResultSet rs=st.executeQuery();
                                while(rs.next()){
                                    if (d.getIdHorarioDieta()==rs.getInt(1)) {
                                        out.print("<option selected value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</option>");
                                    } else {
                                        out.print("<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</option>");
                                    }
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
                <button type="submit" class="btn btn-primary btn-lg" name="btnGrabar">Grabar Cambios</button>
                <button type="button" class="btn btn-primary btn-lg " name="btnRegresar" onclick="history.go(-1)">Cancelar</button>
                </div>
            </form>
        </div>
    </body>
</html>
