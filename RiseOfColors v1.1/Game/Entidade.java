import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Entidade {

	private int life;
	public Point posicao;
	private ArrayList<Rectangle2D> corpo;
	Estado movimentoAtual;
	public ArrayList<Image> anim;
	public LoadArquivos carregar;
	private final String tipoColisao = "Player";

	public int getLife() {
		return life;
	}

	public Entidade() {
		anim = new ArrayList<Image>();
		corpo = new ArrayList<Rectangle2D>();
		carregar = new LoadArquivos();

	}

	public void setLife(int life) {
		this.life = life;
	}

	public void CriarCorpo() {

		BufferedImage aux = null;
		for (int j = 0; j < carregar.checkPasta("Personagem"); j++) {
			aux = carregar.ImagemLoad(j);
			corpo.add(new Rectangle2D.Float(posicao.x, posicao.y, aux.getHeight(), aux.getWidth()));

			try {
				anim.add(aux);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, TratamentoDeErro.SendError(e));
			}
		}
	}

	public ArrayList<Rectangle2D> getCorpo() {
		return corpo;
	}

	public void setCorpo(ArrayList<Rectangle2D> corpo) {
		this.corpo = corpo;
	}

	public String getTipoColisao() {
		return tipoColisao;
	}

}
