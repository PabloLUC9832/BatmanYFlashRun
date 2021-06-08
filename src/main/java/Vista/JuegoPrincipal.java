package Vista;

import Control.GuardarEvento;
import Control.VentanaEvento;
import Juego.BatmanJuego;
import Juego.FlashJuego;
import Juego.ObstaculoJuego;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class JuegoPrincipal{

	public static int reiniciarJuego=-1; 
        
        public static String nombre;
        public static int puntuacion;
        
        public static JMenuBar mb;    
        public JMenu puntajes; 
        public JMenuItem ventanaCrud;
        
        public Ventana v;        
        
        public void JuegoPrincipal(){
                
            JFrame ventanaJuego = new JFrame("Batman y Flash Run");
            
                JMenuBar mb=new JMenuBar(); 
		JMenu puntajes = new JMenu("Puntajes");       
		
                ventanaCrud = new JMenuItem("Ventana CRUD");
                puntajes.add(ventanaCrud);
                
                mb.add(puntajes);
		ventanaJuego.add(mb);
		ventanaJuego.setJMenuBar(mb);
                
                VentanaEvento ve = new VentanaEvento(this);
                ventanaCrud.addActionListener(ve);
            
		PanelJuego miPanelJuego= new PanelJuego();

		ventanaJuego.add(miPanelJuego);
		ventanaJuego.setSize(1350,450);
		ventanaJuego.setLocationRelativeTo(null);
		ventanaJuego.setVisible(true);
                ventanaJuego.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                ventanaJuego.setLocationRelativeTo(null);	

    	while(true){

    		if (miPanelJuego.juegoFinalizar){
                        nombre = JOptionPane.showInputDialog(null, "Introduce tu  nombre: ");
                        puntuacion = miPanelJuego.juegosPuntuacion;
                        String [] botones = {"Guardar"};
                        int opcion = JOptionPane.showOptionDialog(null, "Tu nombre es: "+nombre+" y tu puntaje fue: "+puntuacion,"Gracias por jugar",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,botones,botones[0]);
                        
                        if(opcion == 0){
                            new GuardarEvento().Guardar(nombre,puntuacion);
                        }
    			
                        reiniciarJuego=JOptionPane.showConfirmDialog(null,"PERDISTE \n¿Desear jugar de nuevo?","PERDISTE",JOptionPane.YES_NO_OPTION);
    			if (reiniciarJuego==0) {
    				reiniciarValores();
    			}else if (reiniciarJuego==1) {
    				System.exit(0);
    			}
    		}else{

	    		miPanelJuego.repaint();
				try{
	      			Thread.sleep(10);
	    		} catch (InterruptedException e){
					System.out.println(e);
				}

				if (PanelJuego.juegoRestarVidaBatman==true) {
					PanelJuego.juegoRestarVidaBatman=false;
                                        PanelJuego.juegosCantidadVidasBatman--;
					BatmanJuego.coordenadaY=270;
					BatmanJuego.accionSaltar=false;
					ObstaculoJuego.coordenadaX=1300;
				}
                                
                                else if (PanelJuego.juegoRestarVidaFlash==true) {
					PanelJuego.juegoRestarVidaFlash=false;
                                        PanelJuego.juegosCantidadVidasFlash--;
					FlashJuego.coordenadaY=270;
					FlashJuego.accionSaltar=false;
					ObstaculoJuego.coordenadaX=1300;
				}

    		}

                
            }
            
        }

	public static void reiniciarValores(){

		PanelJuego.juegoFinalizar=false;
		ObstaculoJuego.auxiliarX=-4;
		PanelJuego.juegosPuntuacion=0;
		PanelJuego.juegoNivel=1;
                PanelJuego.juegosCantidadVidasBatman=5;
                PanelJuego.juegosCantidadVidasFlash=5;
		reiniciarJuego =-1;
		ObstaculoJuego.coordenadaX=1300;

	}
}