package Dao;

import Conexion.MySQLConexion;
import Modelos.*;
import java.sql.*;
import java.util.ArrayList;

public class ClienteDao {

    public ArrayList<Cliente> ListarTodos() {
        ArrayList<Cliente> lista = new ArrayList<>();
        Connection cn = MySQLConexion.getConexion();
        ResultSet rs;
        try {
            String sql = "select * from mg_cliente";
            PreparedStatement st = cn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Cliente obj = new Cliente();
                obj.setIdCliente(rs.getInt("ID_CLIENTE"));
                obj.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
                obj.setApellidoCliente(rs.getString("APELLIDOS_CLIENTE"));
                obj.setDNI(rs.getString("DNI"));
                obj.setDireccion(rs.getString("DIRECCION"));
                obj.setTalla(rs.getDouble("TALLA"));
                obj.setPeso_inicial(rs.getDouble("PESO_INICIAL"));
                obj.setPeso_actual(rs.getDouble("PESO_ACTUAL"));
                obj.setIMC(rs.getDouble("IMC"));
                obj.setIdUsuario(rs.getInt("ID_USUARIO"));
                obj.setCelular(rs.getString("CELULAR"));
                obj.calObser();
                lista.add(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
            }
        }
        return lista;
    }

    public int Id_Correlativo_Cliente() {
        int Id = 0;
        ResultSet rs;
        Connection cn = MySQLConexion.getConexion();

        try {
            String sql = "SELECT CASE WHEN COUNT(*) = 0 THEN 1 "
                    + " ELSE MAX(ID_CLIENTE)+1 END AS ID_CORRELATIVO_CLIENTE FROM mg_cliente";
            PreparedStatement ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Id = rs.getInt("ID_CORRELATIVO_CLIENTE");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
            }
        }
        return Id;
    }

    public String RegistrarCliente(Cliente cliente) {
        String msg = "";
        Connection cn = MySQLConexion.getConexion();
        Statement st = null;

        try {
            String sql = "Insert Into mg_cliente (ID_CLIENTE,NOMBRE_CLIENTE,APELLIDOS_CLIENTE,DNI,DIRECCION,CELULAR,TALLA,PESO_INICIAL,PESO_ACTUAL,IMC,ID_USUARIO)"
                    + "Values(" + cliente.getIdCliente() + ""
                    + "," + "'" + cliente.getNombreCliente() + "'"
                    + "," + "'" + cliente.getApellidoCliente() + "'"
                    + "," + "'" + cliente.getDNI() + "'"
                    + "," + "'" + cliente.getDireccion() + "'"
                    + "," + "'" + cliente.getCelular() + "',"
                    + cliente.getTalla() + ", "
                    + cliente.getPeso_inicial() + ", "
                    + 0.00 + ", "
                    + cliente.getIMC() + ", "
                    + null + ")";
            st = cn.createStatement();
            if (st.executeUpdate(sql) > 0) {
                msg = "OK";
            } else {
                msg = "No se pudieron registrar datos del cliente";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = ex.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
            }
        }

        return msg;
    }

    public Cliente BuscarPorId(int id) {
        Cliente obj = null;
        Connection cn = MySQLConexion.getConexion();
        ResultSet rs;
        try {
            String sql = "select * from mg_cliente where ID_CLIENTE =?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                obj = new Cliente();
                obj.setIdCliente(rs.getInt("ID_CLIENTE"));
                obj.setNombreCliente(rs.getString("NOMBRE_CLIENTE"));
                obj.setApellidoCliente(rs.getString("APELLIDOS_CLIENTE"));
                obj.setDNI(rs.getString("DNI"));
                obj.setDireccion(rs.getString("DIRECCION"));
                obj.setTalla(rs.getDouble("TALLA"));
                obj.setPeso_inicial(rs.getDouble("PESO_INICIAL"));
                obj.setPeso_actual(rs.getDouble("PESO_ACTUAL"));
                obj.setIMC(rs.getDouble("IMC"));
                obj.setIdUsuario(rs.getInt("ID_USUARIO"));
                obj.setCelular(rs.getString("CELULAR"));
                obj.calObser();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
            }
        }
        return obj;
    }

    public String EditarCliente(Cliente cliente) {
        String msg = "";
        Connection cn = MySQLConexion.getConexion();
        PreparedStatement st = null;

        try {
            String sql = "update mg_cliente set "
                    + "NOMBRE_CLIENTE = ?, APELLIDOS_CLIENTE = ?, DNI =?, DIRECCION =? , "
                    + "CELULAR =?, TALLA = ?, PESO_INICIAL = ?, IMC = ? "
                    + "where ID_CLIENTE = ?";
            st = cn.prepareStatement(sql);
            st.setString(1, cliente.getNombreCliente());
            st.setString(2, cliente.getApellidoCliente());
            st.setString(3, cliente.getDNI());
            st.setString(4, cliente.getDireccion());
            st.setString(5, cliente.getCelular());
            st.setDouble(6, cliente.getTalla());
            st.setDouble(7, cliente.getPeso_inicial());
            st.setDouble(8, cliente.getIMC());
            st.setInt(9, cliente.getIdCliente());
            if (st.executeUpdate() > 0) {
                msg = "OK";
            } else {
                msg = "No se pudieron editar datos del cliente";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = ex.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
            }
        }

        return msg;
    }

    public String Update_UsuarioCliente(Cliente cliente) {
        String msg = "";
        Connection cn = MySQLConexion.getConexion();
        Statement st = null;
        String sql;

        try {
            sql = "UPDATE mg_cliente SET ID_USUARIO =" + cliente.getIdUsuario() + " WHERE ID_CLIENTE =" + cliente.getIdCliente();

            st = cn.createStatement();
            if (st.executeUpdate(sql) > 0) {
                msg = "OK";
            } else {
                msg = "No se pudieron actualizar datos del cliente";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = ex.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
            }
        }
        return msg;
    }

    public Cliente ObtenerUsuario(int idCli) {
        Cliente obj = null;
        Connection cn = MySQLConexion.getConexion();
        ResultSet rs;
        try {
            String sql = "select * from mg_usuario u inner join mg_cliente c "
                    + " on u.id_usuario = c.id_usuario "
                    + " where id_cliente = ?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, idCli);
            rs = st.executeQuery();
            if (rs.next()) {
                obj = new Cliente();
                obj.setIdCliente(rs.getInt("ID_CLIENTE"));
                obj.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));
                obj.setClaveusuario(rs.getString("CLAVE_USUARIO"));
                obj.setIdUsuario(rs.getInt("ID_USUARIO"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
            }
        }
        return obj;
    }

    public String EliminarCliente(int id) {
        String msg = "";
        Connection cn = MySQLConexion.getConexion();
        try {
            String sql = "delete from MG_CLIENTE "
                    + " where ID_CLIENTE=?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, id);

            if (st.executeUpdate() > 0) {
                msg = "OK";
            } else {
                msg = "No se pudieron eliminar datos del cliente.";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = ex.getMessage();
        }
        return msg;
    }
}
