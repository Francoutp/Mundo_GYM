package Modelos;

/**
 * Fecha:18/09/2022
 * Versión: 1.0
 * @author ricardo
 */
public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String claveusuario;
    private int perfilUsuario;
    private String desPerfilUsuario;

    public Usuario() {
    }
    
    //omitimos el id del perfil de usuario, usamos la descripcion del perfil
    public Usuario(int idUsuario, String nombreUsuario, String claveusuario, String desPerfilUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.claveusuario = claveusuario;
        this.desPerfilUsuario = desPerfilUsuario;
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

    public String getDesPerfilUsuario() {
        return desPerfilUsuario;
    }

    public void setDesPerfilUsuario(String desPerfilUsuario) {
        this.desPerfilUsuario = desPerfilUsuario;
    }

    
}
