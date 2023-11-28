package Modelo;



public class Paciente {
    private int id;
    private String nombre;
    private String fechaN;
    private String estadoC;
    private String nivelEstud;
    private String ocupacion;
    private int estado;
    public Paciente(){
        this.estado = 0;
    }

    public Paciente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Paciente(int id, String nombre, String fechaN, String estadoC, String nivelEstud, String ocupacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaN = fechaN;
        this.estadoC = estadoC;
        this.nivelEstud = nivelEstud;
        this.ocupacion = ocupacion;
        this.estado = 0;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaN() {
        return fechaN;
    }

    public String getEstadoC() {
        return estadoC;
    }

    public String getNivelEstud() {
        return nivelEstud;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    public void setEstadoC(String estadoC) {
        this.estadoC = estadoC;
    }

    public void setNivelEstud(String nivelEstud) {
        this.nivelEstud = nivelEstud;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }    
}
