
package Controlador;

import Modelo.*;
import Vista.VentanaCitas;
import Vista.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author juanl
 */
public class CitasControlador  implements ActionListener, PropertyChangeListener{

    VentanaCitas ventana;
    Modelo modelo = new Modelo();
    ArrayList<Usuario> psicologos;
    ArrayList<Paciente> pacientes;
    String UserName;
    int id;
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
            int i = ventana.boxPacientes.getSelectedIndex();
            if(i!=0){
                id= pacientes.get(i-1).getId();
            }
        }
        if(e.getSource()==ventana.boxPsicologos){
            int i = ventana.boxPsicologos.getSelectedIndex();
            if(i!=0){
                UserName = psicologos.get(i-1).getNombreU();
                if(ventana.txtFeacha.getText()!=""){
                    ventana.boxHora.setModel(modelo.hoarios(UserName,ventana.txtFeacha.getText()));
                }
            }
            
        }
        if(e.getSource()==ventana.btnAgendar){
            if(validar()){
                String nombre = UserName;
                int id = this.id;
                String fecha = ventana.txtFeacha.getText();
                String hora = ventana.boxHora.getSelectedItem().toString();
                Cita cita = new Cita(nombre, id, fecha, hora);
                modelo.agregrarCita(cita);
                javax.swing.JOptionPane.showMessageDialog(ventana, "Cita "+cita.getId()+" Agregado Correctamente\n", "Bien", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                modelo.registrar(ventana.user.toString() + " Agrego la cita " + cita.getId() );
            }else{
                javax.swing.JOptionPane.showMessageDialog(ventana, "Debes Llenar los campos\n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            limpiar();
        }
    }

    private void limpiar() {
        ventana.boxPacientes.setSelectedIndex(0);
        ventana.boxPsicologos.setSelectedIndex(0);
        ventana.boxHora.setSelectedIndex(0);
        ventana.txtFeacha.setText("");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getSource()== ventana.calendario){
            SimpleDateFormat formato =new SimpleDateFormat("dd-MM-yyyy");
            String fecha;
            fecha = formato.format(ventana.calendario.getDate());
            ventana.txtFeacha.setText(fecha);
        }
        int i = ventana.boxPsicologos.getSelectedIndex();
        if(i!=0){
            ventana.boxHora.setModel(modelo.hoarios(UserName,ventana.txtFeacha.getText()));
        }
    }
    private boolean validar(){
        return !("".equals(ventana.txtFeacha.getText()) || "Escoge".equals(ventana.boxHora.getSelectedItem()) || ventana.boxPacientes.getSelectedItem()=="Seleciona" || ventana.boxPsicologos.getSelectedItem()=="Seleciona");
    }
}
