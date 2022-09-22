package Modelos;

import java.util.Date;

public class Cliente extends Usuario {

    private int idCliente;
    private String direccion;
    private double talla;
    private String nombreCliente;
    private String apellidoCliente;
    private String DNI;
    private Double peso_inicial;
    private Double peso_actual;
    private Double IMC;
    private String Celular;
    private int id_consolidacion;
    private Date fecha_ini_programacion;
    private Date fecha_fin_programacion;
    private int id_dieta;
    private int id_rutina;
    private String Observacion;

    public void calObser() {
        if (IMC < 18.5) {
            Observacion = ("Bajo Peso");
        } else if (IMC >= 18.5 && IMC <= 24.9) {
            Observacion = ("Normal");
        } else if (IMC >= 25 && IMC <= 29.9) {
            Observacion = ("Sobrepeso");
        } else {
            Observacion = ("Obesidad");
        }
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Double getPeso_inicial() {
        return peso_inicial;
    }

    public void setPeso_inicial(Double peso_inicial) {
        this.peso_inicial = peso_inicial;
    }

    public Double getPeso_actual() {
        return peso_actual;
    }

    public void setPeso_actual(Double peso_actual) {
        this.peso_actual = peso_actual;
    }

    public Double getIMC() {
        return IMC;
    }

    public void setIMC(Double IMC) {
        this.IMC = IMC;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public int getId_consolidacion() {
        return id_consolidacion;
    }

    public void setId_consolidacion(int id_consolidacion) {
        this.id_consolidacion = id_consolidacion;
    }

    public Date getFecha_ini_programacion() {
        return fecha_ini_programacion;
    }

    public void setFecha_ini_programacion(Date fecha_ini_programacion) {
        this.fecha_ini_programacion = fecha_ini_programacion;
    }

    public Date getFecha_fin_programacion() {
        return fecha_fin_programacion;
    }

    public void setFecha_fin_programacion(Date fecha_fin_programacion) {
        this.fecha_fin_programacion = fecha_fin_programacion;
    }

    public int getId_dieta() {
        return id_dieta;
    }

    public void setId_dieta(int id_dieta) {
        this.id_dieta = id_dieta;
    }

    public int getId_rutina() {
        return id_rutina;
    }

    public void setId_rutina(int id_rutina) {
        this.id_rutina = id_rutina;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

}
