package Control;

import Vista.JuegoPrincipal;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEvento implements ActionListener{
    
    public static JuegoPrincipal jp;
    
    public VentanaEvento(JuegoPrincipal jp){
       this.jp = jp;
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jp.ventanaCrud){
            Ventana v = new Ventana();
        }
    }

}
