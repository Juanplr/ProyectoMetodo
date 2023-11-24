package Controlador;

import Modelo.Modelo;
import Modelo.Paciente;
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
            try {
                Paciente np = new Paciente();
                SimpleDateFormat formato =new SimpleDateFormat("dd-MM-yyyy");
                String fecha;
                fecha = formato.format(ventana.txtFecha.getDate());
                np.setNombre(ventana.txtNombre.getText());
                np.setFechaN(fecha);
                np.setEstadoC(ventana.txtEstadoC.getSelectedItem().toString());
                np.setNivelEstud(ventana.txtNE.getSelectedItem().toString());
                np.setOcupacion(ventana.txtOcupacion.getText());  

                // Agrega un mensaje de depuración para verificar los datos antes de agregar el paciente
                System.out.println("Paciente a agregar: " + np.toString());

                m.agregarPaciente(np);
                iniciar();
                limpiar();
            } catch (NumberFormatException ex) {
                System.out.println("Error al convertir el ID a entero: " + ex.getMessage());
            }
        }
        if(e.getSource() == ventana.btModificar){
            Paciente pa = new Paciente();
            SimpleDateFormat formato =new SimpleDateFormat("dd-MM-yyyy");
            String fecha;
            fecha = formato.format(ventana.txtFecha.getDate());
            
            pa.setId(Integer.parseInt(ventana.txtId.getText()));
            pa.setNombre(ventana.txtNombre.getText());
            pa.setFechaN(fecha);
            pa.setEstadoC(ventana.txtEstadoC.getSelectedItem().toString());
            pa.setNivelEstud(ventana.txtNE.getSelectedItem().toString());
            pa.setOcupacion(ventana.txtOcupacion.getText());
            m.ActualizarPaciente(pa);
            iniciar();
            limpiar();
            ventana.txtId.setEnabled(true);
        }
        if(e.getSource()==ventana.btEliminar){
            Paciente a = new Paciente();
            a.setId(Integer.parseInt(ventana.txtId.getText()));
            modelo.PapeleriaPaciente(a);
            iniciar();
            limpiar();
            ventana.txtId.setEnabled(true);
        }
        if(e.getSource() == ventana.btnCerrar){
            MainWindow home = new MainWindow();
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
    
}
