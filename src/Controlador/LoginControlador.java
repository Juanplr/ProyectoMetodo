package Controlador;


import Modelo.Modelo;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Login;
import Vista.MainWindow;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginControlador implements ActionListener, KeyListener{
    private Login ventana;
    private final Modelo modelo = new Modelo();
    Usuario user;
    public LoginControlador(Login ventana) {
        this.ventana = ventana;
    }

    public Login getVentana() {
        return ventana;
    }

    public void setVentana(Login ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== ventana.btLogin){
           String usuario = ventana.txtUser.getText();
           String contrasena = new String(ventana.txtpassw.getPassword());
           acceso(usuario, contrasena);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        String usuario = ventana.txtUser.getText();
        String contrasena = new String(ventana.txtpassw.getPassword());
        if(e.getKeyChar() == '\n' && "".equals(contrasena)){
            ventana.txtpassw.requestFocus();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void limpiar() {
        ventana.txtUser.setText("");
        ventana.txtpassw.setText("");
        ventana.txtUser.requestFocus();
    }
    private void acceso(String usuario, String contrasena){
        if(usuario.equals("")|| contrasena.equals("")){
                javax.swing.JOptionPane.showMessageDialog(ventana, "Debe llenar todos los campos \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                limpiar();
        }else{
            if(modelo.verificarUsuario(usuario, contrasena)){
                user = modelo.getUser(usuario);
                try {
                    javax.swing.JOptionPane.showMessageDialog(ventana, "Bienvenido " + usuario+"! :) \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    MainWindow home = new MainWindow(user);
                    ventana.setVisible(false);
                    home.setVisible(true);
                }catch(HeadlessException e) {
                    System.out.println(e);
                }
            }else{
                javax.swing.JOptionPane.showMessageDialog(ventana, "Usuario o contraseña incorrecta!!\n", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                limpiar();
            }
        }
    }
    
}
