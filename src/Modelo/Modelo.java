package Modelo;

import Controlador.Conector;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;


public class Modelo {
    private static Conector cn = Conector.getInstance();
    private static Connection conexion;
    public Modelo(){}
    
    public boolean verificarUsuario(String usuario, String contrasena){
        boolean verificacion =false;
        try {
               conexion = cn.conectar();
               Statement stm;
                String sql ="select * from usuarios " 
                        + "where nombre_usuario= '"+usuario+"' and contrasena_usuario='"+contrasena+"'";
                stm = conexion.createStatement();
                ResultSet resultado = stm.executeQuery(sql);
                if(resultado.next()){
                    verificacion = true;
                }else{
                   verificacion = false;
                }
                cn.cerrarconexion();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        return verificacion;
    }
    
    public ResultSet getPacientes() {
        ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "select * from vPacientes;";
            rs= smt.executeQuery(sql);
            //cn.cerrarconexion();
        } catch (Exception e) {e.printStackTrace();}
        return rs;
    }
    public void ActualizarPaciente(Paciente p) {
        try {
            conexion = cn.conectar();
            PreparedStatement ps = conexion.prepareStatement("update paciente set nombre='"+p.getNombre()+"',fecha_nacimiento='"+p.getFechaN()+"', estado_civil='"+p.getEstadoC()+"',nivel_estudios='"+p.getNivelEstud()+"',ocupacion='"+p.getOcupacion()+"' where id='"+p.getId()+"';");
            ps.executeUpdate();
        } catch (Exception e) {e.printStackTrace();}
    }
    public void PapeleriaPaciente(Paciente p) {
        try {
            conexion = cn.conectar();
            PreparedStatement ps = conexion.prepareStatement("update paciente set papeleria= 1 where id='"+p.getId()+"';");
            ps.executeUpdate();
        } catch (Exception e) {e.printStackTrace();}
    }
    
    public void agregarPaciente(Paciente paciente) {
        try {
            conexion = cn.conectar();

            // Agrega mensajes de depuración para verificar los valores
            System.out.println("ID: " + paciente.getId());
            System.out.println("Nombre: " + paciente.getNombre());
            // ... Agrega más mensajes para otros valores

            PreparedStatement ps = conexion.prepareStatement("INSERT INTO paciente ( nombre, fecha_nacimiento, estado_civil, nivel_estudios, ocupacion, papeleria) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getFechaN());
            ps.setString(3, paciente.getEstadoC());
            ps.setString(4, paciente.getNivelEstud());
            ps.setString(5, paciente.getOcupacion());
            ps.setInt(6, paciente.getEstado());
            ps.execute(); 
            ps.close(); 
            cn.cerrarconexion(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public ResultSet getUsuarios() {
        ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "SELECT nombre_usuario, rol, nombre_completo, cedula, contrasena_usuario FROM usuarios;";
            rs= smt.executeQuery(sql);
            //cn.cerrarconexion();
        } catch (Exception e) {e.printStackTrace();}
        return rs;
    }
    public ResultSet getUsuariosEspecificos(String tipo) {
        ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "SELECT nombre_usuario, rol, nombre_completo, cedula,contrasena_usuario  FROM usuarios where rol ='" +tipo +"';";
            rs= smt.executeQuery(sql);
            //cn.cerrarconexion();
        } catch (Exception e) {e.printStackTrace();}
        return rs;
    }

    public void agregarUsuario(Usuario user) {
        try {
            conexion = cn.conectar();

            PreparedStatement ps = conexion.prepareStatement("INSERT INTO `usuarios`(`nombre_usuario`,`rol`,`nombre_completo`,`contrasena_usuario`,`cedula`) VALUES (?,?,?,?,?);");
            ps.setString(1, user.getNombreU());
            ps.setString(2, user.getTipo());
            ps.setString(3, user.getNombreC());
            ps.setString(4, user.getPassw());
            ps.setInt(5, user.getCedula());
            ps.execute(); 
            ps.close(); 
            cn.cerrarconexion(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
    }    
    public void eliminarUsuario(Usuario user) {
        try {
            conexion = cn.conectar();

            PreparedStatement ps = conexion.prepareStatement("delete from `usuarios` "+"where nombre_usuario='"+user.getNombreU()+"';");
            ps.execute(); 
            ps.close(); 
            cn.cerrarconexion(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
    }

    public Usuario getUser(String usuario) {
        Usuario u = new Usuario();
        ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "SELECT *  FROM usuarios where nombre_usuario ='" +usuario +"';";
            rs= smt.executeQuery(sql);
            while(rs.next()){
                u.setNombreU(rs.getString(1));
                u.setTipo(rs.getString(2));
                u.setNombreC(rs.getString(3));
                u.setPassw(rs.getString(4));
                u.setCedula(rs.getInt(5));
            }
        } catch (Exception e) {e.printStackTrace();}
        return u;
    }

    public void EditarUsuario(Usuario user) {
        try {
            conexion = cn.conectar();
            PreparedStatement ps = conexion.prepareStatement("update usuarios set nombre_usuario='"+user.getNombreU()+"',rol='"+user.getTipo()+"', nombre_completo='"+user.getNombreC()+"',contrasena_usuario='"+user.getPassw()+"',cedula='"+user.getCedula()+"' where nombre_usuario='"+user.getNombreU()+"';");
            ps.executeUpdate();
        } catch (Exception e) {e.printStackTrace();}
    }
    public ArrayList<Usuario> listaPsicologos(){
        ArrayList<Usuario> lista = new ArrayList<>();
        Usuario u;
        ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "SELECT nombre_usuario, nombre_completo  FROM usuarios where rol ='Psicologo';";
            rs= smt.executeQuery(sql);
            while(rs.next()){
                u = new Usuario(rs.getString(2), rs.getString(1));
                lista.add(u);
            }
        } catch (Exception e) {e.printStackTrace();}
        return lista;
    }

    public ArrayList<Paciente> listaPacientes() {
        ArrayList<Paciente> lista = new ArrayList<>();
        Paciente u;
        ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "SELECT id, nombre  FROM paciente where papeleria = 0;";
            rs= smt.executeQuery(sql);
            while(rs.next()){
                u = new Paciente(rs.getInt(1), rs.getString(2));
                lista.add(u);
            }
        } catch (Exception e) {e.printStackTrace();}
        return lista;
    }
    public void agregrarCita(Cita cita){
        try{
            conexion = cn.conectar();
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO `cita`(`nombre_usuario`,`id`,`fechaC`,`hora`) VALUES (?,?,?,?);");
            ps.setString(1, cita.getNombreU());
            ps.setInt(2, cita.getId());
            ps.setString(3, cita.getFecha());
            ps.setString(4, cita.getHora());
            ps.execute(); 
            ps.close(); 
            cn.cerrarconexion(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void editarCita(Cita cita){
        
    }
    public void eliminarCita(Cita cita){
        
    }
    public ResultSet getCitas() {
        ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "select * from citasVista;";
            rs= smt.executeQuery(sql);
            //cn.cerrarconexion();
        } catch (Exception e) {e.printStackTrace();}
        return rs;
    }
        public ResultSet getCitasPorPaciente(String nombre) {
        ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "select * from citasVista where paciente = '" +nombre +"';";
            rs= smt.executeQuery(sql);
            //cn.cerrarconexion();
        } catch (Exception e) {e.printStackTrace();}
        return rs;
    }

    public void registrar(String informacion) {
         try {
            conexion = cn.conectar();
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO registro (informacion) VALUES (?)");
            ps.setString(1, informacion);
            ps.execute(); 
            ps.close(); 
            cn.cerrarconexion(); 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ComboBoxModel<String> hoarios(String UserName, String fechaC) {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> aux = new DefaultComboBoxModel<>();
        comboBoxModel.addElement("Escoge");
        ResultSet rs=null;
        for (int i = 8; i <= 16; i++) {
            String hora = i+":00";
            comboBoxModel.addElement(hora);
        }
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "select hora from cita where nombre_usuario = '" +UserName +"' and fechaC = '" +fechaC +"';";
            rs= smt.executeQuery(sql);
            while(rs.next()){
                aux.addElement(rs.getString(1));
                System.out.println(rs.getString(1));
                comboBoxModel = eliminarh(rs.getString(1),comboBoxModel);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }catch(NoSuchElementException x ){
            
        }
        return comboBoxModel;
    }

    private DefaultComboBoxModel<String> eliminarh(String string, DefaultComboBoxModel<String> comboBoxModel) {
        for (int i = 0; i < comboBoxModel.getSize(); i++) {
            if(string.equals(comboBoxModel.getElementAt(i))){
                comboBoxModel.removeElementAt(i);
            }
        }
        return comboBoxModel;
    }


}
