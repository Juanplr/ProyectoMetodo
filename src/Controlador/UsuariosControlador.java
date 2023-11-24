package Controlador;

import Modelo.Modelo;
import Modelo.PersonalTableModel;
import Vista.Login;
import Vista.Pacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuariosControlador implements ActionListener{
    Pacientes ventana;
    Modelo modelo = new Modelo();
    public UsuariosControlador(Pacientes ventana) {
        this.ventana = ventana;
    }
    public void iniciar(){
        ventana.tablaUsuarios.setModel(new PersonalTableModel(modelo.getUsuarios()));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== ventana.btnCerrar){
            Login home = new Login();
            ventana.setVisible(false);
            home.setVisible(true);
        }
        if(e.getSource()== ventana.btnAgregar){
            
        }
        if(e.getSource()== ventana.btnEditar){
            
        }
        if(e.getSource()== ventana.btnEliminar){
            
        }
        if(e.getSource()== ventana.txtTipo){
            if(ventana.txtTipo.getSelectedItem().toString()=="Psicologo"){
                ventana.txtCP.setEnabled(true);
            }else{
                ventana.txtCP.setEnabled(false);
            }
        }
        if(e.getSource()== ventana.datosT){
            if(ventana.datosT.getSelectedItem().toString()=="Asistentes"){
                ventana.tablaUsuarios.setModel(new PersonalTableModel(modelo.getUsuariosEspecificos("Asistente")));
            }
            if(ventana.datosT.getSelectedItem().toString()=="Psicologos"){
                ventana.tablaUsuarios.setModel(new PersonalTableModel(modelo.getUsuariosEspecificos("Psicologo")));
            }
            if(ventana.datosT.getSelectedItem().toString()=="Todos"){
                iniciar();
            } 
        }
    }
    
    
    
}
