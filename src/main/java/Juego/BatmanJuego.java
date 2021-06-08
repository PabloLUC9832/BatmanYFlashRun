package Juego;

import Vista.PanelJuego;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

public class BatmanJuego{

	public PanelJuego miPanelJuego;

	public static boolean accionSaltar = false;
	public boolean accionSubir = false;
	public boolean accionBajar = false;

	//Variables que delimitaran al personaje
	public Area areaAdelante, areaAtras, areaCarroceria,areaPersonaje;
        
	//Tamaño
	public int anchoPersonaje = 115;
	public int altoPersonaje = 80;

	//Coordenadas iniciales
	public static int coordenadaX = 30;
	public static int coordenadaY = 270;

	//Coordenadas para jugarlo
	public int auxiliarX=0;
	public int auxiliarY=0;



	public BatmanJuego(PanelJuego miPanelJuego){

		this.miPanelJuego = miPanelJuego;		
	}

	public void moverPersonaje(){

		if (coordenadaX+auxiliarX>0 && coordenadaX+auxiliarX< miPanelJuego.getWidth()-anchoPersonaje){
			coordenadaX += auxiliarX;
		}							
		if (accionSaltar) {
			if (coordenadaY==270) { //cuando el personaje este en el sueño
				accionSubir = true;
				//auxiliarY =-2;
				auxiliarY =-4;  //VELOCIDAD DE SUBIDA
				accionBajar = false;
			}
			if (coordenadaY==150) {//limite de salto
				accionBajar = true;
				auxiliarY = 1;//2 //VELOCIDAD DE BAJADA
				//auxiliarY = 2;
				accionSubir = false;
			}
			if (accionSubir) {
				coordenadaY += auxiliarY;
			}
			if (accionBajar) {
				coordenadaY += auxiliarY;
				if (coordenadaY==270) { //Cuando regrese al suelo
					accionSaltar = false;
				}
			}
		}

	}

	public void paint(Graphics2D g){

            ImageIcon personajeImage = new ImageIcon(getClass().getResource("/img/batman.gif"));
            g.drawImage(personajeImage.getImage(),coordenadaX,coordenadaY,anchoPersonaje,altoPersonaje,null);
	}

	public void keyPressed(KeyEvent e){

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			accionSaltar = true;
		}
	}

	public Area getBounds(){

		Rectangle formal = new Rectangle(coordenadaX,coordenadaY,95,62);
		areaCarroceria = new Area(formal);

		Ellipse2D forma2 = new Ellipse2D.Double(coordenadaX,coordenadaY+28,48,48);
		areaAtras = new Area(forma2);

		Ellipse2D forma3 = new Ellipse2D.Double(coordenadaX+73,coordenadaY+39,38,38);
		areaAdelante = new Area(forma3);

		areaPersonaje = areaCarroceria;
		areaPersonaje.add(areaCarroceria);
		areaPersonaje.add(areaAtras);
		areaPersonaje.add(areaAdelante);

		return areaPersonaje;
	}


}
