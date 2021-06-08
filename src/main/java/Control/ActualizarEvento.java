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

public class ActualizarEvento implements ActionListener{
    
    Ventana v;
    Connection c;
    
    public ActualizarEvento(Ventana v){
        this.v = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        v.visibilidad(true);
        if(e.getSource()==v.btnActualizar){
            
            int fila = v.tablaBusqueda.getSelectedRow();
                if(fila >= 0){
                    v.campoUsuario.setText(v.tablaBusqueda.getValueAt(fila, 0).toString());
                    v.campoPuntaje.setText(v.tablaBusqueda.getValueAt(fila, 1).toString());    
                    v.campoHora.setText(v.tablaBusqueda.getValueAt(fila, 2).toString());    
                    v.campoFecha.setText(v.tablaBusqueda.getValueAt(fila, 3).toString());    
                   
                }else{
                    JOptionPane.showMessageDialog(null, "Fila no seleccionada", " Error", JOptionPane.ERROR_MESSAGE);
                }
        
        }
        if(e.getSource()==v.btnEditar){
            c = SingletonConnection.getInstance();
            try{
                String sql = "UPDATE juego set nombre ='"+v.campoUsuario.getText()+"',puntuacion='"+v.campoPuntaje.getText()+"',hora='"+v.campoHora.getText()+"' WHERE fecha = '"+v.campoFecha.getText()+"'";
                PreparedStatement ps = c.prepareStatement(sql);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos Actualizados", " Actualizacion", JOptionPane.INFORMATION_MESSAGE);
                Tabla t = new Tabla(v);
                t.tablaBd();
                v.campoUsuario.setText("");
                v.campoPuntaje.setText("");
                v.campoHora.setText("");
                v.campoFecha.setText("");
            }catch (SQLException ee){
                System.out.println(ee);
            }
        }
        
    }
    
      
}

