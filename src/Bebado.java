import java.awt.Color;

class Bebado {
	public int x;
	public int y;
	public Color cor;
	public int tamanho;
	
	public Bebado(int tamanho ) {
		this.tamanho = tamanho;
	}
	
	public void walk() {
		int direcao = (int) (Math.random() * 4);
		
		switch (direcao) {
		case 0: 
			y -= tamanho;
			break;
		case 1:
			x += tamanho;
			break;
		case 2:
			y += tamanho;
			break;
		case 3:
			x -= tamanho;
			break;
		}
		
	}
	
	public void walk8Direcoes() {
		int direcao = (int) (Math.random() * 8);
		
		switch (direcao) {
		case 0:
			y -= tamanho;
			break;
		case 1:
			y -= tamanho;
			x += tamanho;
			break;
		case 2:
			x += tamanho;
			break;
		case 3:
			y += tamanho;
			x += tamanho;
			break;
		case 4:
			y += tamanho;
			break;
		case 5:
			y += tamanho;
			x -= tamanho;
			break;
		case 6:
			x -= tamanho;
			break;
		case 7:
			x -= tamanho;
			y -= tamanho;
			break;
		}
		
	}
}
