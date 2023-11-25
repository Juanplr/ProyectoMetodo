package Controlador;

import Vista.Login;
import Vista.VentanaUsuarios;


public class Main {

      public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               Login l =  new Login();
               l.setDefaultCloseOperation(l.EXIT_ON_CLOSE);
               l.setVisible(true);
                
            }
        });
    }
    
}
