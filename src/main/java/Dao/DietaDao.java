
package Dao;

import Conexion.MySQLConexion;
import Modelos.Cliente;
import Modelos.Dieta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DietaDao {
    
    //buscar tipo de dieta por id
    public String BuscarTipoDietaPorID(int dato){
        String tipo=""; //declaramos la variable
        try {
            Connection cn=MySQLConexion.getConexion();
            String cad="select nombre_tipo_dieta from mg_tipo_dieta where id_tipo_dieta=?";
            PreparedStatement st=cn.prepareStatement(cad);
            st.setInt(1, dato); //almacenamos el resultado de la consulta
            ResultSet rs=st.executeQuery();
            if (rs.next()) {
                tipo=rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return tipo;
    }
    
    //buscar tipo de horario por id
    public String BuscarHorarioPorID(int dato){
        String tipo=""; //declaramos la variable
        try {
            Connection cn=MySQLConexion.getConexion();
            String cad="select descripcion_gym_dieta_diaria from mg_dieta_diaria where id_gym_dieta_diaria=?";
            PreparedStatement st=cn.prepareStatement(cad);
            st.setInt(1, dato); //almacenamos el resultado de la consulta
            ResultSet rs=st.executeQuery();
            if (rs.next()) {
                tipo=rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return tipo;
    }
    
    public List<Dieta> ListaTotalDietas(){
        Connection cn=MySQLConexion.getConexion();
        List<Dieta> lista=new ArrayList();
        String cad="select * from mg_dieta";
        try {
            PreparedStatement st=cn.prepareStatement(cad);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Dieta die=new Dieta();
                die.setIdDieta(rs.getInt(1));
                die.setNombreDieta(rs.getString(2));
                die.setIdTipoDieta(rs.getInt(3));
                die.setIdHorarioDieta(rs.getInt(4));
                lista.add(die);
            }
        } catch (Exception ex) {
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
        return lista; 
    }
    
    //Agregar Dieta
    public void AgregarDieta(Dieta d){
        Connection cn=MySQLConexion.getConexion();
        try {
            String cad="insert into mg_dieta values (null,?,?,?)";
            PreparedStatement st=cn.prepareStatement(cad);
            st.setString(1, d.getNombreDieta());
            st.setInt(2, d.getIdTipoDieta());
            st.setInt(3, d.getIdHorarioDieta());
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
    
    //Buscar Cliente por Id 
    public Dieta DietaPorId(int dato){
        Dieta die=null;
        try {
            Connection cn=MySQLConexion.getConexion();
            String cad="select * from mg_dieta where id_dieta=?";
            PreparedStatement st=cn.prepareStatement(cad);
            st.setInt(1, dato);
            ResultSet rs=st.executeQuery();
            if (rs.next()) {
                die=new Dieta();
                die.setIdDieta(rs.getInt(1));
                die.setNombreDieta(rs.getString(2));
                die.setIdTipoDieta(rs.getInt(3));
                die.setIdHorarioDieta(rs.getInt(4));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return die;
    }
    
    //actualizar dieta
    public void ModificarDieta (Dieta die){
        Connection cn=MySQLConexion.getConexion();
        try {
            String cad="update mg_dieta set nombre_dieta=?, id_tipo_dieta=?, "
                    + "id_gym_dieta_diaria=? where id_dieta=?";
            PreparedStatement st=cn.prepareStatement(cad);
            st.setString(1, die.getNombreDieta());
            st.setInt(2, die.getIdTipoDieta());
            st.setInt(3, die.getIdHorarioDieta());
            st.setInt(4, die.getIdDieta());
            st.executeUpdate();
        } catch (Exception ex) {
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
