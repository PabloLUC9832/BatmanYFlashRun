package Vista;

import Juego.BatmanJuego;
import Juego.EscenarioJuego;
import Juego.FlashJuego;
import Juego.ObstaculoJuego;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import  java.awt.Color;

public class PanelJuego extends JPanel{

	//Objetos de las clases
	public BatmanJuego batman = new BatmanJuego(this);
	public ObstaculoJuego obstaculo = new ObstaculoJuego(this);
	public EscenarioJuego escenario = new EscenarioJuego(this);
        public FlashJuego flash = new FlashJuego(this);

	public static boolean juegoFinalizar = false;
	public static boolean juegoRestarVidaBatman = false;
        public static boolean juegoRestarVidaFlash = false;
	public static int juegosCantidadVidasBatman = 5;
        public static int juegosCantidadVidasFlash = 5;;
        public static int juegosPuntuacion =0;
	public static int juegoNivel = 1;

	public PanelJuego(){
                
		this.addKeyListener(new KeyListener(){

                        @Override
			public void keyTyped(KeyEvent e){
			}

                        @Override
			public void keyPressed(KeyEvent e){
			//Al presionar la tecla SPACE, el personaje saltara
				if (e.getKeyCode()==KeyEvent.VK_SPACE) {
					batman.keyPressed(e);
				}
				else if (e.getKeyCode()==KeyEvent.VK_UP) {
					flash.keyPressed(e);
				}

			}

                        @Override
			public void keyReleased(KeyEvent e){

			}


		});
		this.setFocusable(true);

	}

	public void mover(){
		obstaculo.moverObstaculo();
		batman.moverPersonaje();
		escenario.moverEscenario();

		flash.moverPersonaje();
	}


        @Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		dibujar(g2);
		dibujarPuntaje(g2);
	}

	public void dibujar(Graphics2D g){
		escenario.paint(g);
		batman.paint(g);
		obstaculo.paint(g);
		flash.paint(g);
                mover();
	}

	public void dibujarPuntaje(Graphics2D g){
		Graphics2D g1 = g,g2 =g;
		Font score = new Font("Arial",Font.BOLD,30);
		g.setFont(score);
		g.setColor(Color.WHITE);
		g1.drawString("VIDAS BATMAN : "+ juegosCantidadVidasBatman,20,30);
                g1.drawString("VIDAS FLASH : "+ juegosCantidadVidasFlash,20,60);
		g1.drawString("NIVEL : "+ juegoNivel,570,30);
                g1.drawString("PUNTAJE: "+ juegosPuntuacion,1120,30);
		
                if (juegoFinalizar) {
			g2.setColor(Color.RED);
			g2.drawString("PERDISTE :(",((float)getBounds().getCenterX()/2)+170,70);

		}
	}

	public void finJuego(){
            juegoFinalizar = true;

	}

	public void perderVidaBatman(){
            juegoRestarVidaBatman = true;
	}

	public void perderVidaFlash(){
            juegoRestarVidaFlash = true;
	}
    }



