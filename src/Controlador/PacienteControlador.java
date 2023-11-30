package Controlador;

import Modelo.*;
import Modelo.PersonalTableModel;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class PacienteControlador implements ActionListener{

    private ventanaPaciente ventana;
    private final Modelo modelo = new Modelo();

    public PacienteControlador(ventanaPaciente ventana) {
        this.ventana = ventana;
    }
    public void iniciar(){
        ventana.tablaP.setModel(new PersonalTableModel(modelo.getPacientes()));
    }

    public ventanaPaciente getVentana() {
        return ventana;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setVentana(ventanaPaciente ventana) {
        this.ventana = ventana;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Modelo m = new Modelo();
        if(e.getSource()==ventana.btAgregar){
            if(validarCampos()){
                try {
                    Paciente np = llenarPaciente();
                    m.agregarPaciente(np);
                    javax.swing.JOptionPane.showMessageDialog(ventana, "Paciente "+np.getNombre()+" Agregado Correctamente\n", "Bien", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    m.registrar(ventana.user.toString() + " Agrego el Paciente" + np.getNombre());
                } catch (NumberFormatException ex) {
                    System.out.println("Error al convertir el ID a entero: " + ex.getMessage());
                }
            }else{
                javax.swing.JOptionPane.showMessageDialog(ventana, "Debes Llenar los Campos\n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            iniciar();
            limpiar();
        }
        if(e.getSource() == ventana.btModificar){
           if(validarCampos()){
                Paciente np = llenarPaciente();
                np.setId(Integer.parseInt(ventana.txtId.getText()));
                m.ActualizarPaciente(np);
                javax.swing.JOptionPane.showMessageDialog(ventana, "Paciente "+np.getNombre()+" Actualizado Correctamente\n", "Bien", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                m.registrar(ventana.user.toString() + " Modifico el Paciente" + np.getNombre());
           }else{
               javax.swing.JOptionPane.showMessageDialog(ventana, "Debes Seleccionar un Paciente Primero\n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
           }
           iniciar();
           limpiar();
           ventana.txtId.setEnabled(true);
        }
        if(e.getSource()==ventana.btEliminar){
            if(validarCampos()){
                Paciente np = llenarPaciente();
                np.setId(Integer.parseInt(ventana.txtId.getText()));
                modelo.PapeleriaPaciente(np);
                javax.swing.JOptionPane.showMessageDialog(ventana, "Paciente "+np.getNombre()+" En papeleria de Reciclaje\n", "Bien", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                m.registrar(ventana.user.toString() + " Mando a la Papeleria al Paciente" + np.getNombre());
           }else{
               javax.swing.JOptionPane.showMessageDialog(ventana, "Debes Seleccionar un Paciente Primero\n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
           }
            iniciar();
            limpiar();
            ventana.txtId.setEnabled(true);
        }
        if(e.getSource() == ventana.btnCerrar){
            MainWindow home = new MainWindow(ventana.user);
            ventana.setVisible(false);
            home.setVisible(true);
        }
    }
    
    private void limpiar(){
        ventana.txtId.setText("");
        ventana.txtNombre.setText("");
        ventana.txtFecha.setCalendar(null);
        ventana.txtEstadoC.setSelectedIndex(0);
        ventana.txtNE.setSelectedIndex(0);
        ventana.txtOcupacion.setText("");
        ventana.txtId.setVisible(false);
        ventana.jLabel1.setVisible(false);
    }
    private boolean  validarCampos(){
        return !("".equals(ventana.txtNombre.getText()) || "".equals(ventana.txtOcupacion.getText()) || ventana.txtEstadoC.getSelectedItem()=="Selecciona" || ventana.txtNE.getSelectedItem()=="Selecciona" || ventana.txtFecha.getDate().toString() =="");
    }
    private Paciente llenarPaciente(){
        Paciente auxiliar = new Paciente();
        SimpleDateFormat formato =new SimpleDateFormat("dd-MM-yyyy");
        String fecha;
        fecha = formato.format(ventana.txtFecha.getDate());
        auxiliar.setNombre(ventana.txtNombre.getText());
        auxiliar.setFechaN(fecha);
        auxiliar.setEstadoC(ventana.txtEstadoC.getSelectedItem().toString());
        auxiliar.setNivelEstud(ventana.txtNE.getSelectedItem().toString());
        auxiliar.setOcupacion(ventana.txtOcupacion.getText());  
        return auxiliar;
    }
}
