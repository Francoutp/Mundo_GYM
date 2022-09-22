package Dao;

/**
 * Fecha:18/09/2022 Versión: 1.0
 *
 * @author ricardo
 */
import Conexion.MySQLConexion;
import java.sql.*;
import java.util.*;
import Modelos.*;

public class UsuarioDao extends MySQLConexion {

    //LOGEO
    public Usuario Login(Usuario usu) {
        Usuario usuario = new Usuario();
        ResultSet rs;
        try {
            this.getConexion();
            String sql = "SELECT ID_USUARIO,NOMBRE_USUARIO, CLAVE_USUARIO, "
                    + "PERFIL_USUARIO FROM MG_USUARIO WHERE NOMBRE_USUARIO=? "
                    + "AND CLAVE_USUARIO=?";
            PreparedStatement st = this.getConexion().prepareStatement(sql);
            st.setString(1, usu.getNombreUsuario());
            st.setString(2, usu.getClaveusuario());
            rs = st.executeQuery();
            while (rs.next()) {
                usuario.setPerfilUsuario(rs.getInt("PERFIL_USUARIO"));
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
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

    public String RegistrarUsuario(Usuario usuario) {
        String msg = "";
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "INSERT INTO MG_USUARIO VALUES (?,?,?,?)";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, usuario.getIdUsuario());
            st.setString(2, usuario.getNombreUsuario());
            st.setString(3, usuario.getClaveusuario());
            st.setInt(4, usuario.getPerfilUsuario());

            if (st.executeUpdate() > 0) {
                msg = "OK";
            } else {
                msg = "No se pudieron guardar datos del usuario.";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = ex.getMessage();
        }
        return msg;
    }

    public String EditarUsuario(Cliente obj) {
        String msg = "";
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "update MG_USUARIO set nombre_usuario=? , clave_usuario=?"
                    + " where id_usuario=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, obj.getNombreUsuario());
            st.setString(2, obj.getClaveusuario());
            st.setInt(3, obj.getIdUsuario());

            if (st.executeUpdate() > 0) {
                msg = "OK";
            } else {
                msg = "No se pudieron editar datos del usuario.";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = ex.getMessage();
        }
        return msg;
    }

    public String EliminarUsuario(int id) {
        String msg = "";
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "delete from MG_USUARIO "
                    + " where id_usuario=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, id);

            if (st.executeUpdate() > 0) {
                msg = "OK";
            } else {
                msg = "No se pudieron eliminar datos del usuario.";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = ex.getMessage();
        }
        return msg;
    }
}
