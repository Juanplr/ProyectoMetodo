package Vista;

import Controlador.MainControlador;
import Modelo.Usuario;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author inigu
 */
public class MainWindow extends javax.swing.JFrame {
    MainControlador controlador = new MainControlador(this);
    public Usuario user;
    public MainWindow(Usuario user) {
        this.user = user;
        initComponents();
        this.pintarimagen();
        btPacientes.addActionListener(controlador);
        btnUsuarios.addActionListener(controlador);
        btCitas.addActionListener(controlador);
        btnHistorialP.addActionListener(controlador);
        btSalir.addActionListener(controlador);
        btCalendario.addActionListener(controlador);
        perfil();
        this.setSize(490, 390);
        this.setLocationRelativeTo(null);  
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btPacientes = new javax.swing.JButton();
        btCalendario = new javax.swing.JButton();
        btnHistorialP = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btCitas = new javax.swing.JButton();
        btSalir = new javax.swing.JButton();
        equipo = new javax.swing.JLabel();
        circulo = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        btPacientes.setText("Pacientes");
        jPanel1.add(btPacientes);
        btPacientes.setBounds(20, 60, 120, 32);

        btCalendario.setText("Calendario");
        jPanel1.add(btCalendario);
        btCalendario.setBounds(340, 60, 100, 32);

        btnHistorialP.setText("Historial De Pacientes");
        jPanel1.add(btnHistorialP);
        btnHistorialP.setBounds(80, 110, 160, 32);

        btnUsuarios.setText("Usuarios");
        jPanel1.add(btnUsuarios);
        btnUsuarios.setBounds(280, 110, 90, 32);

        btCitas.setText("Citas");
        jPanel1.add(btCitas);
        btCitas.setBounds(180, 60, 100, 32);

        btSalir.setText("Salir");
        jPanel1.add(btSalir);
        btSalir.setBounds(374, 6, 89, 32);
        jPanel1.add(equipo);
        equipo.setBounds(120, 130, 260, 210);
        jPanel1.add(circulo);
        circulo.setBounds(120, 130, 260, 210);
        jPanel1.add(fondo);
        fondo.setBounds(0, 0, 480, 350);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pintarimagen(){
        ImageIcon fndo = new ImageIcon("src\\images\\Colors.jpg");
        ImageIcon iconof = new ImageIcon(fndo.getImage().getScaledInstance(this.fondo.getWidth(), this.fondo.getHeight(), Image.SCALE_DEFAULT));
        this.fondo.setIcon(iconof);
        this.repaint();
        ImageIcon cir = new ImageIcon("src\\images\\circle.png");
        ImageIcon iconocir = new ImageIcon(cir.getImage().getScaledInstance(this.circulo.getWidth(), this.circulo.getHeight(), Image.SCALE_DEFAULT));
        this.circulo.setIcon(iconocir);
        this.repaint();
        ImageIcon eq = new ImageIcon("src\\images\\SCP Logo.png");
        ImageIcon iconoeq = new ImageIcon(eq.getImage().getScaledInstance(this.equipo.getWidth(), this.equipo.getHeight(), Image.SCALE_DEFAULT));
        this.equipo.setIcon(iconoeq);
        this.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btCalendario;
    public javax.swing.JButton btCitas;
    public javax.swing.JButton btPacientes;
    public javax.swing.JButton btSalir;
    public javax.swing.JButton btnHistorialP;
    public javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel circulo;
    private javax.swing.JLabel equipo;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void perfil() {
        if(user.getTipo().equals("Asistente")){
            btnUsuarios.setVisible(false);
            btnHistorialP.setVisible(false);
        }
        if(user.getTipo().equals("Psicologo")){
            btnUsuarios.setVisible(false);
        }
    }
}
