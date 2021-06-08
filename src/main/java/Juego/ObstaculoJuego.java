package Juego;

import Vista.PanelJuego;
import java.awt.geom.Area;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class ObstaculoJuego{

	public PanelJuego miPanelJuego;
        
	//Variables que delimitaran al obstaculo
	public Area cabezaArea,cuerpoArea,ObstaculoArea;
	//Tamaño
	public int anchoObstaculo = 115;
	public int altoObstaculo = 80;

	//Coordenadas iniciales
	public static int coordenadaX = 1000;
	public static int coordenadaY = 270;

	//Coordenadas para jugarlo
	public static int auxiliarX=-4;

	public ObstaculoJuego(PanelJuego miPanelJuego){

		this.miPanelJuego = miPanelJuego;

	}

	public void moverObstaculo(){

		if (coordenadaX<=-100) {
                        miPanelJuego.juegosPuntuacion++;
                        miPanelJuego.juegosPuntuacion++;
			coordenadaX=1300;
			if (miPanelJuego.juegosPuntuacion==5 | miPanelJuego.juegosPuntuacion==10 | miPanelJuego.juegosPuntuacion == 15 | miPanelJuego.juegosPuntuacion == 20) {
				auxiliarX+=-2;
				miPanelJuego.juegoNivel++;
			}
		}else{
                        if (miPanelJuego.juegosCantidadVidasBatman==0 & miPanelJuego.juegosCantidadVidasFlash==0) {
					miPanelJuego.finJuego();
			}else{
                            
                        
                        //Batman
			if (colisionBatman()) {
				if (miPanelJuego.juegosCantidadVidasBatman==0) {
					BatmanJuego.coordenadaY=2000;
                                        
				}
                                else{
					miPanelJuego.perderVidaBatman();
				}
			}else{
				//coordenadaX+=auxiliarX; //<--
			}
                        
                         //Flash
			if (colisionFlash()) {
				if (miPanelJuego.juegosCantidadVidasFlash==0) {
					FlashJuego.coordenadaY=2000;
				}
                                else{
					miPanelJuego.perderVidaFlash();
				}
			}else{
				coordenadaX+=auxiliarX;
			}
                        
	}
                        
		}
	
	}

	public void paint(Graphics2D g){

          ImageIcon obstaculoImagen = new ImageIcon(getClass().getResource("/img/joker.gif"));
          g.drawImage(obstaculoImagen.getImage(),coordenadaX,coordenadaY,anchoObstaculo,altoObstaculo,null);

	}

	public Area getBounds(){

		Ellipse2D forma1 = new Ellipse2D.Double(coordenadaX,coordenadaY,40,40);
		Rectangle forma2 = new Rectangle(coordenadaX+12,coordenadaY+16,50,53);

		cabezaArea = new Area(forma1);
		cuerpoArea = new Area(forma2);

		ObstaculoArea = cabezaArea;		
		ObstaculoArea.add(cabezaArea);
		ObstaculoArea.add(cuerpoArea);

		return ObstaculoArea; 

	}

	public boolean colisionBatman(){

		Area areaA = new Area(miPanelJuego.batman.getBounds());
		areaA.intersect(getBounds());
		return !areaA.isEmpty();
                
	}
        
        public boolean colisionFlash(){
            
		Area areaB = new Area(miPanelJuego.flash.getBounds());
		areaB.intersect(getBounds());
		return !areaB.isEmpty();
                
        }

}