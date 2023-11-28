package Controlador;

import Modelo.Usuario;
import Vista.Login;
import Vista.VentanaCitas;
import Vista.VentanaUsuarios;


public class Main {

      public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaCitas l =  new VentanaCitas(new Usuario());
               l.setDefaultCloseOperation(l.EXIT_ON_CLOSE);
               l.setVisible(true);
                
            }
        });
    }
    
}
