package Modelo;



public class Usuario {
    private String nombreC;
    private String nombreU;
    private String passw;
    private String tipo;
    private int cedula;

    public Usuario(String nombreC, String nombreU, String passw, String tipo, int cedula) {
        this.nombreC = nombreC;
        this.nombreU = nombreU;
        this.passw = passw;
        this.tipo = tipo;
        this.cedula = cedula;
    }


    public Usuario(String nombreC, String nombreU) {
        this.nombreC = nombreC;
        this.nombreU = nombreU;
    }
    
    public Usuario(String nombreC, String nombreU, String passw, String tipo) {
        this.nombreC = nombreC;
        this.nombreU = nombreU;
        this.passw = passw;
        this.tipo = tipo;
    }

    public Usuario() {
    }

    public String getNombreC() {
        return nombreC;
    }

    public String getNombreU() {
        return nombreU;
    }

    public String getPassw() {
        return passw;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreC=" + nombreC + ", nombreU=" + nombreU + ", passw=" + passw + ", tipo=" + tipo + ", cedula=" + cedula + '}';
    }
    
}
