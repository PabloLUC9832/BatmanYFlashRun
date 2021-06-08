package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonConnection {

    public static Connection conexion = null;
    public static Statement s = null;
    public static ResultSet rs=null;
    public static Integer id = 0;
    public SingletonConnection(){

    }

    public static Connection getInstance(){

        if(conexion == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/juego?serverTimezone=UTC","root","hola");  //hola            
                
                s = conexion.createStatement();
                rs = s.executeQuery("select puntuacion from juego");
                while(rs.next()){
                    id = rs.getInt("puntuacion");
                    System.out.print(id+" ");
                }
                System.out.println("\nCONECTADO\n");
            }catch(SQLException | ClassNotFoundException e){
                System.out.println("SIN CONEXION\n"+e);
            } 
        }
        return conexion;
    }

}

