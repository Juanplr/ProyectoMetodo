package Controlador;

import Modelo.Modelo;
import Modelo.PersonalTableModel;
import Modelo.Usuario;
import Vista.*;
import Vista.ventanaCalendario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CalendarioControlador implements ActionListener, MouseListener, PropertyChangeListener{
    ventanaCalendario ventana;
    Modelo modelo = new Modelo();
    ArrayList<Usuario> psicologos;
    String UserName;
    public CalendarioControlador(ventanaCalendario ventana) {
        this.ventana = ventana;     
    }
    
    public void iniciar(){
        ventana.txtFecha.setEditable(false);
        psicologos = modelo.listaPsicologos();
        ventana.boxPsicologos.addItem("Seleciona");
        for (int i = 0; i < psicologos.size(); i++) {
            ventana.boxPsicologos.addItem(psicologos.get(i).getNombreC());
        }
        ventana.tabla.setModel(new PersonalTableModel(modelo.getCitasPorFecha(fecha())));
    }
    public String fecha(){
        SimpleDateFormat formato =new SimpleDateFormat("dd-MM-yyyy");
        String fecha;
        fecha = formato.format(ventana.calendario.getDate());
        ventana.txtFecha.setText(fecha);
        return fecha;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ventana.btnCerrar){
            MainWindow home = new MainWindow(ventana.user);
            ventana.setVisible(false);
            home.setVisible(true);
        }
        if(e.getSource() == ventana.boxPsicologos){
            reorganizar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
         if(evt.getSource()== ventana.calendario){
            SimpleDateFormat formato =new SimpleDateFormat("dd-MM-yyyy");
            String fecha;
            fecha = formato.format(ventana.calendario.getDate());
            ventana.txtFecha.setText(fecha);
            reorganizar();
        }
    }
    public void reorganizar(){
        if(ventana.boxPsicologos.getSelectedItem().equals("Seleciona")){
            ventana.tabla.setModel(new PersonalTableModel(modelo.getCitasPorFecha(fecha())));
        }else{
             ventana.tabla.setModel(new PersonalTableModel(modelo.getCitasPorPscologo(ventana.boxPsicologos.getSelectedItem().toString(),fecha())));
        }
    }
    
}
