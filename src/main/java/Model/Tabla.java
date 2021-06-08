package Model;

import Vista.Ventana;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class Tabla {
    
    Ventana v;
    Connection c;
     
    public Tabla(Ventana v){
        this.v = v;
    }
    
    public void tablaBd(){
        c = SingletonConnection.getInstance();
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PUNTUACIÓN");
        modelo.addColumn("FECHA");
        modelo.addColumn("HORA");
        
        v.tablaBusqueda.setModel(modelo);
        String sql = "";
        sql = "Select *from juego";
        
        String dato[] = new String [4];
        Statement st; 
        try{
            st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                dato[0] = rs.getString(1);
                dato[1] = rs.getString(2);
                dato[2] = rs.getString(3);
                dato[3] = rs.getString(4);
                
                modelo.addRow(dato);
            }
            v.tablaBusqueda.setModel(modelo);
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    
}

