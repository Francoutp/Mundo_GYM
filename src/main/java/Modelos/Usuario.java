package Modelos;
/**
 * Fecha:24/09/2022
 * Versión: 1.1
 * @author ricardo
 * perfil usuario: 1 cliente / 2 administrador
 */
public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String claveusuario;
    private int perfilUsuario;
    

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String claveusuario, int perfilUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.claveusuario = claveusuario;
        this.perfilUsuario = perfilUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClaveusuario() {
        return claveusuario;
    }

    public void setClaveusuario(String claveusuario) {
        this.claveusuario = claveusuario;
    }

    public int getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(int perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", claveusuario=" + claveusuario + ", perfilUsuario=" + perfilUsuario + '}';
    }
}
