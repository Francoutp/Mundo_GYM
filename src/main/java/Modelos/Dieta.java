package Modelos;


public class Dieta {
    private int idDieta;
    private String nombreDieta;
    private int idTipoDieta;
    private int idHorarioDieta;

    public Dieta() {
    }

    public Dieta(int idDieta, String nombreDieta, int idTipoDieta, int idHorarioDieta) {
        this.idDieta = idDieta;
        this.nombreDieta = nombreDieta;
        this.idTipoDieta = idTipoDieta;
        this.idHorarioDieta = idHorarioDieta;
    }

    public int getIdHorarioDieta() {
        return idHorarioDieta;
    }

    public void setIdHorarioDieta(int idHorarioDieta) {
        this.idHorarioDieta = idHorarioDieta;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombreDieta() {
        return nombreDieta;
    }

    public void setNombreDieta(String nombreDieta) {
        this.nombreDieta = nombreDieta;
    }

    public int getIdTipoDieta() {
        return idTipoDieta;
    }

    public void setIdTipoDieta(int idTipoDieta) {
        this.idTipoDieta = idTipoDieta;
    }
    
    
}
