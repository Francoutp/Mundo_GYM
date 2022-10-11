
package Dao;

import Conexion.MySQLConexion;
import Modelos.Cliente;
import Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class PruebaDAO {

    
    public static void main(String[] args) {
        
//        Usuario u=new Usuario();
//        u.setIdUsuario(1);
//        u.setNombreUsuario("ferdecor");
//        u.setClaveusuario("12345678");
//        u.setPerfilUsuario(2);
//        System.out.println(u.toString());
        
//        Connection cn=MySQLConexion.getConexion();
        UsuarioDao objeto = new UsuarioDao();
        int id_usuario=objeto.CorrelativoUsuario();
        System.out.println("El id del usuario es: "+id_usuario);
        
//        ClienteDao objeto = new ClienteDao();
//        int id_cliente=objeto.CorrelativoCliente();
//        System.out.println("El id del cliente es: "+id_cliente);
            
//            String cad = "update mg_usuario set clave_usuario=? where id_usuario=?";
//            PreparedStatement st = cn.prepareStatement(cad);
//            st.setString(1,u.getClaveusuario());
//            st.setInt(2, u.getIdUsuario());
//            st.executeUpdate();
       
        
        
    }
    
}
