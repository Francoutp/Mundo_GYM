package Modelos;

import java.util.Date;

public class Cliente{

    private int idCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String dni;
    private String direccion;
    private double talla;
    private double pesoInicial;
    private double pesoActual;
    private double imc;
    private int idUsuario;
    private String celular;
    private String observacion;

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", dni=" + dni + ", direccion=" + direccion + ", talla=" + talla + ", pesoInicial=" + pesoInicial + ", pesoActual=" + pesoActual + ", imc=" + imc + ", idUsuario=" + idUsuario + ", celular=" + celular + ", observacion=" + observacion + '}';
    }
    
    public Cliente() {
    }

    public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String dni, String direccion, double talla, double pesoInicial, double pesoActual, double imc, int idUsuario, String celular, String observacion) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.dni = dni;
        this.direccion = direccion;
        this.talla = talla;
        this.pesoInicial = pesoInicial;
        this.pesoActual = pesoActual;
        this.imc = imc;
        this.idUsuario = idUsuario;
        this.celular = celular;
        this.observacion=observacion;
    }
    
    public double CalculoIMC(){
        return pesoActual/(talla*talla);
    }
    
    public String ObtenerObservacion(){
        String msj="";
        if (CalculoIMC()<18.5) {
            msj="Bajo de peso";
        } else {
            if (CalculoIMC()>=18.5 && CalculoIMC()<=24.9) {
                msj="Peso normal";
            } else {
                if (CalculoIMC()>=25 && CalculoIMC()<=29.9) {
                    msj="Sobrepeso";
                } else {
                    msj="Obesidad";
                }
            }
        }
        return msj;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion() {
        this.observacion = ObtenerObservacion();
    }
    
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public double getImc() {
        return imc;
    }

    public void setImc() {
        this.imc = CalculoIMC();
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
