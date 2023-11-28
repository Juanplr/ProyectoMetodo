
package Controlador;

import Modelo.*;
import Vista.VentanaCitas;
import Vista.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 *
 * @author juanl
 */
public class CitasControlador  implements ActionListener, MouseListener{

    VentanaCitas ventana;
    Modelo modelo = new Modelo();
    ArrayList<Usuario> psicologos;
    ArrayList<Paciente> pacientes;
    ArrayList<String> horarios;
    public CitasControlador(VentanaCitas ventana) {
        this.ventana = ventana;
    }
    
    public void iniciar(){
        psicologos = modelo.listaPsicologos();
        ventana.boxPsicologos.addItem("Seleciona");
        for (int i = 0; i < psicologos.size(); i++) {
            ventana.boxPsicologos.addItem(psicologos.get(i).getNombreC());
        }
        pacientes = modelo.listaPacientes();
        ventana.boxPacientes.addItem("Seleciona");
        for (int i = 0; i < pacientes.size(); i++) {
            ventana.boxPacientes.addItem(pacientes.get(i).getNombre());
        }
        ventana.boxHora.addItem("Elejir");
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==ventana.btnCerrar){
            MainWindow home = new MainWindow(ventana.user);
            ventana.setVisible(false);
            home.setVisible(true);
        }
        if(e.getSource()==ventana.boxHora){
            
        }
        if(e.getSource()==ventana.boxPacientes){
            
        }
        if(e.getSource()==ventana.boxPsicologos){
            int i = ventana.boxPsicologos.getSelectedIndex();
            if(i!=0){
                String UserName = psicologos.get(i-1).getNombreU();
                horarios = modelo.listaHorariosDisponibles(UserName,psicologos.get(i-1).getIdHora());
            }
        }
        if(e.getSource()==ventana.btnAgendar){        
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==ventana.calendario){
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
