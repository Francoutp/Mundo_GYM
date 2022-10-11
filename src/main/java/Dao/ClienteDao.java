package Dao;

import Conexion.MySQLConexion;
import Modelos.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    
    //Buscar Cliente por Id de usuario
    public Cliente ClientePorIdUsuario(int dato){
        Cliente cli=null;
        try {
            Connection cn=MySQLConexion.getConexion();
            String cad="select * from mg_cliente where id_usuario=?";
            PreparedStatement st=cn.prepareStatement(cad);
            st.setInt(1, dato);
            ResultSet rs=st.executeQuery();
            if (rs.next()) {
                cli=new Cliente();
                cli.setIdCliente(rs.getInt(1));
                cli.setNombreCliente(rs.getString(2));
                cli.setApellidoCliente(rs.getString(3));
                cli.setDni(rs.getString(4));
                cli.setDireccion(rs.getString(5));
                cli.setTalla(rs.getDouble(6));
                cli.setPesoInicial(rs.getDouble(7));
                cli.setPesoActual(rs.getDouble(8));
                cli.setImc();
                cli.setIdUsuario(rs.getInt(10));
                cli.setCelular(rs.getString(11));
                cli.setObservacion();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return cli;
    }

    //Correlativo cliente
    public int CorrelativoCliente() {
        int id=0;
        try {
            Connection cn=MySQLConexion.getConexion();
            String cad="select case when count(*) = 0 then 1 else max(id_cliente)+1"
                    + " end as ID_CORRELATIVO_CLIENTE from mg_cliente";
            PreparedStatement st=cn.prepareStatement(cad);
            ResultSet rs=st.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID_CORRELATIVO_CLIENTE");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return id;
    }
    
    //Agregar Cliente
    public void AgregarCliente(Cliente cli){
        Connection cn=MySQLConexion.getConexion();
        try {
            String cad="insert into mg_cliente values (null,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st=cn.prepareStatement(cad);
            st.setString(1, cli.getNombreCliente());
            st.setString(2, cli.getApellidoCliente());
            st.setString(3, cli.getDni());
            st.setString(4, cli.getDireccion());
            st.setDouble(5, cli.getTalla());
            st.setDouble(6, cli.getPesoInicial());
            st.setDouble(7, cli.getPesoActual());
            st.setDouble(8, cli.getImc());
            st.setInt(9, cli.getIdUsuario());
            st.setString(10, cli.getCelular());
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
    
    public List<Cliente> ListaTotalClientes(){
        Connection cn=MySQLConexion.getConexion();
        List<Cliente> lista=new ArrayList();
        String cad="select * from mg_cliente";
        try {
            PreparedStatement st=cn.prepareStatement(cad);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Cliente cli=new Cliente();
                cli.setIdCliente(rs.getInt(1));
                cli.setNombreCliente(rs.getString(2));
                cli.setApellidoCliente(rs.getString(3));
                cli.setDni(rs.getString(4));
                cli.setDireccion(rs.getString(5));
                cli.setTalla(rs.getDouble(6));
                cli.setPesoInicial(rs.getDouble(7));
                cli.setPesoActual(rs.getDouble(8));
                cli.setImc();
                cli.setIdUsuario(rs.getInt(10));
                cli.setCelular(rs.getString(11));
                cli.setObservacion();
                lista.add(cli);
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
    
    //Buscar Cliente por Id 
    public Cliente ClientePorId(int dato){
        Cliente cli=null;
        try {
            Connection cn=MySQLConexion.getConexion();
            String cad="select * from mg_cliente where id_cliente=?";
            PreparedStatement st=cn.prepareStatement(cad);
            st.setInt(1, dato);
            ResultSet rs=st.executeQuery();
            if (rs.next()) {
                cli=new Cliente();
                cli.setIdCliente(rs.getInt(1));
                cli.setNombreCliente(rs.getString(2));
                cli.setApellidoCliente(rs.getString(3));
                cli.setDni(rs.getString(4));
                cli.setDireccion(rs.getString(5));
                cli.setTalla(rs.getDouble(6));
                cli.setPesoInicial(rs.getDouble(7));
                cli.setPesoActual(rs.getDouble(8));
                cli.setImc();
                cli.setIdUsuario(rs.getInt(10));
                cli.setCelular(rs.getString(11));
                cli.setObservacion();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return cli;
    }
    
    //actualizar cliente
    public void ModificarCliente (Cliente cli){
        Connection cn=MySQLConexion.getConexion();
        try {
            String cad="update mg_cliente set nombre_cliente=?, apellidos_cliente=?, dni=?, "
                    + "direccion=?, talla=?, peso_inicial=?, peso_actual=?, imc=?, celular=? "
                    + "where id_cliente=?";
            PreparedStatement st=cn.prepareStatement(cad);
            st.setString(1, cli.getNombreCliente());
            st.setString(2, cli.getApellidoCliente());
            st.setString(3, cli.getDni());
            st.setString(4, cli.getDireccion());
            st.setDouble(5, cli.getTalla());
            st.setDouble(6, cli.getPesoInicial());
            st.setDouble(7, cli.getPesoActual());
            st.setDouble(8, cli.getImc());
            st.setString(9, cli.getCelular());
            st.setInt(10, cli.getIdCliente());
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
    
    //eliminar cliente
    public void EliminarCliente (int idcli, int idusu){
        Connection cn=MySQLConexion.getConexion();
        try {
            String cad1="delete from mg_cliente where id_cliente=?";
            PreparedStatement st1=cn.prepareStatement(cad1);
            st1.setInt(1, idcli);
            st1.executeUpdate();
            String cad2="delete from mg_usuario where id_usuario=?";
            PreparedStatement st2=cn.prepareStatement(cad2);
            st2.setInt(1, idusu);
            st2.executeUpdate();
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
