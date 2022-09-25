package Dao;
/**
 * Fecha:18/09/2022 
 * Versión: 1.0
 * @author ricardo
 */
import Conexion.MySQLConexion;
import java.sql.*;
import java.util.*;
import Modelos.*;

public class UsuarioDao extends MySQLConexion {

    //LOGEO
    public Usuario Logueo(Usuario objeto) {
        Usuario usuario = new Usuario();
        ResultSet rs;
        try {
            this.getConexion();
            String sql = "SELECT ID_USUARIO,NOMBRE_USUARIO, CLAVE_USUARIO, "
                    + "PERFIL_USUARIO FROM MG_USUARIO WHERE NOMBRE_USUARIO=? "
                    + "AND CLAVE_USUARIO=?";
            PreparedStatement st = this.getConexion().prepareStatement(sql);
            st.setString(1, objeto.getNombreUsuario());
            st.setString(2, objeto.getClaveusuario());
            rs = st.executeQuery();
            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombreUsuario(rs.getString(2));
                usuario.setClaveusuario(rs.getString(3));
                usuario.setPerfilUsuario(rs.getInt(4));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (this.getConexion() != null) {
                    this.getConexion().close();
                }
            } catch (Exception e2) {
            }
        }
        return usuario;
    }

    //CORRELATIVO
    public String CorrelativoUsuario() {
        String id = "";
        ResultSet rs;
        Connection cnx = MySQLConexion.getConexion();
        try {

            String sql = "SELECT CASE WHEN COUNT(*) = 0 THEN 1 ELSE MAX(ID_USUARIO)+1"
                    + " END AS ID_CORRELATIVO_USUARIO FROM MG_USUARIO";
            PreparedStatement st = cnx.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getObject("ID_CORRELATIVO_USUARIO").toString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public void actualizar(Usuario usu) {
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "UPDATE MG_USUARIO SET CLAVE_USUARIO=? WHERE ID_USUARIO=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1,usu.getClaveusuario());
            st.setInt(2, usu.getIdUsuario());
            st.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
