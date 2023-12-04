
package Controlador;

import Modelo.Cita;
import Modelo.Modelo;
import Modelo.Paciente;
import Modelo.PersonalTableModel;
import Vista.Consultas;
import Vista.ConsultasDetalladas;
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
public class ConsultasControlador implements ActionListener, MouseListener{
    Consultas ventana;
    Modelo modelo = new Modelo();
    public ConsultasControlador(Consultas ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== ventana.btnCerrar){
            MainWindow home = new MainWindow(ventana.user);
            ventana.setVisible(false);
            home.setVisible(true);
        }
        if(e.getSource() == ventana.boxPacientes){
            String nombre = ventana.boxPacientes.getSelectedItem().toString();
            if(!nombre.equals("Seleciona")){
                ventana.tablaCitas.setModel(new PersonalTableModel(modelo.getCitasPorPaciente(nombre)));
            }else{
                iniciar();
            }
        }
        
    }
    public void iniciar(){
        ventana.tablaCitas.setModel(new PersonalTableModel(modelo.getCitas()));
        ventana.tablaCitas.getColumnModel().getColumn(4).setPreferredWidth(0); 
        ventana.tablaCitas.getColumnModel().getColumn(4).setMaxWidth(0);
        ventana.tablaCitas.getColumnModel().getColumn(4).setMinWidth(0);
        ventana.tablaCitas.getColumnModel().getColumn(5).setPreferredWidth(0); 
        ventana.tablaCitas.getColumnModel().getColumn(5).setMaxWidth(0);
        ventana.tablaCitas.getColumnModel().getColumn(5).setMinWidth(0);
    }
    public void box(){
        ArrayList<Paciente> pacientes = modelo.listaPacientes();
        ventana.boxPacientes.addItem("Seleciona");
        for (int i = 0; i < pacientes.size(); i++) {
            ventana.boxPacientes.addItem(pacientes.get(i).getNombre());
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
         if(e.getSource()== ventana.tablaCitas){
            int fila = ventana.tablaCitas.getSelectedRow();
            String paciente = ventana.tablaCitas.getValueAt(fila, 0).toString();
            String psicologo = ventana.tablaCitas.getValueAt(fila, 1).toString();
            String fecha = ventana.tablaCitas.getValueAt(fila, 2).toString();
            String hora = ventana.tablaCitas.getValueAt(fila, 3).toString();
            String username = ventana.tablaCitas.getValueAt(fila, 4).toString();
            int id =   Integer.parseInt(ventana.tablaCitas.getValueAt(fila, 5).toString());
            Cita cita = new Cita(psicologo, paciente, username, id, fecha, hora);
            ConsultasDetalladas home = new ConsultasDetalladas(cita, ventana.user);
            home.setVisible(true);
        }
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
