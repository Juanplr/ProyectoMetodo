package Controlador;

import Vista.Login;
import Vista.Pacientes;


public class Main {

      public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               Pacientes l =  new Pacientes();
               l.setDefaultCloseOperation(l.EXIT_ON_CLOSE);
               l.setVisible(true);
                
            }
        });
    }
    
}
