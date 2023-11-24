package Modelo;

import java.sql.*;
import javax.swing.table.AbstractTableModel;

public class PersonalTableModel extends AbstractTableModel{
    
    ResultSet rs;
    public PersonalTableModel(){
    }
    public PersonalTableModel(ResultSet rs){
        this.rs = rs;
    }
    @Override
    public Object getValueAt(int ri, int ci){
        Object ob=null;
        try {
            rs.absolute(ri+1);
            ob= rs.getObject(ci+1);
        } catch (Exception e) {e.printStackTrace();}
        return ob;
    }
    @Override
    public int getRowCount() {
        int total =0;
        try {
            rs.last();
            total=rs.getRow();
        } catch (Exception e) {e.printStackTrace();}
        return total;
    }
    @Override
    public int getColumnCount() {
        int total =0;
        try {
            ResultSetMetaData rsmd= rs.getMetaData();
            total = rsmd.getColumnCount();
        } catch (Exception e) {e.printStackTrace();}
        return total;
    }
    public Class<?> getColumnClass(int ci){
        Class<?> c= null;
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            String name= rsmd.getColumnClassName(ci+1);
            c= Class.forName(name);
        } catch (Exception e) {e.printStackTrace();}
        return c;
    }
    public String getColumnName(int ci){
        String nombre = null;
        String name=null;
        try {
            ResultSetMetaData rsmd= rs.getMetaData();
            name = rsmd.getColumnName(ci+1);
        } catch (Exception e) {e.printStackTrace();}
        name = name.replaceAll("\\_", " ");
        return name;
    }
}