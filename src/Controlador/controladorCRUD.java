/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Modelo;
import Vista.ConsultasDetalladas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juanl
 */
public class controladorCRUD implements ActionListener{
    
    ConsultasDetalladas ventana;
    Modelo modelo = new Modelo();
    public controladorCRUD(ConsultasDetalladas ventana) {
        this.ventana = ventana;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ventana.btnEliminar){
            modelo.eliminarCita(ventana.cita);
        }
        if(e.getSource()==ventana.btnEditar){
            modelo.editarCita(ventana.cita);
        }
    }
    
}
