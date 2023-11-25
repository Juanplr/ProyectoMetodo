package Controlador;

import Modelo.*;
import Modelo.PersonalTableModel;
import Vista.MainWindow;
import Vista.VentanaUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuariosControlador implements ActionListener{
    VentanaUsuarios ventana;
    Modelo modelo = new Modelo();
    public UsuariosControlador(VentanaUsuarios ventana) {
        this.ventana = ventana;
    }
    public void iniciar(){
        ventana.tablaUsuarios.setModel(new PersonalTableModel(modelo.getUsuarios()));
        ventana.tablaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(0); 
        ventana.tablaUsuarios.getColumnModel().getColumn(4).setMaxWidth(0);
        ventana.tablaUsuarios.getColumnModel().getColumn(4).setMinWidth(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== ventana.btnCerrar){
            MainWindow home = new MainWindow(ventana.user);
            ventana.setVisible(false);
            home.setVisible(true);
        }
        if(e.getSource()== ventana.btnAgregar){
            Usuario user;
            int cedula;
            String nombreC = ventana.txtNombre.getText();
            String nombreU = ventana.txtNomUser.getText();
            String passw = new String(ventana.txtPassw.getPassword());
            String tipo = ventana.txtTipo.getSelectedItem().toString();
            if("Asistente".equals(tipo)||"Administrador".equals(tipo)){
                user = new Usuario(nombreC, nombreU, passw, tipo);
            }else{
                cedula = Integer.parseInt(ventana.txtCP.getText());
                user = new Usuario(nombreC, nombreU, passw, tipo, cedula);
            }
            modelo.agregarUsuario(user);
            iniciar();
            limpiar();
        }
        if(e.getSource()== ventana.btnEditar){
            Usuario user;
            int cedula;
            String nombreC = ventana.txtNombre.getText();
            String nombreU = ventana.txtNomUser.getText();
            String passw = new String(ventana.txtPassw.getPassword());
            String tipo = ventana.txtTipo.getSelectedItem().toString();
            if("Asistente".equals(tipo)){
                user = new Usuario(nombreC, nombreU, passw, tipo);
            }else{
                cedula = Integer.parseInt(ventana.txtCP.getText());
                user = new Usuario(nombreC, nombreU, passw, tipo, cedula);
            }
            modelo.EditarUsuario(user);
            iniciar();
            limpiar();
        }
        if(e.getSource()== ventana.btnEliminar){
            Usuario user;
            int cedula = 0;
            String nombreC = ventana.txtNombre.getText();
            String nombreU = ventana.txtNomUser.getText();
            String passw = new String(ventana.txtPassw.getPassword());
            String tipo = ventana.txtTipo.getSelectedItem().toString();
            user = new Usuario(nombreC, nombreU, passw, tipo, cedula);
            modelo.eliminarUsuario(user);
            iniciar();
            limpiar();
        }
        if(e.getSource()== ventana.txtTipo){
            if("Psicologo".equals(ventana.txtTipo.getSelectedItem().toString())){
                ventana.txtCP.setEnabled(true);
            }else{
                ventana.txtCP.setEnabled(false);
            }
        }
        if(e.getSource()== ventana.datosT){
            if("Asistentes".equals(ventana.datosT.getSelectedItem().toString())){
                ventana.tablaUsuarios.setModel(new PersonalTableModel(modelo.getUsuariosEspecificos("Asistente")));
                ventana.tablaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(0); 
                ventana.tablaUsuarios.getColumnModel().getColumn(4).setMaxWidth(0);
                ventana.tablaUsuarios.getColumnModel().getColumn(4).setMinWidth(0);
            }
            if("Psicologos".equals(ventana.datosT.getSelectedItem().toString())){
                ventana.tablaUsuarios.setModel(new PersonalTableModel(modelo.getUsuariosEspecificos("Psicologo")));
                ventana.tablaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(0); 
                ventana.tablaUsuarios.getColumnModel().getColumn(4).setMaxWidth(0);
                ventana.tablaUsuarios.getColumnModel().getColumn(4).setMinWidth(0);
            }
            if("Todos".equals(ventana.datosT.getSelectedItem().toString())){
                iniciar();
            }
            if("Administrador".equals(ventana.datosT.getSelectedItem().toString())){
                ventana.tablaUsuarios.setModel(new PersonalTableModel(modelo.getUsuariosEspecificos("Administrador")));
                ventana.tablaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(0); 
                ventana.tablaUsuarios.getColumnModel().getColumn(4).setMaxWidth(0);
                ventana.tablaUsuarios.getColumnModel().getColumn(4).setMinWidth(0);
            } 
        }
    }

    private void limpiar() {
        ventana.txtNombre.setText("");
        ventana.txtNomUser.setText("");
        ventana.txtPassw.setText("");
        ventana.txtTipo.setSelectedIndex(0);;
        ventana.txtCP.setText("");
        ventana.txtNomUser.setEditable(true);
    }
    
    
    
}
