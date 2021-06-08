package Control;

import Model.SingletonConnection;
import Model.Tabla;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EliminarEvento implements ActionListener{
    
    Ventana v;
    Connection c;
            
    public EliminarEvento(Ventana v){
        this.v=v;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
      c=SingletonConnection.getInstance();
      int fila = v.tablaBusqueda.getSelectedRow();
      String valor="";
      valor = v.tablaBusqueda.getValueAt(fila,0).toString();  
      String sql = "DELETE FROM juego WHERE nombre='"+valor+"'";  
      try{
          PreparedStatement ps = c.prepareStatement(sql);
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS EXITOSAMENTE");
          Tabla t = new Tabla(v);
          t.tablaBd();
          
      }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR AL ELIMINAR");
      }
      
      
    }
      
}
