import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Inimigo implements Runnable {

	// vai para a Interface
	private Point local;
	private Rectangle colisao;
	private ArrayList<Image> sprite; // abstract ?
	LoadArquivos carregar;
	protected int speed = 2;
	protected int teste = 0;
	protected AffineTransform transform = new AffineTransform();
	final long delay = 2;
	long rate = 0;
	int frame = 4;

	Thread envy;
	boolean run = false;

	public void run() {
		update();
	}

	public Point getLocal() {
		return local;
	}

	public void setLocal(Point local) {
		this.local = local;
	}

	public Rectangle getColisao() {
		return colisao;
	}

	public void setColisao(Rectangle colisao) {
		this.colisao = colisao;
	}

	public ArrayList<Image> getSprite() {
		return sprite;
	}

	public void setSprite(ArrayList<Image> sprite) {
		this.sprite = sprite;
	}

	// vai para a Interface
	public void movimento(String direcao) {

		if (direcao.equals("cima"))
			this.local.y -= speed;
		if (direcao.equals("baixo"))
			local.y += speed;
		if (direcao.equals("direita"))
			local.x += speed;
		if (direcao.equals("esquerda"))
			this.local.x -= speed;
	}

	public Inimigo() {
		carregar = new LoadArquivos();
		local = new Point(0, 0);
		sprite = new ArrayList<Image>();
		for (int i = 0; i < carregar.checkPasta("Inimigo"); i++)
			sprite.add(carregar.ImagemLoad(i));
	}

	// vai para a Interface
	public void draw(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		transform.setToIdentity();
		transform.translate(local.x, local.y);
		g2.drawImage(this.sprite.get(teste), transform, null);
		update();

	}

	// vai para a Interface
	private void update() {
		movimento("cima");
// Rate eh o contador de Frames.
		rate++;
		//delay é o tempo de espera até a proxima troca de Frame
		if (rate > delay) {
			rate = 0;
			// teste é o Frame Atual que está sendo desenhado
			teste += 1;
			//frame é a quantidade todal de sprites na animação.
			if (teste > frame - 1) {
				teste = 0;
			} else if (teste < 0) {
				teste = frame - 1;
			}
		}
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public synchronized void Start() {
		if (run)
			return;
		else {
			envy = new Thread(this);
			envy.start();
			run = true;
		}
	}
}
