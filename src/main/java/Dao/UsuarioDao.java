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

    //Busqueda usuario por nombreusuario
    public Usuario BuscarUsuario(Usuario objeto) {
        Usuario usuario = new Usuario();
        ResultSet rs;
        try {
            this.getConexion();
            String sql = "select * from mg_usuario where nombre_usuario=?";
            PreparedStatement st = this.getConexion().prepareStatement(sql);
            st.setString(1, objeto.getNombreUsuario());
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

    //Correlativo usuario
    public int CorrelativoUsuario() {
        int id=0;
        try {
            Connection cn=MySQLConexion.getConexion();
            String cad="SELECT CASE WHEN COUNT(*) = 0 THEN 1 ELSE MAX(ID_USUARIO)+1"
                    + " END AS ID_CORRELATIVO_USUARIO FROM MG_USUARIO";
            PreparedStatement st=cn.prepareStatement(cad);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID_CORRELATIVO_USUARIO");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return id;
    }

    //Actualizar contraseña
    public void actualizar(Usuario usu) {
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "update mg_usuario set clave_usuario=?, perfil_usuario=? where id_usuario=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1,usu.getClaveusuario());
            st.setInt(2, usu.getPerfilUsuario());
            st.setInt(3, usu.getIdUsuario());
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                if (cn!=null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    //Agregar usuario
    public void AgregarUsuario(Usuario usu){
        Connection cn=MySQLConexion.getConexion();
        try {
            String cad="insert into mg_usuario values (null,?,?,?)";
            PreparedStatement st=cn.prepareStatement(cad);
            st.setString(1, usu.getNombreUsuario());
            st.setString(2, usu.getClaveusuario());
            st.setInt(3, usu.getPerfilUsuario());
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if (cn!=null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    //Busqueda usuario por id
    public Usuario BuscarUsuarioporID(int objeto) {
        Usuario usu = new Usuario();
        ResultSet rs;
        try {
            this.getConexion();
            String sql = "select * from mg_usuario where id_usuario=?";
            PreparedStatement st = this.getConexion().prepareStatement(sql);
            st.setInt(1, objeto);
            rs = st.executeQuery();
            while (rs.next()) {
                usu.setIdUsuario(rs.getInt(1));
                usu.setNombreUsuario(rs.getString(2));
                usu.setClaveusuario(rs.getString(3));
                usu.setPerfilUsuario(rs.getInt(4));
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
        return usu;
    }
    
    //Actualizar nivel de acceso
    public void ActualizaNivelAcceso(Usuario usu) {
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "update mg_usuario set perfil_usuario=? where id_usuario=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, usu.getPerfilUsuario());
            st.setInt(2, usu.getIdUsuario());
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            try {
                if (cn!=null) {
                    cn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
