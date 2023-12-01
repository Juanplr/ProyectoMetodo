package Controlador;

import Modelo.Modelo;
import Modelo.Usuario;
import Vista.*;
import Vista.ventanaCalendario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CalendarioControlador implements ActionListener, MouseListener {
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
        SimpleDateFormat formato =new SimpleDateFormat("dd-MM-yyyy");
        String fecha;
        fecha = formato.format(ventana.calendario.getDate());
        ventana.txtFecha.setText(fecha);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ventana.btnCerrar){
            MainWindow home = new MainWindow(ventana.user);
            ventana.setVisible(false);
            home.setVisible(true);
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
    
    
}
