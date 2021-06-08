package Control;

import Model.SingletonConnection;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteEvento implements ActionListener{

    Ventana v;
    Connection c;
    
    public ReporteEvento(Ventana v){
        this.v = v;
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] botones = {"PUNTAJES ALTOS", "JUGADORES"};	

        int seleccion = JOptionPane.showOptionDialog(null,"Selecciona el Reporte a imprimir:","REPORTES",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null,botones, botones[0]);        
        
        if(seleccion==0){
            reporte("1Puntaje","PUNTAJES ALTOS");
        }else{
            reporte("2Nombre","JUGADORES EN ORDEN ALFABÉTICO");
        }
       
    }
    
    void reporte(String ruta,String titulo){
            
        try{
            JasperReport archivo = JasperCompileManager.compileReport("report"+ruta+".jrxml");
            c = SingletonConnection.getInstance(); 
            JasperPrint print = JasperFillManager.fillReport(archivo,null,c);
            JasperViewer ver = new JasperViewer(print,false);
            ver.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            ver.setTitle("REPORTE "+titulo);
            ver.setVisible(true);            
            System.out.println("GUARDADO");
        }catch(Exception ex){
            System.err.print(ex.getMessage());
        }
            
        
    }
    
}
