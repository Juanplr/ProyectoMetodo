/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author juanl
 */
public class Cita {
    private String NombreU;
    private String Paciente;
    private int id;
    private String fecha;
    private String hora;

    public Cita(String NombreU, int id, String fecha, String hora) {
        this.NombreU = NombreU;
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Cita(String paciente, String psicologo, String fecha, String hora) {
        this.NombreU = psicologo;
        this.Paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getNombreU() {
        return NombreU;
    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setNombreU(String NombreU) {
        this.NombreU = NombreU;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPaciente() {
        return Paciente;
    }

    public void setPaciente(String Paciente) {
        this.Paciente = Paciente;
    }
    
}
