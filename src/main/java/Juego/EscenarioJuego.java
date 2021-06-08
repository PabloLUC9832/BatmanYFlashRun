package Juego;

import Vista.PanelJuego;
import java.awt.Graphics2D;
import java.net.URL;
import javax.swing.ImageIcon;

public class EscenarioJuego{

	public PanelJuego miPanelJuego;
      

	//Tamaño
	public int anchoFondo = 1300;
	public int altoFodno = 400;

	//Mover fondo
	public int x1= 1300;
	public int y1=0;

	//Coordenadas auxiliaras
	public int x2=0;
	public int y2=0;

	public EscenarioJuego(PanelJuego miPanelJuego){
		this.miPanelJuego = miPanelJuego;
	}

	public void moverEscenario(){
		x1-=2;
		x2-=2;
		if (x1==0 && x2 ==-1300) {
			x1=1300;
			x2=0;
		}
	}

	public void paint(Graphics2D g){
            
            ImageIcon fondoImage = new ImageIcon(getClass().getResource("/img/escenario.png"));
            g.drawImage(fondoImage.getImage(),x1,y1,anchoFondo,altoFodno,null);
            g.drawImage(fondoImage.getImage(),x2,y2,anchoFondo,altoFodno,null);  
            
	}
}
