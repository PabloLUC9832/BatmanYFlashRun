package Control;

import Vista.JuegoPrincipal;
import Model.SingletonConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuardarEvento {
    JuegoPrincipal jp;
    Connection c = null;
    PreparedStatement ps;
    Date fecha;
    
    public void Guardar(String nombre, int puntuacion){
       c = SingletonConnection.getInstance();
        fecha = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Hora: "+hourFormat.format(fecha));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Fecha: "+dateFormat.format(fecha));        
        try{
            ps = c.prepareStatement("INSERT INTO JUEGO (nombre,puntuacion,hora,fecha) VALUES(?,?,?,?)");
            ps.setString(1,nombre);
            ps.setInt(2,puntuacion);
            ps.setString(3,hourFormat.format(fecha));
            ps.setString(4,dateFormat.format(fecha));
            ps.executeUpdate();
            System.out.println("Ya quedo :)");
            
        }catch(SQLException j){
            System.out.println(j+"\nHey Fallo");
        }
    }
    
}


