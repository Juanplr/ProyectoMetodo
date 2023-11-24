package Modelo;

import Controlador.Conector;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;


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

    public boolean verificarUsuarioAdmin(String usuario, String contrasena) {
        boolean verificacion =false;
        try {
               conexion = cn.conectar();
               Statement stm;
                String sql ="select * from admini " 
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
    public ResultSet getUsuarios() {
        ResultSet rs=null;
        try {
            conexion = cn.conectar();
            Statement smt;
            smt=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql= "SELECT nombre_usuario, rol, nombre_completo, cedula FROM usuarios;";
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
            String sql= "SELECT nombre_usuario, rol, nombre_completo, cedula  FROM usuarios where rol ='" +tipo +"';";
            rs= smt.executeQuery(sql);
            //cn.cerrarconexion();
        } catch (Exception e) {e.printStackTrace();}
        return rs;
    }

    
}
