import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame implements Runnable {
	
	private Dimension SIZE = new Dimension(500, 500);
	private final int QNT_BEBADOS = 4;
	private final int TAMANHO_BEBADOS = 10;
	private final int INTERVALO = 40;
	private Bebado[] bebados;
	private boolean fullScreen = true;
	
	public Main() {
		
		if(fullScreen)
			SIZE = Toolkit.getDefaultToolkit().getScreenSize();

		setSize(SIZE);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		bebados = new Bebado[QNT_BEBADOS];
		
		for (int i = 0; i < bebados.length; i++) {
			bebados[i] = new Bebado(TAMANHO_BEBADOS);
			bebados[i].x = SIZE.width/2;
			bebados[i].y = SIZE.height/2;
			bebados[i].cor = new Color((float)(Math.random()), (float)(Math.random()), (float)(Math.random()), 1);
		}
			
		
		Thread t1 = new Thread(this);
		t1.start();
		
	}
	
	private void drawBebados(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;

		for (Bebado b : bebados) {
			g2d.setColor(b.cor);
			g2d.fillOval(b.x, b.y, b.tamanho, b.tamanho);
		}
		
	}
	
	private void walkAllBebados() {
		for (int i = 0; i < bebados.length; i++) {
			bebados[i].walk8Direcoes();
		}
	}
	
	public void paint(Graphics g) {
		//super.paint(g);
		drawBebados(g);
	}
	

	@Override
	public void run() {
		
		while(true) {			
			walkAllBebados();
			
			try {
				Thread.sleep(INTERVALO);;
			}catch(InterruptedException e) { }
			
			repaint();			
		}		
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.setVisible(true);
	}
}
